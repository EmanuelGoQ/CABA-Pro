package com.basketball.referee.api;

import com.basketball.referee.dto.TournamentDto;
import com.basketball.referee.dto.TournamentSummaryDto;
import com.basketball.referee.mapper.TournamentMapper;
import com.basketball.referee.service.TournamentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
@Tag(name = "Tournaments", description = "Basketball tournament management API")
public class TournamentRestController {

    private final TournamentService tournamentService;

    public TournamentRestController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    @Operation(summary = "Get all tournaments", description = "Returns a list of all tournaments")
    public List<TournamentSummaryDto> listAll() {
        return tournamentService.findAll().stream()
                .map(TournamentMapper::toSummary)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get tournament by ID", description = "Returns detailed information about a specific tournament")
    public ResponseEntity<TournamentDto> getById(
            @Parameter(description = "Tournament ID") @PathVariable Long id) {
        return tournamentService.findById(id)
                .map(TournamentMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    @Operation(summary = "Get active tournaments", description = "Returns a list of all active tournaments")
    public List<TournamentSummaryDto> listActive() {
        return tournamentService.findAllActive().stream()
                .map(TournamentMapper::toSummary)
                .toList();
    }

    @GetMapping("/current")
    @Operation(summary = "Get current tournaments", description = "Returns tournaments currently in progress")
    public List<TournamentSummaryDto> listCurrent() {
        return tournamentService.findCurrentTournaments().stream()
                .map(TournamentMapper::toSummary)
                .toList();
    }
}

package com.basketball.referee.api;

import com.basketball.referee.dto.MatchDto;
import com.basketball.referee.dto.MatchSummaryDto;
import com.basketball.referee.mapper.MatchMapper;
import com.basketball.referee.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Matches", description = "Basketball match management API")
public class MatchRestController {

    private final MatchService matchService;

    public MatchRestController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    @Operation(summary = "Get all matches", description = "Returns a list of all matches")
    public List<MatchSummaryDto> listAll() {
        return matchService.findAll().stream()
                .map(MatchMapper::toSummary)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get match by ID", description = "Returns detailed information about a specific match")
    public ResponseEntity<MatchDto> getById(
            @Parameter(description = "Match ID") @PathVariable Long id) {
        return matchService.findById(id)
                .map(MatchMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/upcoming")
    @Operation(summary = "Get upcoming matches", description = "Returns matches scheduled from today onwards")
    public List<MatchSummaryDto> listUpcoming() {
        return matchService.findUpcomingMatches().stream()
                .map(MatchMapper::toSummary)
                .toList();
    }

    @GetMapping("/range")
    @Operation(summary = "Get matches by date range", description = "Returns matches within a specified date range")
    public List<MatchSummaryDto> listByDateRange(
            @Parameter(description = "Start date (yyyy-MM-dd)") 
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @Parameter(description = "End date (yyyy-MM-dd)") 
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);
        return matchService.findByDateRange(start, end).stream()
                .map(MatchMapper::toSummary)
                .toList();
    }

    @GetMapping("/referee/{refereeId}")
    @Operation(summary = "Get matches by referee", description = "Returns matches assigned to a specific referee")
    public List<MatchSummaryDto> listByReferee(
            @Parameter(description = "Referee ID") @PathVariable Long refereeId) {
        return matchService.findByReferee(refereeId).stream()
                .map(MatchMapper::toSummary)
                .toList();
    }

    @GetMapping("/tournament/{tournamentId}")
    @Operation(summary = "Get matches by tournament", description = "Returns matches for a specific tournament")
    public List<MatchSummaryDto> listByTournament(
            @Parameter(description = "Tournament ID") @PathVariable Long tournamentId) {
        return matchService.findByTournament(tournamentId).stream()
                .map(MatchMapper::toSummary)
                .toList();
    }
}

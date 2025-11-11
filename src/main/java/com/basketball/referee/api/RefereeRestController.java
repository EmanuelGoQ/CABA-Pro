package com.basketball.referee.api;

import com.basketball.referee.dto.RefereeDetailDto;
import com.basketball.referee.dto.RefereeSummaryDto;
import com.basketball.referee.mapper.RefereeMapper;
import com.basketball.referee.service.RefereeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/referees")
@Tag(name = "Referees", description = "Basketball referee management API")
public class RefereeRestController {

    private final RefereeService refereeService;

    public RefereeRestController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    @GetMapping
    @Operation(summary = "Get all referees", description = "Returns a list of all referees in the system")
    public List<RefereeSummaryDto> listAll() {
        return refereeService.findAll().stream()
                .map(RefereeMapper::toSummary)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get referee by ID", description = "Returns detailed information about a specific referee")
    public ResponseEntity<RefereeDetailDto> getById(
            @Parameter(description = "Referee ID") @PathVariable Long id) {
        return refereeService.findById(id)
                .map(RefereeMapper::toDetail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    @Operation(summary = "Get active referees", description = "Returns a list of all active referees")
    public List<RefereeSummaryDto> listActive() {
        return refereeService.findAllActive().stream()
                .map(RefereeMapper::toSummary)
                .toList();
    }

    @GetMapping("/rank/{rank}")
    @Operation(summary = "Get referees by rank", description = "Returns referees filtered by rank")
    public List<RefereeSummaryDto> getByRank(
            @Parameter(description = "Referee rank (NATIONAL, STATE, MUNICIPAL, LOCAL)") 
            @PathVariable String rank) {
        return refereeService.findByFilters(null, rank, null, null).stream()
                .map(RefereeMapper::toSummary)
                .toList();
    }

    @GetMapping("/specialty/{specialty}")
    @Operation(summary = "Get referees by specialty", description = "Returns referees filtered by specialty")
    public List<RefereeSummaryDto> getBySpecialty(
            @Parameter(description = "Referee specialty (FEMININE, MASCULINE, BOTH)") 
            @PathVariable String specialty) {
        return refereeService.findByFilters(null, null, specialty, null).stream()
                .map(RefereeMapper::toSummary)
                .toList();
    }

    @GetMapping("/top")
    @Operation(summary = "Get top referees", description = "Returns top referees by average score")
    public List<RefereeSummaryDto> getTopReferees(
            @Parameter(description = "Number of referees to return") 
            @RequestParam(defaultValue = "10") int limit) {
        return refereeService.findTopRefereesByAverageScore(limit).stream()
                .map(RefereeMapper::toSummary)
                .toList();
    }
}

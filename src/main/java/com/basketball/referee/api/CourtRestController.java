package com.basketball.referee.api;

import com.basketball.referee.dto.CourtDto;
import com.basketball.referee.mapper.CourtMapper;
import com.basketball.referee.service.CourtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courts")
@Tag(name = "Courts", description = "Basketball court management API")
public class CourtRestController {

    private final CourtService courtService;

    public CourtRestController(CourtService courtService) {
        this.courtService = courtService;
    }

    @GetMapping
    @Operation(summary = "Get all courts", description = "Returns a list of all courts")
    public List<CourtDto> listAll() {
        return courtService.findAll().stream()
                .map(CourtMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get court by ID", description = "Returns detailed information about a specific court")
    public ResponseEntity<CourtDto> getById(
            @Parameter(description = "Court ID") @PathVariable Long id) {
        return courtService.findById(id)
                .map(CourtMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    @Operation(summary = "Get active courts", description = "Returns a list of all active courts")
    public List<CourtDto> listActive() {
        return courtService.findAllActive().stream()
                .map(CourtMapper::toDto)
                .toList();
    }

    @GetMapping("/city/{city}")
    @Operation(summary = "Get courts by city", description = "Returns courts filtered by city")
    public List<CourtDto> getByCity(
            @Parameter(description = "City name") @PathVariable String city) {
        return courtService.findByCity(city).stream()
                .map(CourtMapper::toDto)
                .toList();
    }
}

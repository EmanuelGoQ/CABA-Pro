package com.basketball.referee.api;

import com.basketball.referee.dto.RefereeDetailDto;
import com.basketball.referee.dto.RefereeSummaryDto;
import com.basketball.referee.mapper.RefereeMapper;
import com.basketball.referee.service.RefereeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/referees")
public class RefereeRestController {

    private final RefereeService refereeService;

    public RefereeRestController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    @GetMapping
    public List<RefereeSummaryDto> listAll() {
        return refereeService.findAll().stream()
                .map(RefereeMapper::toSummary)
                .toList();
    }

    @GetMapping("/{id}")
    public RefereeDetailDto getById(@PathVariable Long id) {
        return refereeService.findById(id)
                .map(RefereeMapper::toDetail)
                .orElseThrow(() -> new RuntimeException("Referee not found"));
    }
}

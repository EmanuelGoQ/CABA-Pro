package com.basketball.referee.api;

import com.basketball.referee.dto.StatisticsDto;
import com.basketball.referee.model.Match;
import com.basketball.referee.model.MatchAssignment;
import com.basketball.referee.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
@Tag(name = "Statistics", description = "System statistics and metrics API")
public class StatisticsRestController {

    private final RefereeService refereeService;
    private final TournamentService tournamentService;
    private final CourtService courtService;
    private final MatchService matchService;
    private final MatchAssignmentService assignmentService;

    public StatisticsRestController(
            RefereeService refereeService,
            TournamentService tournamentService,
            CourtService courtService,
            MatchService matchService,
            MatchAssignmentService assignmentService) {
        this.refereeService = refereeService;
        this.tournamentService = tournamentService;
        this.courtService = courtService;
        this.matchService = matchService;
        this.assignmentService = assignmentService;
    }

    @GetMapping
    @Operation(summary = "Get system statistics", description = "Returns comprehensive statistics about the system")
    public StatisticsDto getStatistics() {
        StatisticsDto stats = new StatisticsDto();
        
        stats.setTotalReferees(refereeService.countActive());
        stats.setTotalTournaments(tournamentService.countActive());
        stats.setTotalCourts(courtService.countActive());
        stats.setMatchesProgrammed(matchService.countByState(Match.MatchState.PROGRAMMED));
        stats.setAssignmentsPending(assignmentService.countByState(MatchAssignment.AssignmentState.PENDING));
        stats.setAssignmentsAccepted(assignmentService.countByState(MatchAssignment.AssignmentState.ACCEPTED));
        stats.setAssignmentsRejected(assignmentService.countByState(MatchAssignment.AssignmentState.REJECTED));
        stats.setAssignmentsCompleted(assignmentService.countByState(MatchAssignment.AssignmentState.COMPLETED));
        
        return stats;
    }
}

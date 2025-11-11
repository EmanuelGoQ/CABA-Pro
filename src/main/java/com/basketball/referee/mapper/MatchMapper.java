package com.basketball.referee.mapper;

import com.basketball.referee.dto.MatchDto;
import com.basketball.referee.dto.MatchSummaryDto;
import com.basketball.referee.model.Match;

import java.util.stream.Collectors;

public class MatchMapper {

    public static MatchDto toDto(Match m) {
        MatchDto dto = new MatchDto();
        dto.setId(m.getId());
        dto.setLocalTeam(m.getLocalTeam());
        dto.setVisitorTeam(m.getVisitorTeam());
        dto.setDateHour(m.getDateHour());
        dto.setState(m.getState() != null ? m.getState().name() : null);
        dto.setLocalResult(m.getLocalResult());
        dto.setVisitorResult(m.getVisitorResult());
        dto.setObservations(m.getObservations());
        
        if (m.getTournament() != null) {
            dto.setTournament(TournamentMapper.toSummary(m.getTournament()));
        }
        
        if (m.getCourt() != null) {
            dto.setCourt(CourtMapper.toDto(m.getCourt()));
        }
        
        if (m.getAssignments() != null) {
            dto.setAssignments(m.getAssignments().stream()
                .map(MatchAssignmentMapper::toDto)
                .collect(Collectors.toList()));
        }
        
        return dto;
    }

    public static MatchSummaryDto toSummary(Match m) {
        MatchSummaryDto dto = new MatchSummaryDto();
        dto.setId(m.getId());
        dto.setLocalTeam(m.getLocalTeam());
        dto.setVisitorTeam(m.getVisitorTeam());
        dto.setDateHour(m.getDateHour());
        dto.setState(m.getState() != null ? m.getState().name() : null);
        return dto;
    }
}

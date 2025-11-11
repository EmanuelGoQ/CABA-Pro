package com.basketball.referee.mapper;

import com.basketball.referee.dto.TournamentDto;
import com.basketball.referee.dto.TournamentSummaryDto;
import com.basketball.referee.model.Tournament;

public class TournamentMapper {

    public static TournamentDto toDto(Tournament t) {
        TournamentDto dto = new TournamentDto();
        dto.setId(t.getId());
        dto.setName(t.getName());
        dto.setDescription(t.getDescription());
        dto.setStartDate(t.getStartDate());
        dto.setEndDate(t.getEndDate());
        dto.setState(t.getState() != null ? t.getState().name() : null);
        dto.setActive(t.isActive());
        return dto;
    }

    public static TournamentSummaryDto toSummary(Tournament t) {
        TournamentSummaryDto dto = new TournamentSummaryDto();
        dto.setId(t.getId());
        dto.setName(t.getName());
        dto.setStartDate(t.getStartDate());
        dto.setEndDate(t.getEndDate());
        dto.setState(t.getState() != null ? t.getState().name() : null);
        return dto;
    }
}

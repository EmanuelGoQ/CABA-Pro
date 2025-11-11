package com.basketball.referee.mapper;

import com.basketball.referee.dto.MatchAssignmentDto;
import com.basketball.referee.model.MatchAssignment;

public class MatchAssignmentMapper {

    public static MatchAssignmentDto toDto(MatchAssignment a) {
        MatchAssignmentDto dto = new MatchAssignmentDto();
        dto.setId(a.getId());
        dto.setRefereeRole(a.getRole() != null ? a.getRole().name() : null);
        dto.setState(a.getState() != null ? a.getState().name() : null);
        dto.setResponseDate(a.getResponseDate());
        dto.setComments(a.getComments());
        
        if (a.getReferee() != null) {
            dto.setReferee(RefereeMapper.toSummary(a.getReferee()));
        }
        
        return dto;
    }
}

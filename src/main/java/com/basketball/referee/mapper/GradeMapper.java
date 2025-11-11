package com.basketball.referee.mapper;

import com.basketball.referee.dto.GradeDto;
import com.basketball.referee.model.Grade;

public class GradeMapper {

    public static GradeDto toDto(Grade g) {
        GradeDto dto = new GradeDto();
        dto.setId(g.getId());
        dto.setScore(g.getScore());
        dto.setComments(g.getComments());
        dto.setCreatedAt(g.getCreatedAt());
        
        if (g.getReferee() != null) {
            dto.setReferee(RefereeMapper.toSummary(g.getReferee()));
        }
        
        return dto;
    }
}

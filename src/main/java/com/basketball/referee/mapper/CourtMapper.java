package com.basketball.referee.mapper;

import com.basketball.referee.dto.CourtDto;
import com.basketball.referee.model.Court;

public class CourtMapper {

    public static CourtDto toDto(Court c) {
        CourtDto dto = new CourtDto();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setAddress(c.getAddress());
        dto.setCity(c.getCity());
        dto.setPhone(c.getPhone());
        dto.setActive(c.isActive());
        return dto;
    }
}

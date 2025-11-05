package com.basketball.referee.mapper;

import com.basketball.referee.dto.RefereeSummaryDto;
import com.basketball.referee.dto.RefereeDetailDto;
import com.basketball.referee.model.Referee;

public class RefereeMapper {

    public static RefereeSummaryDto toSummary(Referee r) {
        RefereeSummaryDto dto = new RefereeSummaryDto();
        dto.setId(r.getId());
        dto.setFullName(r.getUser().getFirstName() + " " + r.getUser().getLastName());
        dto.setRank(r.getRank().name());
        dto.setSpecialty(r.getSpecialty().name());
        return dto;
    }

    public static RefereeDetailDto toDetail(Referee r) {
        RefereeDetailDto dto = new RefereeDetailDto();
        dto.setId(r.getId());
        dto.setFirstName(r.getUser().getFirstName());
        dto.setLastName(r.getUser().getLastName());
        dto.setDocument(r.getDocument());
        dto.setEmail(r.getUser().getEmail());
        dto.setPhone(r.getPhone());
        dto.setRank(r.getRank().name());
        dto.setSpecialty(r.getSpecialty().name());
        dto.setPhotoUrl(r.getUrlPhoto());
        return dto;
    }
}

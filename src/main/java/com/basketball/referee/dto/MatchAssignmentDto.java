package com.basketball.referee.dto;

import java.time.LocalDateTime;

public class MatchAssignmentDto {
    private Long id;
    private RefereeSummaryDto referee;
    private String refereeRole;
    private String state;
    private LocalDateTime responseDate;
    private String comments;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RefereeSummaryDto getReferee() {
        return referee;
    }

    public void setReferee(RefereeSummaryDto referee) {
        this.referee = referee;
    }

    public String getRefereeRole() {
        return refereeRole;
    }

    public void setRefereeRole(String refereeRole) {
        this.refereeRole = refereeRole;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

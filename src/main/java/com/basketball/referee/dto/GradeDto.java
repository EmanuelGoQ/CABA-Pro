package com.basketball.referee.dto;

import java.time.LocalDateTime;

public class GradeDto {
    private Long id;
    private RefereeSummaryDto referee;
    private Integer score;
    private String comments;
    private LocalDateTime createdAt;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

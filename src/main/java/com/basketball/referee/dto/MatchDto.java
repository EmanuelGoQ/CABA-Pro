package com.basketball.referee.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MatchDto {
    private Long id;
    private String localTeam;
    private String visitorTeam;
    private LocalDateTime dateHour;
    private String state;
    private Integer localResult;
    private Integer visitorResult;
    private String observations;
    private TournamentSummaryDto tournament;
    private CourtDto court;
    private List<MatchAssignmentDto> assignments;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(String localTeam) {
        this.localTeam = localTeam;
    }

    public String getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(String visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getLocalResult() {
        return localResult;
    }

    public void setLocalResult(Integer localResult) {
        this.localResult = localResult;
    }

    public Integer getVisitorResult() {
        return visitorResult;
    }

    public void setVisitorResult(Integer visitorResult) {
        this.visitorResult = visitorResult;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public TournamentSummaryDto getTournament() {
        return tournament;
    }

    public void setTournament(TournamentSummaryDto tournament) {
        this.tournament = tournament;
    }

    public CourtDto getCourt() {
        return court;
    }

    public void setCourt(CourtDto court) {
        this.court = court;
    }

    public List<MatchAssignmentDto> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<MatchAssignmentDto> assignments) {
        this.assignments = assignments;
    }
}

package com.basketball.referee.dto;

public class StatisticsDto {
    private long totalReferees;
    private long totalTournaments;
    private long totalCourts;
    private long matchesProgrammed;
    private long assignmentsPending;
    private long assignmentsAccepted;
    private long assignmentsRejected;
    private long assignmentsCompleted;

    // Getters and Setters
    public long getTotalReferees() {
        return totalReferees;
    }

    public void setTotalReferees(long totalReferees) {
        this.totalReferees = totalReferees;
    }

    public long getTotalTournaments() {
        return totalTournaments;
    }

    public void setTotalTournaments(long totalTournaments) {
        this.totalTournaments = totalTournaments;
    }

    public long getTotalCourts() {
        return totalCourts;
    }

    public void setTotalCourts(long totalCourts) {
        this.totalCourts = totalCourts;
    }

    public long getMatchesProgrammed() {
        return matchesProgrammed;
    }

    public void setMatchesProgrammed(long matchesProgrammed) {
        this.matchesProgrammed = matchesProgrammed;
    }

    public long getAssignmentsPending() {
        return assignmentsPending;
    }

    public void setAssignmentsPending(long assignmentsPending) {
        this.assignmentsPending = assignmentsPending;
    }

    public long getAssignmentsAccepted() {
        return assignmentsAccepted;
    }

    public void setAssignmentsAccepted(long assignmentsAccepted) {
        this.assignmentsAccepted = assignmentsAccepted;
    }

    public long getAssignmentsRejected() {
        return assignmentsRejected;
    }

    public void setAssignmentsRejected(long assignmentsRejected) {
        this.assignmentsRejected = assignmentsRejected;
    }

    public long getAssignmentsCompleted() {
        return assignmentsCompleted;
    }

    public void setAssignmentsCompleted(long assignmentsCompleted) {
        this.assignmentsCompleted = assignmentsCompleted;
    }
}

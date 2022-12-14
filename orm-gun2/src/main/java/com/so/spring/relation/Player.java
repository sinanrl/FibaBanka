package com.so.spring.relation;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerId;
    private String playerName;
    private double averageScore;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(long playerId, String playerName, double averageScore, Team team) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.averageScore = averageScore;
        this.team = team;
    }

    public Player() {

    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

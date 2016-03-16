package com.midsem_PCSMA;

import org.springframework.data.annotation.Id;

public class CricUpdate {
	
	private String team1;	
	private int scores1;
	private String team2;
	private int scores2;
	
	private String winner;
	@Id
	private String date;
	private String playerOfMatch;
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public int getScores1() {
		return scores1;
	}
	public void setScores1(int scores1) {
		this.scores1 = scores1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public int getScores2() {
		return scores2;
	}
	public void setScores2(int scores2) {
		this.scores2 = scores2;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlayerOfMatch() {
		return playerOfMatch;
	}
	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}

}

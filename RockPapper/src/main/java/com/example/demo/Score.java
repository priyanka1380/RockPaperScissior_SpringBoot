package com.example.demo;

public class Score {
	int wins;
	int ties;
	int losses;
	
	public Score() {}
	
	public Score(int wins, int ties, int losses) {
		super();
		this.wins = wins;
		this.ties = ties;
		this.losses = losses;
	}
	
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getTies() {
		return ties;
	}
	public void setTies(int ties) {
		this.ties = ties;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	

}

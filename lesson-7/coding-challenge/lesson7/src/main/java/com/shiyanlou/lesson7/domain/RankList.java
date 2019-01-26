package com.shiyanlou.lesson7.domain;

public class RankList {

	private int sumConsumeEnergy;
	private int userId;
	
	public RankList() {
		// TODO Auto-generated constructor stub
	}

	public RankList(int sumConsumeEnergy, int userId) {
		super();
		this.sumConsumeEnergy = sumConsumeEnergy;
		this.userId = userId;
	}

	public int getSumConsumeEnergy() {
		return sumConsumeEnergy;
	}

	public void setSumConsumeEnergy(int sumConsumeEnergy) {
		this.sumConsumeEnergy = sumConsumeEnergy;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RankList [sumConsumeEnergy=" + sumConsumeEnergy + ", userId=" + userId + "]";
	}

}

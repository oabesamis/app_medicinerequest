package com.pw.requestmed.beans;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int marketCircleId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getMarketCircleId() {
		return marketCircleId;
	}
	public void setMarketCircleId(int marketCircleId) {
		this.marketCircleId = marketCircleId;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id : "+id);
		sb.append(", FirstName : "+firstName);
		sb.append(", LastName : "+lastName);
		sb.append(", MarketCircleId : "+marketCircleId);
		
		return sb.toString();
	}
}

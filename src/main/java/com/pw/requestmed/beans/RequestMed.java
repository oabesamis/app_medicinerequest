package com.pw.requestmed.beans;

import java.sql.Timestamp;

public class RequestMed {
	private int requestId;
	private Medicine medicine;
	private Symptom symptom;
	private Status status;
	private Timestamp createTs;
	private Timestamp lastUpdateTs;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Symptom getSymptom() {
		return symptom;
	}
	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Timestamp getCreateTs() {
		return createTs;
	}
	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}
	public Timestamp getLastUpdateTs() {
		return lastUpdateTs;
	}
	public void setLastUpdateTs(Timestamp lastUpdateTs) {
		this.lastUpdateTs = lastUpdateTs;
	}
}

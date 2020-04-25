package com.employee.testscotia.models;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class TitlePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="emp_no", insertable=false, updatable=false)
	private int empNo;

	private String title;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private java.util.Date fromDate;

	public TitlePK() {
	}
	public int getEmpNo() {
		return this.empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.util.Date getFromDate() {
		return this.fromDate;
	}
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TitlePK)) {
			return false;
		}
		TitlePK castOther = (TitlePK)other;
		return 
			(this.empNo == castOther.empNo)
			&& this.title.equals(castOther.title)
			&& this.fromDate.equals(castOther.fromDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empNo;
		hash = hash * prime + this.title.hashCode();
		hash = hash * prime + this.fromDate.hashCode();
		
		return hash;
	}
	@Override
	public String toString() {
		return "TitlePK [empNo=" + empNo + ", title=" + title + ", fromDate=" + fromDate + "]";
	}
	
	
}
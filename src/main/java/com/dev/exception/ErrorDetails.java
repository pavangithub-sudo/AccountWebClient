package com.dev.exception;

public class ErrorDetails {
	
	public String field;
	public String value;
	public String issue;
	public String location;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ErrorDetails(String field, String value, String issue, String location) {
		super();
		this.field = field;
		this.value = value;
		this.issue = issue;
		this.location = location;
	}
	
	

}

package com.prog.entity;
public class movieFeedbackCollector {
	private String mood1;
	private String msgfeedback;
	private String MRSNumber;
	public String getMRSNumber() {
		return MRSNumber;
	}

	public void setMRSNumber(String MRSNumber) {
		this.MRSNumber = MRSNumber;
	}
	
	public String getMood1() {
		return mood1;
	}
	public void setMood1(String mood1) {
		this.mood1 = mood1;
	}
	
	public String getMsgfeedback() {
		return msgfeedback;
	}
	public void setMsgfeedback(String msgfeedback) {
		this.msgfeedback = msgfeedback;
	}
	@Override
	public String toString() {
		return "sys3 [emoji=" + mood1 + ", msgfeedback=" + msgfeedback + "]";
	}
	public movieFeedbackCollector() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addAttribute(String string, String buttonValue) {
		// TODO Auto-generated method stub
		this.mood1=buttonValue;
	}
}

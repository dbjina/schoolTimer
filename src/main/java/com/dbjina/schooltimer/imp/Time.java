package com.dbjina.schooltimer.imp;

import java.util.Calendar;

public class Time {
	private int hour;
	private int minute;
	
	public Time() {
		this.hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		this.minute = Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public void increaseMinute(int minute) {
		if((this.minute + minute) >= 60) {
			increaseHour((this.minute + minute) / 60);
			setMinute(getMinute() - 60 + minute);
		}
		else {
			setMinute(getMinute() + minute);
		}
	}
	
	public void decreaseMinute(int minute) {
		if((this.minute - minute) < 0) {
			// TODO
		}
		else {
			setMinute(getMinute() - minute);
		}
	}
	
	public void increaseHour(int hour) {
		if((this.hour + hour) >= 24) {
			setHour(getHour() - 24 + hour);
		}
		else {
			setHour(getHour() + hour);
		}
	}
	
	public void decreaseHour(int hour) {
		if((this.hour + hour) >= 24) {
			// TODO
		}
		else {
			setHour(getHour() - hour);
		}
	}
	
	@Override
	public String toString() {
		return this.getHour() + ":" + this.getMinute();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Time)) {
			return false;
		}
		
		Time time = (Time)obj;
		
		if(time.getHour() == this.getHour() && time.getMinute() == this.getMinute()) {
			return true;
		}
		
		return false;
	}
}

package com.dbjina.schooltimer.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Schedule {
	private static Schedule instance = new Schedule();
	
	private Schedule() {
		headers = new Vector<String>();
		contents = new Vector<Vector<String>>();
		alramList = new ArrayList<>();
		
		headers.add("교시");
		headers.add("시작");
		headers.add("끝");
		
		setHeaders(headers);
		setContents(contents);
	}
	
	public static Schedule getInstance() {
		return instance;
	}
	
	private Vector<String> headers;
	private Vector<Vector<String>> contents;
	private List<Time> alramList;
	private Thread thread;
	
	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public List<Time> getAlramList() {
		return alramList;
	}

	public void setAlramList(List<Time> alramList) {
		this.alramList = alramList;
	}

	public Vector<String> getHeaders() {
		return headers;
	}

	public Vector<Vector<String>> getContents() {
		return contents;
	}

	public void setHeaders(Vector<String> headers) {
		this.headers = headers;
	}

	public void setContents(Vector<Vector<String>> contents) {
		this.contents = contents;
	}

	public DefaultTableModel getScheduleModel() {
		Setting setting = Setting.getInstance();
		Time startTime = new Time(setting.getStartHour(), setting.getStartMin());
		
		int totalCount;
		
		totalCount = setting.getMorningSubjectCount() + setting.getAfternoonSubjectCount();
		alramList = new ArrayList<>();
		
		Vector<String> row;
		contents = new Vector<>();
		
		for(int i=0, index=1; i<totalCount; i++, index++) {
			row = new Vector<>();
			if(i == setting.getMorningSubjectCount() && (setting.getLunchHour() != 0 || setting.getLunchMin() != 0 )) {
				row.addElement("점심");
				
				// 시작 시간
				row.addElement(startTime.toString());
				alramList.add(new Time(startTime.getHour(), startTime.getMinute()));
				
				startTime.increaseHour(setting.getLunchHour());
				startTime.increaseMinute(setting.getLunchMin());
				
				// 종료 시간
				row.addElement(startTime.toString());
				alramList.add(new Time(startTime.getHour(), startTime.getMinute()));
				
				index--;
				totalCount++;
			}
			else {
				row.addElement("" + index);
				
				// 시작 시간
				row.addElement(startTime.toString());
				alramList.add(new Time(startTime.getHour(), startTime.getMinute()));
				
				startTime.increaseHour(setting.getStudyingHour());
				startTime.increaseMinute(setting.getStudyingMin());

				// 종료 시간
				row.addElement(startTime.toString());
				alramList.add(new Time(startTime.getHour(), startTime.getMinute()));
				
				startTime.increaseMinute(setting.getBreakingTime());
			}
			
			contents.addElement(row);
		}
		
		DefaultTableModel model = new DefaultTableModel(contents, headers) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1741849810854321122L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		return model;
//		return new DefaultTableModel(contents, headers);
	}
}
 
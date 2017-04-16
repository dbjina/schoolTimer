package com.dbjina.schooltimer.imp;

import java.util.List;
import java.util.prefs.Preferences;

import com.dbjina.schooltimer.SchoolTimerApp;

public class Setting_Backup {
	private static Setting_Backup instance = new Setting_Backup();

	private Setting_Backup() {
		boolean isFirstInit = Boolean.parseBoolean(pref.get("firstInit", "true"));		
		System.out.println("Setting.class, startHour : " + pref.get("startHour", "null"));
		
		if(isFirstInit) {
			System.out.println("isFirstInit : " + isFirstInit);
			pref.put("firstInit", "false");
		}
		
		// System Property 에 저장된 모든 값들을 Class Property에 설정 합니다.
		loadAll();
	}

	public static Setting_Backup getInstance() {
		return instance;
	}

	private Preferences pref = Preferences.userNodeForPackage(SchoolTimerApp.class);

	private int startHour = 9; // 수업 시작 시간(0 ~ 23)
	private int startMin = 0; // 수업 시작 분(0 ~ 59)

	private int morningSubjectCount = 4; // 오전 과목 갯수
	private int afternoonSubjectCount = 4; // 오후 과목 갯수

	private int studyingHour = 0; // 수업 시간(시간)
	private int studyingMin = 50; // 수업 시간(분)

	private int breakingTime = 10; // 쉬는 시간(분)

	private int lunchHour = 0; // 점심 시간(시간)
	private int lunchMin = 50; // 점심 시간(분)

	private int dinnerHour = 0; // 저녁 시간(시간)
	private int dinnerMin = 0; // 저녁 시간(분)

	private String breakingBell; // 쉬는 시간 종소리 (파일명)
	private String mealBell; // 식사 시간 종소리 (파일명)

	private List<String> soundFileList; // 사운드 파일 AbsolutePath 리스트

	private void setProperty(String key, int value) {
		setProperty(key, String.valueOf(value));
	}

	private void setProperty(String key, String value) {
		pref.put(key, value);
	}

	private String getProperty(String key) {
		String value = pref.get(key, null);
		if (value != null) {
			return value;
		}
		return "-1";
	}

	public int getStartHour() {
		return startHour;
	}

	public int getStartMin() {
		return startMin;
	}

	public int getMorningSubjectCount() {
		return morningSubjectCount;
	}

	public int getAfternoonSubjectCount() {
		return afternoonSubjectCount;
	}

	public int getStudyingHour() {
		return studyingHour;
	}

	public int getStudyingMin() {
		return studyingMin;
	}

	public int getBreakingTime() {
		return breakingTime;
	}

	public int getLunchHour() {
		return lunchHour;
	}

	public int getLunchMin() {
		return lunchMin;
	}

	public int getDinnerHour() {
		return dinnerHour;
	}

	public int getDinnerMin() {
		return dinnerMin;
	}

	public String getBreakingBell() {
		return breakingBell;
	}

	public String getMealBell() {
		return mealBell;
	}

	public List<String> getSoundFileList() {
		return soundFileList;
	}

	public void setStartHour(int startHour) {
		setProperty("startHour", startHour);
		this.startHour = startHour;
	}

	public void setStartMin(int startMin) {
		setProperty("startMin", startMin);
		this.startMin = startMin;
	}

	public void setMorningSubjectCount(int morningSubjectCount) {
		setProperty("morningSubjectCount", morningSubjectCount);
		this.morningSubjectCount = morningSubjectCount;
	}

	public void setAfternoonSubjectCount(int afternoonSubjectCount) {
		setProperty("afternoonSubjectCount", afternoonSubjectCount);
		this.afternoonSubjectCount = afternoonSubjectCount;
	}

	public void setStudyingHour(int studyingHour) {
		setProperty("studyingHour", studyingHour);
		this.studyingHour = studyingHour;
	}

	public void setStudyingMin(int studyingMin) {
		setProperty("studyingMin", studyingMin);
		this.studyingMin = studyingMin;
	}

	public void setBreakingTime(int breakingTime) {
		setProperty("breakingTime", breakingTime);
		this.breakingTime = breakingTime;
	}

	public void setLunchHour(int lunchHour) {
		this.lunchHour = lunchHour;
	}

	public void setLunchMin(int lunchMin) {
		this.lunchMin = lunchMin;
	}

	public void setDinnerHour(int dinnerHour) {
		this.dinnerHour = dinnerHour;
	}

	public void setDinnerMin(int dinnerMin) {
		this.dinnerMin = dinnerMin;
	}

	public void setBreakingBell(String breakingBell) {
		this.breakingBell = breakingBell;
	}

	public void setMealBell(String mealBell) {
		this.mealBell = mealBell;
	}

	public void setSoundFileList(List<String> soundFileList) {
		this.soundFileList = soundFileList;
	}

	/**
	 * System Property 에 저장된 모든 값들을 Class Property에 설정 합니다.
	 */
	public void loadAll() {

		// 시작 시간
		setStartHour(Integer.parseInt(getProperty("startHour")));
		setStartMin(Integer.parseInt(getProperty("startMin")));

		// 오전 과목수
		setMorningSubjectCount(Integer.parseInt(getProperty("morningSubjectCount")));

		// 오후 과목수
		setAfternoonSubjectCount(Integer.parseInt(getProperty("afternoonSubjectCount")));

		// 수업 시간
		setStudyingHour(Integer.parseInt(getProperty("studyingHour")));
		setStudyingMin(Integer.parseInt(getProperty("studyingMin")));

		// 쉬는 시간
		setBreakingTime(Integer.parseInt(getProperty("breakingTime")));

		// 점심 시간
		setLunchHour(Integer.parseInt(getProperty("lunchHour")));
		setLunchMin(Integer.parseInt(getProperty("lunchMin")));

		// 저녁 시간
		setDinnerHour(Integer.parseInt(getProperty("dinnerHour")));
		setDinnerMin(Integer.parseInt(getProperty("dinnerMin")));

		// 쉬는 시간 종소리
		setBreakingBell(String.valueOf(getProperty("breakingBell")));

		// 식사 시간 종소리
		setMealBell(String.valueOf(getProperty("mealBell")));
	}
}
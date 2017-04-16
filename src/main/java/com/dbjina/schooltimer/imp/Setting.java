package com.dbjina.schooltimer.imp;

import java.util.List;
import java.util.prefs.Preferences;

import com.dbjina.schooltimer.FieldEnum;
import com.dbjina.schooltimer.SchoolTimerApp;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class Setting {
	private static Setting instance = new Setting();

	private Setting() {
		pref = Preferences.userNodeForPackage(SchoolTimerApp.class);
	}

	public static Setting getInstance() {
		return instance;
	}

	// Fields
	private Preferences pref;

	private String title;
	
	private int startHour; // 수업 시작 시간(0 ~ 23)
	private int startMin; // 수업 시작 분(0 ~ 59)

	private int morningSubjectCount; // 오전 과목 갯수
	private int afternoonSubjectCount; // 오후 과목 갯수

	private int studyingHour; // 수업 시간(시간)
	private int studyingMin; // 수업 시간(분)

	private int breakingTime; // 쉬는 시간(분)

	private int lunchHour; // 점심 시간(시간)
	private int lunchMin; // 점심 시간(분)

	private int dinnerHour; // 저녁 시간(시간)
	private int dinnerMin; // 저녁 시간(분)

	private String breakingBell; // 쉬는 시간 종소리 (파일명)
	private String mealBell; // 식사 시간 종소리 (파일명)

	private List<String> soundFileList; // 사운드 파일 AbsolutePath 리스트

	private AdvancedPlayer player;

	
	
	// Getter
	public String getTitle() {
		return title;
	}

	public AdvancedPlayer getPlayer() {
		return player;
	}

	public Preferences getPref() {
		return pref;
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
	
	public List<String> getSoundFileList() {
		return soundFileList;
	}
	
	// Setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPlayer(AdvancedPlayer player) {
		this.player = player;
	}
	
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public void setStartMin(int startMin) {
		this.startMin = startMin;
	}

	public void setMorningSubjectCount(int morningSubjectCount) {
		this.morningSubjectCount = morningSubjectCount;
	}

	public void setAfternoonSubjectCount(int afternoonSubjectCount) {
		this.afternoonSubjectCount = afternoonSubjectCount;
	}

	public void setStudyingHour(int studyingHour) {
		this.studyingHour = studyingHour;
	}

	public void setStudyingMin(int studyingMin) {
		this.studyingMin = studyingMin;
	}

	public void setBreakingTime(int breakingTime) {
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
	
	// Method

	

	public void setProperty(FieldEnum key, int value) {
		setProperty(key, String.valueOf(value));
	}

	public void setProperty(FieldEnum key, String value) {
		pref.put(key.toString(), value);
	}

	
	private String getProperty(FieldEnum key) {
		String value = pref.get(key.toString(), null);
		if (value != null) {
			return value;
		}
		return "-1";
	}

	

	public String getBreakingBellAbsolutePath() {
		String bellName;
		for (String bell : soundFileList) {
			bellName = bell.substring(bell.lastIndexOf("\\") + 1, bell.lastIndexOf("."));
			if (bellName.equals(getBreakingBell())) {
				return bell;
			}
		}
		return null;
	}

	public String getMealBell() {
		return mealBell;
	}

	public String getMealBellAbsolutePath() {
		String bellName;
		for (String bell : soundFileList) {
			bellName = bell.substring(bell.lastIndexOf("\\") + 1, bell.lastIndexOf("."));
			if (bellName.equals(getMealBell())) {
				return bell;
			}
		}
		return null;
	}

	

	

	/**
	 * Preferences 에서 설정을 가져옴
	 */
	public void loadSetting() {
		// 시작 시간
		setStartHour(Integer.parseInt(getProperty(FieldEnum.START_HOUR)));
		setStartMin(Integer.parseInt(getProperty(FieldEnum.START_MIN)));

		// 오전 과목수
		setMorningSubjectCount(Integer.parseInt(getProperty(FieldEnum.MORNING_SUBJECT_COUNT)));

		// 오후 과목수
		setAfternoonSubjectCount(Integer.parseInt(getProperty(FieldEnum.AFTERNOON_SUBJECT_COUNT)));

		// 수업 시간
		setStudyingHour(Integer.parseInt(getProperty(FieldEnum.STUDYING_HOUR)));
		setStudyingMin(Integer.parseInt(getProperty(FieldEnum.STUDYING_MIN)));

		// 쉬는 시간
		setBreakingTime(Integer.parseInt(getProperty(FieldEnum.BREAKING_TIME)));

		// 점심 시간
		setLunchHour(Integer.parseInt(getProperty(FieldEnum.LUNCH_HOUR)));
		setLunchMin(Integer.parseInt(getProperty(FieldEnum.LUNCH_MIN)));

		// 저녁 시간
		setDinnerHour(Integer.parseInt(getProperty(FieldEnum.DINNER_HOUR)));
		setDinnerMin(Integer.parseInt(getProperty(FieldEnum.DINNER_MIN)));

		// 쉬는 시간 종소리
		setBreakingBell(String.valueOf(getProperty(FieldEnum.BREAKING_BELL)));

		// 식사 시간 종소리
		setMealBell(String.valueOf(getProperty(FieldEnum.MEAL_BELL)));
	}

	public void init() {
		setStartHour(9);
		setStartMin(0);

		setMorningSubjectCount(4);
		setAfternoonSubjectCount(4);

		setStudyingHour(0);
		setStudyingMin(50);

		setBreakingTime(10);

		setLunchHour(0);
		setLunchMin(50);

		setDinnerHour(0);
		setDinnerMin(0);

		setBreakingBell(getSoundFileList().get(0));
		setMealBell(getSoundFileList().get(0));
	}

	/**
	 * Preferences 에 설정을 저장합니다.
	 */
	public void saveSetting() {
		WindowFrame frame = WindowFrame.getInstance();

		// 시작 시간
		setProperty(FieldEnum.START_HOUR, frame.getCboStartHour().getSelectedItem().toString());
		setProperty(FieldEnum.START_MIN, frame.getCboStartMin().getSelectedItem().toString());

		// 오전 과목수
		setProperty(FieldEnum.MORNING_SUBJECT_COUNT, frame.getCboMorningSubjectCount().getSelectedItem().toString());

		// 오후 과목수
		setProperty(FieldEnum.AFTERNOON_SUBJECT_COUNT,
				frame.getCboAfternoonSubjectCount().getSelectedItem().toString());

		// 수업시간
		setProperty(FieldEnum.STUDYING_HOUR, frame.getCboStudyingHour().getSelectedItem().toString());
		setProperty(FieldEnum.STUDYING_MIN, frame.getCboStudyingMin().getSelectedItem().toString());

		// 쉬는 시간
		setProperty(FieldEnum.BREAKING_TIME, frame.getCboBreakingTime().getSelectedItem().toString());

		// 점심 시간
		setProperty(FieldEnum.LUNCH_HOUR, frame.getCboLunchHour().getSelectedItem().toString());
		setProperty(FieldEnum.LUNCH_MIN, frame.getCboLunchMin().getSelectedItem().toString());

		// 저녁 시간
		setProperty(FieldEnum.DINNER_HOUR, frame.getCboDinnerHour().getSelectedItem().toString());
		setProperty(FieldEnum.DINNER_MIN, frame.getCboDinnerMin().getSelectedItem().toString());

		// 쉬는 시간 종소리
		setProperty(FieldEnum.BREAKING_BELL, frame.getCboBreakingTimeBell().getSelectedItem().toString());

		// 식사 시간 종소리
		setProperty(FieldEnum.MEAL_BELL, frame.getCboMealTimeBell().getSelectedItem().toString());
	}

}
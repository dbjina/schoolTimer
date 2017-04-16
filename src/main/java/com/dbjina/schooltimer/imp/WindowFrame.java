package com.dbjina.schooltimer.imp;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.dbjina.schooltimer.FieldEnum;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import net.miginfocom.swing.MigLayout;

public class WindowFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6479165293433033273L;

	private static WindowFrame instance = new WindowFrame();
	
	private  WindowFrame() {
	}
	
	public static WindowFrame getInstance() {
		return instance;
	}

	private JTable tableSchedule;
	private JScrollPane scrollSchedule;

	private JButton btnHelp;
	private JToggleButton btnStart;

	private JLabel lblBreakingBell;
	private JLabel lblMealBell;
	private JLabel lblStartTime;
	private JLabel lblStartHour;
	private JLabel lblStartMin;
	private JLabel lblBreakLine1;
	private JLabel lblMorningSubjectCount;
	private JLabel lblMorningSubject;
	private JLabel lblAfternoonSubjectCount;
	private JLabel lblAfternoonSubject;
	private JLabel lblBreakLine2;
	private JLabel lblStudyingTime;
	private JLabel lblStudyingHour;
	private JLabel lblStudyingMin;
	private JLabel lblBreakingTime;
	private JLabel lblBreakLine3;
	private JLabel lblLunchTime;
	private JLabel lblLunchHour;
	private JLabel lblLunchMin;
	private JLabel lblDinnerTime;
	private JLabel lblDinnerHour;
	private JLabel lblDinnerMin;

	private List<JComboBox<?>> cboList = new ArrayList<JComboBox<?>>();
	private JComboBox<Integer> cboStartHour;
	private JComboBox<Integer> cboStartMin;
	private JComboBox<String> cboBreakingTimeBell;
	private JComboBox<String> cboMealTimeBell;
	private JComboBox<Integer> cboMorningSubjectCount;
	private JComboBox<Integer> cboAfternoonSubjectCount;
	private JComboBox<Integer> cboStudyingHour;
	private JComboBox<Integer> cboStudyingMin;
	private JComboBox<Integer> cboBreakingTime;
	private JComboBox<Integer> cboLunchHour;
	private JComboBox<Integer> cboLunchMin;
	private JComboBox<Integer> cboDinnerHour;
	private JComboBox<Integer> cboDinnerMin;

	// Getter
	public JTable getTableSchedule() {
		return tableSchedule;
	}

	public List<JComboBox<?>> getCboList() {
		return cboList;
	}

	public JComboBox<Integer> getCboStartHour() {
		return cboStartHour;
	}

	public JComboBox<Integer> getCboStartMin() {
		return cboStartMin;
	}

	public JComboBox<String> getCboBreakingTimeBell() {
		return cboBreakingTimeBell;
	}

	public JComboBox<String> getCboMealTimeBell() {
		return cboMealTimeBell;
	}

	public JComboBox<Integer> getCboMorningSubjectCount() {
		return cboMorningSubjectCount;
	}

	public JComboBox<Integer> getCboAfternoonSubjectCount() {
		return cboAfternoonSubjectCount;
	}

	public JComboBox<Integer> getCboStudyingHour() {
		return cboStudyingHour;
	}

	public JComboBox<Integer> getCboStudyingMin() {
		return cboStudyingMin;
	}

	public JComboBox<Integer> getCboBreakingTime() {
		return cboBreakingTime;
	}

	public JComboBox<Integer> getCboLunchHour() {
		return cboLunchHour;
	}

	public JComboBox<Integer> getCboLunchMin() {
		return cboLunchMin;
	}

	public JComboBox<Integer> getCboDinnerHour() {
		return cboDinnerHour;
	}

	public JComboBox<Integer> getCboDinnerMin() {
		return cboDinnerMin;
	}
	
	public JToggleButton getBtnStart() {
		return btnStart;
	}

	public void init() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		setTitle(getTitle());

		JPanel timePanel = new JPanel();
		timePanel.setOpaque(false);

		JPanel schedulePanel = new JPanel();
		schedulePanel.setOpaque(false);
		schedulePanel.setLayout(new MigLayout("", "[grow,fill]", "[grow]"));

		JPanel bellPanel = new JPanel();
		bellPanel.setOpaque(false);

		JPanel startPanel = new JPanel();
		startPanel.setOpaque(false);

		JPanel etcPanel = new JPanel();
		etcPanel.setOpaque(false);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(timePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
						.addComponent(bellPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(startPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(schedulePanel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(etcPanel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(13, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(timePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(bellPanel,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(schedulePanel, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(etcPanel, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
								.addComponent(startPanel, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
						.addGap(10)));
		etcPanel.setLayout(new GridLayout(1, 0, 0, 0));

		btnHelp = new JButton("도움말");
		btnHelp.setFont(new Font("굴림", Font.PLAIN, 24));
		etcPanel.add(btnHelp);
		startPanel.setLayout(new GridLayout(1, 0, 0, 0));

		btnStart = new JToggleButton("시작");
		btnStart.setFont(new Font("굴림", Font.BOLD, 24));
		btnStart.addActionListener(new StartButtonListener());
		startPanel.add(btnStart);
		bellPanel.setLayout(new MigLayout("", "[][grow]", "[][]"));

		lblBreakingBell = new JLabel("종소리");
		lblBreakingBell.setFont(new Font("굴림", Font.PLAIN, 14));
		bellPanel.add(lblBreakingBell, "cell 0 0,alignx trailing");

		cboBreakingTimeBell = new JComboBox<String>();
		cboBreakingTimeBell.setName(FieldEnum.BREAKING_BELL.toString());
		cboBreakingTimeBell.setFont(new Font("굴림", Font.PLAIN, 18));
		bellPanel.add(cboBreakingTimeBell, "cell 1 0,growx");

		lblMealBell = new JLabel("식사 시간 종소리");
		lblMealBell.setFont(new Font("굴림", Font.PLAIN, 14));
		bellPanel.add(lblMealBell, "cell 0 1,alignx trailing");

		cboMealTimeBell = new JComboBox<String>();
		cboMealTimeBell.setName(FieldEnum.MEAL_BELL.toString());
		cboMealTimeBell.setFont(new Font("굴림", Font.PLAIN, 18));
		bellPanel.add(cboMealTimeBell, "cell 1 1,growx");

		// 스케줄 테이블
		tableSchedule = new JTable(Schedule.getInstance().getContents(), Schedule.getInstance().getHeaders());
		tableSchedule.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollSchedule = new JScrollPane(tableSchedule);
		schedulePanel.add(scrollSchedule, "cell 0 0,grow");
		timePanel.setLayout(new MigLayout("", "[][grow][][grow][]", "[][][][][][][][][][]"));

		Vector<Integer> hours = new Vector<Integer>();
		for (int i = 0; i < 24; i++) {
			hours.add(i);
		}

		Vector<Integer> mins = new Vector<Integer>();
		for (int i = 0; i < 60; i++) {
			mins.add(i);
		}

		lblStartTime = new JLabel("시작 시간");
		lblStartTime.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblStartTime, "cell 0 0,alignx trailing");

		cboStartHour = new JComboBox<Integer>();
		cboStartHour.setName(FieldEnum.START_HOUR.toString());
		timePanel.add(cboStartHour, "cell 1 0,growx");
		cboStartHour.setFont(new Font("굴림", Font.PLAIN, 18));

		lblStartHour = new JLabel("시");
		timePanel.add(lblStartHour, "cell 2 0,growx");
		lblStartHour.setFont(new Font("굴림", Font.PLAIN, 18));

		cboStartMin = new JComboBox<Integer>();
		cboStartMin.setName(FieldEnum.START_MIN.toString());
		cboStartMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboStartMin, "cell 3 0,growx");

		lblStartMin = new JLabel("분");
		lblStartMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblStartMin, "cell 4 0,growx");

		lblBreakLine1 = new JLabel("　");
		lblBreakLine1.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblBreakLine1, "cell 0 1");

		lblMorningSubjectCount = new JLabel("오전 과목수");
		lblMorningSubjectCount.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblMorningSubjectCount, "cell 0 2,alignx trailing");

		cboMorningSubjectCount = new JComboBox<Integer>();
		cboMorningSubjectCount.setName(FieldEnum.MORNING_SUBJECT_COUNT.toString());
		cboMorningSubjectCount.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboMorningSubjectCount, "cell 1 2,growx");

		lblMorningSubject = new JLabel("과목");
		lblMorningSubject.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblMorningSubject, "cell 2 2,growx");

		lblAfternoonSubjectCount = new JLabel("오후 과목수");
		lblAfternoonSubjectCount.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblAfternoonSubjectCount, "cell 0 3,alignx trailing");

		cboAfternoonSubjectCount = new JComboBox<Integer>();
		cboAfternoonSubjectCount.setName(FieldEnum.AFTERNOON_SUBJECT_COUNT.toString());
		cboAfternoonSubjectCount.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboAfternoonSubjectCount, "cell 1 3,growx");

		lblAfternoonSubject = new JLabel("과목");
		lblAfternoonSubject.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblAfternoonSubject, "cell 2 3,alignx trailing");

		lblBreakLine2 = new JLabel("　");
		lblBreakLine2.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblBreakLine2, "cell 0 4");

		lblStudyingTime = new JLabel("수업 시간");
		lblStudyingTime.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblStudyingTime, "cell 0 5,alignx trailing");

		cboStudyingHour = new JComboBox<Integer>();
		cboStudyingHour.setName(FieldEnum.STUDYING_HOUR.toString());
		cboStudyingHour.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboStudyingHour, "cell 1 5,growx");

		lblStudyingHour = new JLabel("시간");
		lblStudyingHour.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblStudyingHour, "cell 2 5,alignx trailing");

		cboStudyingMin = new JComboBox<Integer>();
		cboStudyingMin.setName(FieldEnum.STUDYING_MIN.toString());
		cboStudyingMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboStudyingMin, "cell 3 5,growx");

		lblStudyingMin = new JLabel("분");
		lblStudyingMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblStudyingMin, "cell 4 5");

		lblBreakingTime = new JLabel("쉬는 시간");
		lblBreakingTime.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblBreakingTime, "cell 0 6,alignx trailing");

		cboBreakingTime = new JComboBox<Integer>();
		cboBreakingTime.setName(FieldEnum.BREAKING_TIME.toString());
		cboBreakingTime.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboBreakingTime, "cell 1 6,growx");

		lblBreakingTime = new JLabel("분");
		lblBreakingTime.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblBreakingTime, "cell 2 6");

		lblBreakLine3 = new JLabel("　");
		lblBreakLine3.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblBreakLine3, "cell 0 7");

		lblLunchTime = new JLabel("점심 시간");
		lblLunchTime.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblLunchTime, "cell 0 8,alignx trailing");

		cboLunchHour = new JComboBox<Integer>();
		cboLunchHour.setName(FieldEnum.LUNCH_HOUR.toString());
		cboLunchHour.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboLunchHour, "cell 1 8,growx");

		lblLunchHour = new JLabel("시간");
		lblLunchHour.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblLunchHour, "cell 2 8,alignx trailing");

		cboLunchMin = new JComboBox<Integer>();
		cboLunchMin.setName(FieldEnum.LUNCH_MIN.toString());
		cboLunchMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboLunchMin, "cell 3 8,growx");

		lblLunchMin = new JLabel("분");
		lblLunchMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblLunchMin, "cell 4 8");

		lblDinnerTime = new JLabel("저녁 시간");
		lblDinnerTime.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblDinnerTime, "cell 0 9,alignx trailing");

		cboDinnerHour = new JComboBox<Integer>();
		cboDinnerHour.setName(FieldEnum.DINNER_HOUR.toString());
		cboDinnerHour.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboDinnerHour, "cell 1 9,growx");

		lblDinnerHour = new JLabel("시간");
		lblDinnerHour.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblDinnerHour, "cell 2 9,alignx trailing");

		cboDinnerMin = new JComboBox<Integer>();
		cboDinnerMin.setName(FieldEnum.DINNER_MIN.toString());
		cboDinnerMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(cboDinnerMin, "cell 3 9,growx");

		lblDinnerMin = new JLabel("분");
		lblDinnerMin.setFont(new Font("굴림", Font.PLAIN, 18));
		timePanel.add(lblDinnerMin, "cell 4 9");
		getContentPane().setLayout(groupLayout);

		cboList.add(cboStartHour);
		cboList.add(cboStartMin);
		cboList.add(cboBreakingTimeBell);
		cboList.add(cboBreakingTimeBell);
		cboList.add(cboMealTimeBell);
		cboList.add(cboMorningSubjectCount);
		cboList.add(cboAfternoonSubjectCount);
		cboList.add(cboStudyingHour);
		cboList.add(cboStudyingMin);
		cboList.add(cboBreakingTime);
		cboList.add(cboLunchHour);
		cboList.add(cboLunchMin);
		cboList.add(cboDinnerHour);
		cboList.add(cboDinnerMin);
		
		
		setSize(510, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setSettingsToFrame();
		
		addItemListener();
		addWindowListener(new WindowClosingListener());
		
		cboDinnerHour.setEnabled(false);
		cboDinnerMin.setEnabled(false);
		cboMealTimeBell.setEnabled(false);
		
	}

	private void addItemListener() {
		List<JComboBox<?>> cboList = getCboList();
		for(JComboBox<?> cbo : cboList) {
			cbo.addItemListener(new ComboBoxListener());
		}
	}
	
	/**
	 * startIndex 숫자부터 endIndex 까지 step + 1 해서 object에 item을 추가함
	 * 
	 * @param object
	 * @param startIndex
	 * @param endIndex
	 */
	public void makeItems(JComboBox<Integer> object, int startIndex, int endIndex) {
		JComboBox<Integer> cbo = object;

		for (int i = startIndex; i < endIndex; i++) {
			cbo.addItem(i);
		}
	}

	public void makeItems(JComboBox<String> object, List<String> soundFileList) {
		JComboBox<String> cbo = object;

		for(String soundFile : soundFileList) {
			cbo.addItem(getFilename(soundFile));
		}
	}
	
	private String getFilename(String filePath) {
		return filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.lastIndexOf("."));
	}

	/**
	 * Setting에 저장된 설정들 윈도우 프레임에 반영
	 */
	public void setSettingsToFrame() {
		Setting setting = Setting.getInstance();
		
		// 시작 시간
		makeItems(getCboStartHour(), 0, 24);
		getCboStartHour().setSelectedItem(setting.getStartHour());
		makeItems(getCboStartMin(), 0, 60);
		getCboStartMin().setSelectedItem(setting.getStartMin());

		// 오전 과목수
		makeItems(getCboMorningSubjectCount(), 1, 16);
		getCboMorningSubjectCount().setSelectedItem(setting.getMorningSubjectCount());

		// 오후 과목수
		makeItems(getCboAfternoonSubjectCount(), 1, 16);
		getCboAfternoonSubjectCount().setSelectedItem(setting.getAfternoonSubjectCount());

		// 수업 시간
		makeItems(getCboStudyingHour(), 0, 6);
		makeItems(getCboStudyingMin(), 0, 60);
		getCboStudyingHour().setSelectedItem(setting.getStudyingHour());
		getCboStudyingMin().setSelectedItem(setting.getStudyingMin());

		// 쉬는 시간
		makeItems(getCboBreakingTime(), 0, 61);
		getCboBreakingTime().setSelectedItem(setting.getBreakingTime());

		// 점심 시간
		makeItems(getCboLunchHour(), 0, 6);
		makeItems(getCboLunchMin(), 0, 60);
		getCboLunchHour().setSelectedItem(setting.getLunchHour());
		getCboLunchMin().setSelectedItem(setting.getLunchMin());

		// 저녁 시간
		makeItems(getCboDinnerHour(), 0, 6);
		makeItems(getCboDinnerMin(), 0, 60);
		getCboDinnerHour().setSelectedItem(setting.getDinnerHour());
		getCboDinnerMin().setSelectedItem(setting.getDinnerMin());

		// 쉬는 시간 종소리
		makeItems(getCboBreakingTimeBell(), setting.getSoundFileList());
		getCboBreakingTimeBell().setSelectedItem(setting.getBreakingBell());
		
		// 식사 시간 종소리
		makeItems(getCboMealTimeBell(), Setting.getInstance().getSoundFileList());
		getCboMealTimeBell().setSelectedItem(setting.getMealBell());
		
		// 스케줄
		getTableSchedule().setModel(Schedule.getInstance().getScheduleModel());
		getTableSchedule().repaint();
	}

	// 리스너
	
	/**
	 * 시작 버튼 리스너
	 *
	 */
	class StartButtonListener implements ActionListener {

		public void disableComboBoxes(List<JComboBox<?>> cboList) {
			for(JComboBox<?> cbo : cboList) {
				cbo.setEnabled(false);
			}
		}

		public void enableComboBoxes(List<JComboBox<?>> cboList) {
			List<JComboBox<?>> disableList = new ArrayList<>();
			
			for(JComboBox<?> cbo : cboList) {
					cbo.setEnabled(true);
					
					if(cbo.getName().equals(FieldEnum.DINNER_HOUR.toString())) {
						disableList.add(cbo);
					}
					else if(cbo.getName().equals(FieldEnum.DINNER_MIN.toString())) {
						disableList.add(cbo);
					}
					else if(cbo.getName().equals(FieldEnum.MEAL_BELL.toString())) {
						disableList.add(cbo);
					}
			}
			
			disableComboBoxes(disableList);
		}
		
		public void displaySchedule() {
			getTableSchedule();
		}
		
		public void actionPerformed(ActionEvent e) {
			
			Object obj = e.getSource();
			JToggleButton btn;
			if (obj instanceof JToggleButton) {
				btn = (JToggleButton) obj;

				if (btn.getText().equals("시작")) {
					disableComboBoxes(getCboList());
					btn.setText("중지");
					
					Schedule.getInstance().setThread(new Thread(new BellThread()));
					Schedule.getInstance().getThread().start();
				} else if (btn.getText().equals("중지")) {
					Schedule.getInstance().getThread().interrupt();
					enableComboBoxes(getCboList());
					btn.setText("시작");
				}
			}
		}
	}
	
	class ComboBoxListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				Object obj = e.getSource();
				if(obj instanceof JComboBox<?>) {
					Setting setting = Setting.getInstance();
					JComboBox<?> cbo = (JComboBox<?>)obj;
					String value = cbo.getSelectedItem().toString();
					
					if(cbo.getName().equals(FieldEnum.START_HOUR.toString())) {
						setting.setStartHour(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.START_MIN.toString())) {
						setting.setStartMin(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.MORNING_SUBJECT_COUNT.toString())) {
						setting.setMorningSubjectCount(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.AFTERNOON_SUBJECT_COUNT.toString())) {
						setting.setAfternoonSubjectCount(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.STUDYING_HOUR.toString())) {
						setting.setStudyingHour(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.STUDYING_MIN.toString())) {
						setting.setStudyingMin(Integer.parseInt(value));
						
					}
					else if(cbo.getName().equals(FieldEnum.BREAKING_TIME.toString())) {
						setting.setBreakingTime(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.LUNCH_HOUR.toString())) {
						setting.setLunchHour(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.LUNCH_MIN.toString())) {
						setting.setLunchMin(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.DINNER_HOUR.toString())) {
						setting.setDinnerHour(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.DINNER_MIN.toString())) {
						setting.setDinnerMin(Integer.parseInt(value));
					}
					else if(cbo.getName().equals(FieldEnum.BREAKING_BELL.toString())) {
						setting.setBreakingBell(value);
					}
					else if(cbo.getName().equals(FieldEnum.MEAL_BELL.toString())) {
						setting.setMealBell(value);
					}
				}
				
				getTableSchedule().setModel(Schedule.getInstance().getScheduleModel());
				getTableSchedule().repaint();
				
			}
		}
		
		
	}
	
	class WindowClosingListener extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			Setting.getInstance().saveSetting();
		}
	}
	
	class BellThread implements Runnable {

		private boolean stopFlag = false;
		private int currentAlram = 0;
		
		@Override
		public void run() {
			Schedule scheudle = Schedule.getInstance();
			Time currentTime = new Time();
			Time alramTime = null;
			List<Time> alramList = scheudle.getAlramList();
			Setting setting = Setting.getInstance();
			
			System.out.println("알람 리스트");
			for(int i=0; i<alramList.size(); i++) {
				System.out.println(i + " : " + alramList.get(i));
			}
			
			System.out.println("현재 시간 : " + currentTime);
			
			for(int i=0; i<alramList.size(); i++) {
				if(currentTime.getHour() <= alramList.get(i).getHour()) {
					if((currentTime.getMinute() <= alramList.get(i).getMinute())) {
						currentAlram = new Integer(i);
						break;
					}
					else if(currentTime.getHour() < alramList.get(i).getHour()) {
						currentAlram = new Integer(i);
						break;
					}
				}
			}
			System.out.println(currentAlram);
			while(!Thread.currentThread().isInterrupted()) {
				if(alramList.size() <= 0) {
					stopFlag = true;
				}
				
				if(alramList.size() == currentAlram) {
					stopFlag = true;
				}
				
				if(stopFlag == true) {
					break;
				}
				
				currentTime = new Time();
				alramTime = alramList.get(currentAlram);
				
				if(currentTime.equals(alramTime)) {
					try {
						
						setting.setPlayer(new AdvancedPlayer(new FileInputStream(Setting.getInstance().getBreakingBellAbsolutePath())));
						setting.getPlayer().play();
						currentAlram++;
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (JavaLayerException e1) {
						e1.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(1000 * 60);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
		
	}
}

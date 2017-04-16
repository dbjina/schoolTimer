package com.dbjina.schooltimer.imp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Frame extends JFrame implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font labelFont = new Font("굴림", Font.PLAIN, 20);
	private ActionListener actionListener;
	
	public ActionListener getActionListener() {
		return actionListener;
	}

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public Frame(ActionListener actionListener) {
		setActionListener(actionListener);
		init();
	}
	
	void init() {
		// 프레임 셋팅

		setTitle("학교종 땡땡땡");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		// 패널
		JPanel labelPanel = new JPanel();
		JPanel textboxPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel schedulePanel = new JPanel();
		
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		textboxPanel.setLayout(new BoxLayout(textboxPanel, BoxLayout.Y_AXIS));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
		
		// 라벨
		JLabel lblSchoolStartTime = new JLabel("시작 시간");
		JLabel lblSchoolHours = new JLabel("수업 시간(분)");
		JLabel lblBreakingHours = new JLabel("쉬는 시간(분)");
		JLabel lblLunchHours = new JLabel("점심 시간(분)");
		JLabel lblDinnerHours = new JLabel("저녁 시간(분)");
		JLabel lblSchedule = new JLabel("시간표");
		
		// 텍스트 필드
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumIntegerDigits(1);

		JFormattedTextField txtSchoolStartTime = new JFormattedTextField(numberFormat);
		JFormattedTextField txtSchoolHours = new JFormattedTextField(numberFormat);
		JFormattedTextField txtBreakingHours = new JFormattedTextField(numberFormat);
		JFormattedTextField txtLunchHours = new JFormattedTextField(numberFormat);
		JFormattedTextField txtDinnerHours = new JFormattedTextField(numberFormat);
		
		
		// 버튼
		JButton btnStart = new JButton("시작");
		
		// 배치
		
		// 라벨 배치
		int vgap = 20;
		labelPanel.add(lblSchoolStartTime);
		labelPanel.add(Box.createVerticalStrut(vgap));
		labelPanel.add(lblSchoolHours);
		labelPanel.add(Box.createVerticalStrut(vgap));
		labelPanel.add(lblBreakingHours);
		labelPanel.add(Box.createVerticalStrut(vgap));
		labelPanel.add(lblLunchHours);
		labelPanel.add(Box.createVerticalStrut(vgap));
		labelPanel.add(lblDinnerHours);
		
		// 스케줄 패널 배치
		schedulePanel.add(lblSchedule);
		
		
		// 텍스트 필드 배치
		textboxPanel.add(txtSchoolStartTime);
		textboxPanel.add(txtSchoolHours);
		textboxPanel.add(txtBreakingHours);
		textboxPanel.add(txtLunchHours);
		textboxPanel.add(txtDinnerHours);
		
		// 버튼 배치
		buttonPanel.add(btnStart);
		
		// 패널 배치
		add(labelPanel, BorderLayout.WEST);
		add(textboxPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(schedulePanel, BorderLayout.EAST);
		
		// 라벨 폰트 설정
		UIManager.put("Label.font", labelFont);
		
		// 텍스트 필드 폰트 설정
		UIManager.put("FormattedTextField.font", labelFont);
		
		// 폰트 JFrame에 적용
		SwingUtilities.updateComponentTreeUI(this);
		
		
//		텍스트 필드 설정
		for(Component comp : textboxPanel.getComponents()) {
			if(comp instanceof JFormattedTextField) {
				((JFormattedTextField)comp).setColumns(10);
				((JFormattedTextField)comp).setPreferredSize(new Dimension(200, 24));
			}
		}
		pack();
		
		// 버튼 리스너 설정
		for(Component comp : buttonPanel.getComponents()) {
			if(comp instanceof JButton) {
				((JButton)comp).addActionListener(getActionListener());
			}
		}
	}

	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}

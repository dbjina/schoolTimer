package com.dbjina.schooltimer;

import java.io.FileNotFoundException;
import java.util.prefs.Preferences;

import com.dbjina.schooltimer.imp.Setting;
import com.dbjina.schooltimer.imp.WindowFrame;
import com.dbjina.schooltimer.inter.FilePathLoader;

import javazoom.jl.decoder.JavaLayerException;

public class SchoolTimerAppManager {
	
	private FilePathLoader soundFileLoader;

	public FilePathLoader getsoundFileLoader() {
		return soundFileLoader;
	}
	public void setSoundFileLoader(FilePathLoader soundFileLoader) {
		this.soundFileLoader = soundFileLoader;
	}
	
	
	public void exec() throws FileNotFoundException, JavaLayerException {

		// Setting 클래스 soundFileList 설정
		Setting setting = Setting.getInstance();
		setting.setSoundFileList(getsoundFileLoader().loadFilePaths());
		
		// Setting 클래스 초기화
		Preferences pref = setting.getPref();
		boolean isFirstInit = Boolean.parseBoolean(pref.get("firstInit", "true"));

		// 처음 실행이 아닐 경우 Preferences 에 등록된 설정들을 Setting 클래스에 바인딩
		if (isFirstInit) {
			pref.put("firstInit", "false");
			setting.init();
			// 윈도우 프레임 초기화
			WindowFrame.getInstance().init();
		} else {
			setting.loadSetting();
			// 윈도우 프레임 초기화
			WindowFrame.getInstance().init();
			WindowFrame.getInstance().getBtnStart().doClick();
		}
		

	}
	
	
}

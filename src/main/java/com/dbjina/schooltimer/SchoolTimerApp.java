package com.dbjina.schooltimer;

import java.io.FileNotFoundException;

import com.dbjina.schooltimer.filter.Mp3Filter;
import com.dbjina.schooltimer.imp.SoundFileLoader;
import com.dbjina.schooltimer.imp.WindowFrame;
import com.dbjina.schooltimer.inter.FilePathLoader;

import javazoom.jl.decoder.JavaLayerException;

public class SchoolTimerApp {
	
	public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
		String title = "학교종이 땡땡땡";
		String version = "0.1";
		
		// 윈도우 프레임 설정
		WindowFrame.getInstance().setTitle(title + " " + version);

		// MP3 로더
		FilePathLoader mp3Loader = new SoundFileLoader(new Mp3Filter());
		
		SchoolTimerAppManager manager = new SchoolTimerAppManager();
		manager.setSoundFileLoader(mp3Loader);
		
		manager.exec();
	}
}

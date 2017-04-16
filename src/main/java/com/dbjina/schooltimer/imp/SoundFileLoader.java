package com.dbjina.schooltimer.imp;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.dbjina.schooltimer.inter.FilePathLoader;

public class SoundFileLoader implements FilePathLoader{

	private List<String> soundPaths;
	private FilenameFilter fileFilter;
	
	public List<String> getSoundPaths() {
		return soundPaths;
	}
	public void setSoundPaths(List<String> soundPaths) {
		this.soundPaths = soundPaths;
	}
	
	public SoundFileLoader(FilenameFilter fileFilter) {
		setFileFilter(fileFilter);
	}
	
	public FilenameFilter getFileFilter() {
		return fileFilter;
	}
	public void setFileFilter(FilenameFilter fileFilter) {
		this.fileFilter = fileFilter;
	}
	
	
	public List<String> loadFilePaths(String path) {
		List<String> paths = new ArrayList<String>();
		
		File f = new File(path);
		
		if(!f.isDirectory()) {
			try {
				throw new Exception("경로가 올바르지 않습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		File[] files = f.listFiles(fileFilter);
		
		for(File tempFile : files) {
			paths.add(tempFile.getAbsolutePath());
		}
		
		return paths;
	}
	public List<String> loadFilePaths() {
		return loadFilePaths(System.getProperty("user.dir") + "\\sound");
	}
	
}

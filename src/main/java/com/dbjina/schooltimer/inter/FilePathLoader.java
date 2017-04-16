package com.dbjina.schooltimer.inter;

import java.util.List;

public interface FilePathLoader {
	List<String> loadFilePaths();
	List<String> loadFilePaths(String path);
}

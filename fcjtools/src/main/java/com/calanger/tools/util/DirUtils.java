package com.calanger.tools.util;

import java.io.File;
import java.io.IOException;

public final class DirUtils {
    public static void mkdir(String dirName) {
        File dir = new File(dirName);
        dir.mkdirs();

        System.out.println("mkdir: " + dirName);
    }

    public static void createFile(String fileName) throws IOException {
    	File file = new File(fileName);
    	if (!file.exists()) {
    		file.createNewFile();
    	}

        System.out.println("createFile: " + fileName);
    }
    
	
    private DirUtils() {
    }
}

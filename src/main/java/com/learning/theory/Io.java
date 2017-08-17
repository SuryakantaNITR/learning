package com.learning.theory;

import java.io.*;

public class Io {
	public static void main(String[] args) {
		File file = new File("/tmp/javaFile.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			fw.write("Hello! My name is Khan.\n");
			fw.write("And I'm a terrorist.\n");
			fw.flush();
			fw.close();
		}
		catch(IOException ex){
			System.out.println(ex);
		}
		try {
			char[] in = new char[50];
			FileReader fr = new FileReader(file);
			System.out.println(fr.read(in));
			System.out.println(in);
			fr.close();
			
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
	}

}

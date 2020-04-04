package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IOTest {
	public static void main(String[] args)  {
		while(true) {
			try {
				FileInputStream in = new FileInputStream(new File("D:/test/notexixt.txt"));
			} catch (FileNotFoundException e ) {
				e.printStackTrace();
			}
		}
	}
}

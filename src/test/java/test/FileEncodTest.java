package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FileEncodTest {
	/**
	 * 测试文件编码问题
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		FileOutputStream outS = new FileOutputStream(new File("D:/temp/gbk2utf8.txt"));
		OutputStreamWriter out = new OutputStreamWriter(outS,"gbk");
		out.write("我是一个沙雕嘛？oh my god");
		out.close();
		Reader r = new FileReader(new File("D:/temp/gbk2utf8.txt"));
		BufferedReader br  = new BufferedReader(r);
		Writer w = new FileWriter(new File("D:/temp/test.txt"));
		BufferedWriter bw = new BufferedWriter(w);
		String tempStr = null;
		
	}
}

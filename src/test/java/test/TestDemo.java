package test;

import java.util.Random;

public class TestDemo extends Thread {
	public static void main(String[] args) {
		System.out.println(get(0));
		System.out.println(get(1));
		System.out.println(get(2));
		System.out.println(get(3));
		System.out.println(get(4));
		int count = 0;
		while(true) {
			System.out.println(new Random().nextInt(100) + 1);
			if (count ++ == 100) {
				break;
			}
			
		}
	}

	private static int get(int i) {
		try {
			int ret = 2/i;
			return ret;
		} catch (Exception e) {
			return 0;
		} finally {
			if (i == 0) {
				return -1;
			}
			else if (i == 1) {
				return 1;
			}
		}
	} 
} 

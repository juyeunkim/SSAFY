package com.ssafy.step1.bit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_6781 {

	/*
	 * 수행시간 - 457 ms
	 * 메모리 - 56,824 kb
	 * */
	// 카드색이 3개 동일한지 판단 - 동일하면 연속 or 증가하는지 판단
	static String result;
	static int[] num;
	static char[] color;
	static boolean stop;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input (1).txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			num = new int[9];
			color = new char[9];

			input = br.readLine();
			for (int i = 0; i < 9; i++)
				num[i] = input.charAt(i) - '0';
			input = br.readLine();
			for (int i = 0; i < 9; i++)
				color[i] = input.charAt(i);

			stop = false;
			result = "Continue";
			Game(0);

			System.out.println("#" + t + " " + result);
		}
	}

	private static void Game(int index) {
		char[] same = new char[3];
		int equ = 0, inc = 0;
		boolean exit = false;
		if(stop) return;
		
		// Game이 끝날경우인지 아닌지 판단 -> 아니면 index 교환
		out:
		for (int i = 0; i <= 6; i += 3) {
			same[0] = color[i];
			same[1] = color[i + 1];
			same[2] = color[i + 2];
			exit = false;
			if (same[0] == same[1] && same[1] == same[2]) {
				if (num[i] == num[i + 1] && num[i + 1] == num[i + 2]) {
					equ++; 
				}
				else if (num[i] + 1 == num[i + 1] && num[i + 1] + 1 == num[i + 2]) {
					inc++; 
				}
				else exit = true;
				
				if(exit) break out;

				if (equ + inc == 3) {
					result = "Win"; stop = true;
					return;
				}
			}
			else {
				break out;
			}
		}
	
		if(index == 9) return;
		// index교환
			for(int i=index; i<9; i++) {
				
				// swap
				swap(index, i);
				Game(index+1);
				// swap
				swap(i,index);
			}

		
	}
	
	static void swap(int i, int j) {
		int t1 = num[i];
		num[i] = num[j];
		num[j] = t1;
		
		char t2 = color[i];
		color[i] = color[j];
		color[j] = t2;
	}

}

package com.ssafy.step1.bit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_4012 {
/*
 * 메모리 - 22,344 kb
 * 수행시간 - 273 ms
 * */
	/*
	 * 1) NCN/2 : 조합 찾기
	 * 2) 조합 경우에서 대칭을 합하여 최소가 되는 값 
	 * */
	
	static int N,result;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("sample_input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		String[] input;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			visited = new boolean[N+1];
			//boolean[] num = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				s = br.readLine(); input = s.split(" ");
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(input[j-1]);
					
				}
			}
			
			result = Integer.MAX_VALUE;
			
			
			// 조합찾기
			Combi(0,0);
			
			if(result == Integer.MAX_VALUE)
				result = 0;
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static void Combi(int index, int cnt) {
		if(cnt == N/2) {
			int ans = 0;
			// true인 값의 모든 합
			for(int i=1; i<=N; i++) {
				if(!visited[i]) continue;
				for(int j=i+1; j<=N; j++) {
					if(visited[j]) ans += map[i][j] + map[j][i];
				}
			}
			// false인 값의 모든 차
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				for(int j=i+1; j<=N; j++) {
					if(!visited[j]) ans -= (map[i][j] + map[j][i]);
				}
			}
			
			ans = Math.abs(ans);
			
			if(result > ans) result = ans; 
			return;
		}
		
		for(int i=index+1; i<=N; i++) {
			// N C N/2 조합 구하기
			visited[i] = true;
			Combi(i, cnt+1);
			visited[i] = false;
		}
		
	}

}

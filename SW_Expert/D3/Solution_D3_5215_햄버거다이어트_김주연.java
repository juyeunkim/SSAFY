import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	/*
	 * 메모리 - 24,808 kb
	 * 실행시간 - 187 ms
	 * */
	static int[] score;
	static int[] kcal;
	static int N, L, result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			kcal = new int[N];
			
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			
			result = 0;
			func(0,0,0);
			
			System.out.println("#" + t+" "+result);
			
		}

	}
	
	//  ssum -  점수 합 ksum - 칼로리 합
	static public void func(int ssum, int ksum, int index) {
		if(ksum > L) return;
		
		if(index == N) {
			if(result < ssum) result = ssum;
			return;
		}
		
		func(ssum, ksum, index+1); // 안넣고
		func(ssum+score[index], ksum+kcal[index], index+1); // 넣고
		
	}

}

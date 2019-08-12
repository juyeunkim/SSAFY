import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메모리 - 27,880 kb
 * 수행시간 - 141 ms
 * */
public class Solution {

	static int N,M, result = 0;
	static char[][] map;
	static int[] r = {1,1,1};  // W B R
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("sample_input (3).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String input = br.readLine();
			String[] in = input.split(" ");
			N = Integer.parseInt(in[0]); M=Integer.parseInt(in[1]);
			
			map = new char[N][M];
			for(int i=0; i<N; i++) {
				input = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			
			// 색깔마다 1줄씩은 무조건 있어야한다 - 최소 M개 존재해야함
			result = 100000;
			painting(0,0);
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static void painting(int idx, int sum) {
		if(sum >= N) return;
		
		if(idx == 2) { // 마지막에는 무조건 N-r[0]-r[1]
			r[idx] = N - sum; 
			char[] color = {'W', 'B', 'R'};
			int ans = 0, row = 0;
			// r : W B R 행의 개수
			
			char paint;
			for(int c = 0; c<3; c++) {
				paint = color[c];
				for(int i =0; i<r[c]; i++) {
					for(int j=0; j<M; j++) {
						if(map[row][j] != paint) ans++;
					}
					row++;
				}
				
			}
			
			if(result > ans)
				result = ans;
			return; 
		}
		
		for(int i=1; i<=N-2; i++) {
			r[idx] = i;
			painting(idx+1, sum+i);
		}
		
		
		
	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_7733 {
/*
 * 메모리 - 32,148 kb
 * 수행시간 - 273 ms
 */
	
	/*
	 * 1) map에서 day 와 같은 값이면 -1로바꾸기
	 * 2) dfs로 덩어리 조각 세기
	 * 3) 덩어리 조각의 수가 감소하면 -- return
	 * 
	 * */
	static int N, result, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input-9.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			M = -1;
			String[] input; String s;
			for(int i=0; i<N; i++) {
				s = br.readLine();
				input = s.split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
					if(M < map[i][j]) M = map[i][j];
				}
			}
			
			result =1;
			cheeze(1);
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static void cheeze(int day) {
		
		// 쥐가 치즈를 먹음
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==day) {map[i][j] = -1; } 
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visited[i][j] = false;
			}
		}
		
		
		// 덩어리 수 세기
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]!=-1) {dfs(i,j); ans++;}
			}
		}
		
		
		if(result < ans) result = ans;
		//else if(result > ans) return;
		
		if(day == M) return;
		cheeze(day+1);
		
		
	}

	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		int next_x,next_y;
		for(int d =0; d<4; d++) {
			next_x = x+dx[d]; next_y = y+dy[d];
			
			if(next_x <0 || next_x>=N || next_y <0 || next_y>=N) continue;
			
			if(!visited[next_x][next_y] && map[next_x][next_y]!=-1) {dfs(next_x,next_y);}
		}
		
	}

}

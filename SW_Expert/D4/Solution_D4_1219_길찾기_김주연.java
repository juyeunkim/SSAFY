import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1219 {
/*
수행시간 - 118 ms
메모리 - 19,224 kb
*/
	static int[][] map;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 최대 두개갈림길 , 일방통행 - 다시 되돌아오지 못함
		// 갈수있으면 1, 없으면 0
		
		System.setIn(new FileInputStream("input-9.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		String[] input;
		int T;
		for(int t=1; t<=10; t++) {
			s = br.readLine();
			input = s.split(" ");
			
			T = Integer.parseInt(input[0]);
			int N = Integer.parseInt(input[1]);
			map = new int[2][N];
			int from ,to;
			
			s = br.readLine();
			input = s.split(" ");
			// index -from , 값 -to
			for(int i=0; i<input.length; i+=2) {
				from = Integer.parseInt(input[i]); to = Integer.parseInt(input[i+1]);
				if(map[0][from]!=0)
					map[1][from] = to;
				else
					map[0][from] = to;
			}
			
			result = 0;
			visited = new boolean[N];
			dfs(0);
			
			
			System.out.println("#"+t+" "+result);
		}
		
	}

	private static void dfs(int start) {
		if(map[0][start]==99 || map[1][start]==99) {
			result = 1; return;
		}
		visited[start] = true;
		int from ;
		for(int i=0; i<2; i++) {
			from = map[i][start];
			if(!visited[from] && map[i][from]!=0) {
			if(!visited[from] && map[i][from]!=0) {
				dfs(from); // 단방향이기 때문에 visited 값 변경할 필요 X
			}
		}
		
		
	}
}

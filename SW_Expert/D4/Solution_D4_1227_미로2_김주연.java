import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1227 {
/*
메모리 - 24,616 kb
수행시간 - 143 ms
*/
	static int[] dest;
	static int result;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input-9.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		int T;
		for(int t=1; t<=10; t++) {
			T = Integer.parseInt(br.readLine());
			// 1은 벽, 0은 길, 3- 도착점
			map = new char[100][100];
			dest = new int[2];
			
			for(int i=0; i<100; i++) {
				s = br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='3') {
						dest[0] = i; dest[1] = j;
					}
				}
			}
			visited = new boolean[100][100];
			
			result = 0; // 1-가능 0-가능하지 않음
			dfs(1,1);
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static void dfs(int x, int y) {
		if(x==dest[0] && y==dest[1]) {
			result = 1;
			return;
		}
			
		
		visited[x][y] = true;
		int xx,yy;
		for(int d=0; d<4; d++) {
			xx = x+dx[d]; yy = y+dy[d];
			
			if(xx<0 || yy<0 || xx>=100 || yy>=100 || map[xx][yy]=='1') continue;
			
			if(!visited[xx][yy] && (map[xx][yy]=='0' || map[xx][yy]=='3')) {
				visited[xx][yy] = true;
				dfs(xx,yy);
				visited[xx][yy] = false;
			}
			
		}
		
	}

}

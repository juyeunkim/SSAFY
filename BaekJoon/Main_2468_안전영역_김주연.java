import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역_김주연 {
/*
메모리 - 20148 kb
수행시간 - 212ms
*/
	static boolean [][] visited;
	static int[][] map;
	static int result, N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int m = 0;
		
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > m) m = map[i][j];
			}
		}
		
		result = 1;
		boolean go = false;
		for(int a=1; a<m; a++) {
			// 높이가  a 이하 물에 잠김
			go = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == a) {
						map[i][j] = -1; go = true;
					}
				}
			}
			
			if(go) {
				// 안전한 영역 계산
				visited = new boolean[N][N];
				int tmp = 0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j]!=-1 && !visited[i][j]) {
							DFS(i,j); tmp++;
						}
					}
				}
				
				// 최대 영역 계산
				if(result < tmp) result = tmp;
			}
			
			
		}
		
		System.out.println(result);
		
		
	}
	private static void DFS(int x, int y) {
		int xx,yy;
		
		visited[x][y] = true;
		
		for(int d=0; d<4; d++) {
			xx = x+dx[d]; yy = y+dy[d];
			
			if(xx <0 || xx >= N || yy <0 || yy >=N) continue;
			
			if(map[xx][yy]!=-1 && !visited[xx][yy]) {
//				visited[xx][yy] = true;
				DFS(xx,yy);
			}
		}
		
	}

}

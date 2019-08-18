import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1949 {
/*
메모리 - 20,524 kb
수행시간 - 129 ms
*/
	static ArrayList<Integer> qx, qy;
	static int[][] map;
	static boolean[][] visited;
	static int N,result,K;
	static int[] dx = {0,0,1,-1}; 
	static int[] dy = {1,-1,0,0}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input-9.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String s;
		String[] input;
		for(int t=1; t<=T; t++) {
			s = br.readLine(); input = s.split(" ");
			N =Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			map = new int[N][N];
			int mm = 0;
			
			qx = new ArrayList<Integer>();
			qy = new ArrayList<Integer>();
			result = 1;
			
			// 입력
			for(int i=0; i<N; i++) {
				s = br.readLine(); input = s.split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
					if(mm < map[i][j]) mm = map[i][j];
				}
			}
			
			findMax(mm); // 봉우리가 가장 높은 i,j기록
			
			for(int i=0; i<qx.size(); i++) {
				visited = new boolean[N][N];
				start(qx.get(i),qy.get(i), 1, false); // 자기자신부터 시작 하므로 1부터 시작
			}
			
			
			
			System.out.println("#"+t+" "+result);
		}
	}
	public static void start(int x, int y, int road, boolean cut) {
		int xx, yy;
		visited[x][y] = true;
		
		for(int d=0; d<4; d++) {
			xx = x+dx[d]; yy = y+dy[d];
			
			if(xx < 0 || xx >= N || yy < 0 || yy >= N || visited[xx][yy]) continue;
			
			if(!visited[xx][yy]) {
				visited[xx][yy] = true;
				// 자기 자신보다 작은산으로 이동
				if(map[x][y] > map[xx][yy]) {
					start(xx,yy,road+1, cut);
				}
				// 자기자신보다 같거나 높은점을 k 
				else if(!cut) {
					int befo = map[xx][yy];
					for(int i=1; i<=K; i++) {
						map[xx][yy]--;
						if(map[x][y] > map[xx][yy]) 
							start(xx, yy, road+1, true);
					}
					map[xx][yy] = befo;
				}
        // visited를 다시 돌려놓음
				visited[xx][yy] = false;
				
			}
			
			
		}
		
		if(result < road)
			result = road;
		
		
		
	}
	private static void findMax(int mm) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(mm == map[i][j]) {
					qx.add(i); qy.add(j);
				}
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 메모리 - 28,024 kb
 * 수행시간 - 145 ms
 * */
public class Solution_1953 {

	
	static int N,M,R,C,L,result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};  // 우 좌 하 상
	static int[] dy = {1,-1,0,0};
	static int[][] possilbe = {{1,3,6,7},{1,3,4,5},{1,2,4,7},{1,2,5,6}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			R = Integer.parseInt(st.nextToken()); // 맨홀 	세로
			C = Integer.parseInt(st.nextToken()); // 		가로
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요시간
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			BFS(R,C);
			
			
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	private static void BFS(int x, int y) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> h = new LinkedList<Integer>();
		
		int cur_x, cur_y, cur_h;
		int next_x,next_y;
		int dir; //, hour = 1;
		qx.offer(x); qy.offer(y); h.offer(1);
		result = 1;
		
		
		
		while(!qx.isEmpty()) {
			cur_x = qx.poll(); cur_y = qy.poll();  cur_h = h.poll();
			dir = map[cur_x][cur_y];  visited[x][y] = true;
			
			if(cur_h>=L) continue; // 주어진 시간을 벗어나면
			
			switch (dir) {
			case 1:
				for(int d = 0; d<4; d++) {
					next_x = cur_x + dx[d]; next_y = cur_y + dy[d];
					
					if(next_x <0 || next_y<0 || next_x>=N || next_y>=M) continue;
					if(!visited[next_x][next_y] && map[next_x][next_y]!=0 ) {
						for(int p = 0; p<4; p++) {
							if(map[next_x][next_y] == possilbe[d][p]) {
								visited[next_x][next_y] = true;
								qx.offer(next_x); qy.offer(next_y); h.offer(cur_h+1);
								result++;
							}
						}
						
					}
					
				}
				break;
			case 2:
				for(int d = 2; d<4; d++) {
					next_x = cur_x + dx[d]; next_y = cur_y + dy[d];
					
					if(next_x <0 || next_y<0 || next_x>=N || next_y>=M) continue;
					if(!visited[next_x][next_y] && map[next_x][next_y]!=0) {
						
						for(int p = 0; p<4; p++) {
							if(map[next_x][next_y] == possilbe[d][p]) {
								visited[next_x][next_y] = true;
								qx.offer(next_x); qy.offer(next_y); h.offer(cur_h+1);
								result++;
							}
						}
						
					}
					
				}
				break;
			case 3:
				for(int d = 0; d<2; d++) {
					next_x = cur_x + dx[d]; next_y = cur_y + dy[d];
					
					if(next_x <0 || next_y<0 || next_x>=N || next_y>=M) continue;
					if(!visited[next_x][next_y] && map[next_x][next_y]!=0) {
						for(int p = 0; p<4; p++) {
							if(map[next_x][next_y] == possilbe[d][p]) {
								visited[next_x][next_y] = true;
								qx.offer(next_x); qy.offer(next_y); h.offer(cur_h+1);
								result++;
							}
						}
					}
					
				}
				break;
			case 4:
				for(int d = 0; d<4; d+=3) {
					next_x = cur_x + dx[d]; next_y = cur_y + dy[d];
					
					if(next_x <0 || next_y<0 || next_x>=N || next_y>=M) continue;
					if(!visited[next_x][next_y] && map[next_x][next_y]!=0) {
						for(int p = 0; p<4; p++) {
							if(map[next_x][next_y] == possilbe[d][p]) {
								visited[next_x][next_y] = true;
								qx.offer(next_x); qy.offer(next_y); h.offer(cur_h+1);
								result++;
							}
						}
					}
					
				}
				break;
			case 5:
				for(int d = 0; d<4; d+=2) {
					next_x = cur_x + dx[d]; next_y = cur_y + dy[d];
					
					if(next_x <0 || next_y<0 || next_x>=N || next_y>=M) continue;
					if(!visited[next_x][next_y] && map[next_x][next_y]!=0) {
						for(int p = 0; p<4; p++) {
							if(map[next_x][next_y] == possilbe[d][p]) {
								visited[next_x][next_y] = true;
								qx.offer(next_x); qy.offer(next_y); h.offer(cur_h+1);
								result++;
							}
						}
					}
					
				}
				break;
			case 6:
				for(int d = 1; d<3; d++) {
					next_x = cur_x + dx[d]; next_y = cur_y + dy[d];
					
					if(next_x <0 || next_y<0 || next_x>=N || next_y>=M) continue;
					if(!visited[next_x][next_y] && map[next_x][next_y]!=0) {
						for(int p = 0; p<4; p++) {
							if(map[next_x][next_y] == possilbe[d][p]) {
								visited[next_x][next_y] = true;
								qx.offer(next_x); qy.offer(next_y); h.offer(cur_h+1);
								result++;
							}
						}
					}
					
				}
				break;
			case 7:
				for(int d = 1; d<4; d+=2) {
					next_x = cur_x + dx[d]; next_y = cur_y + dy[d];
					
					if(next_x <0 || next_y<0 || next_x>=N || next_y>=M) continue;
					if(!visited[next_x][next_y] && map[next_x][next_y]!=0) {
						for(int p = 0; p<4; p++) {
							if(map[next_x][next_y] == possilbe[d][p]) {
								visited[next_x][next_y] = true;
								qx.offer(next_x); qy.offer(next_y); h.offer(cur_h+1);
								result++;
							}
						}
					}
					
				}
				break;

			}
			
		}
		
		
	}

}

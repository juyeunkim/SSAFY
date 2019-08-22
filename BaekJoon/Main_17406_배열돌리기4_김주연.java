import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4_김주연{
/*
메모리 - 65676 KB
수행시간 - 296 ms
*/

	// result : 배열의 최소합
	static int[] permutation;
	static int[][] map;
	static int[][] turn;
	static int[][] befo; // 계산후 되돌릴때 사용하는 변수
	static int result, N,M,K;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// N,M - 배열의 크기
		// K - 회전 연산의 개수
		
		N = Integer.parseInt(st.nextToken()); M= Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		
		
		permutation = new int[K];
		befo = new int[N][M];
		map = new int[N][M];
		turn = new int[K][3]; // x, y, 범위
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			permutation[i] = i;
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken())-1; // x
			turn[i][1] = Integer.parseInt(st.nextToken())-1; // y
			turn[i][2] = Integer.parseInt(st.nextToken()); // 범위
		}
		
		// 이전 값 저장
		copyArr(befo, map);		
		result = Integer.MAX_VALUE;
		// 순열만큼 turn 배열 바꾸기
		P(0);
		// 바뀐 turn 을 기준으로 배열 돌리기
		// row의 합중에서 가장 최소 구하기
		
		
		System.out.println(result);
		
		
	}
	private static void P(int index) {
		if(index == K) {
			// 순열 완성
			
			// 배열 회전
			int idx;
			for(int a=0; a<K; a++) {
				idx = permutation[a];
				
				cycle2(turn[idx][0],turn[idx][1],turn[idx][2]);
			}
			
			int ans;
			for(int i=0; i<N; i++) {
				ans = 0;
				for(int j=0; j<M; j++) {
					ans += map[i][j];
					
					if(ans > result) break;
				}
				if(result > ans) result = ans;
			}
			
			// 배열 돌려놓기
			copyArr(map, befo);
			return;
		}
		
		for(int i=index; i<K; i++) {
			swap(i,index);
			P(index+1);
			swap(index,i);
		}
		
	}
	
	private static void cycle2(int x, int y, int range) {
		int sx,sy; // 왼쪽 대각선
		int xx,yy;
		int bx,by;
		
		// cnt : 1 range : 2
		int[][] t = new int[N][M]; // 계산할때 쓸 배열
		copyArr(t,map);
		
		
		for(int r = 1; r<=range; r++) {
			sx = x-r; sy = y-r;
			xx = sx; yy = sy;
			for(int d=0; d<4; d++) {
				for(int c = 1; c <= r*2; c++) {
					bx = xx; by = yy; // 이전 값 대입
					xx += dx[d]; yy +=dy[d];
					
					if(xx <0 || yy<0|| xx>=N || yy>=M) continue;
					
					map[xx][yy] = t[bx][by];
					
				}
			}
		}
		//cycle2(x, y, cnt+1, range);
		
		
		
	}
	
	private static void copyArr(int[][] from, int[][] to) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				from[i][j] = to[i][j];
			}
		}
		
	}
	// turn의 배열을 바꿔줌
	private static void swap(int i, int j) {
		int tmp = permutation[i];
		permutation[i] = permutation[j];
		permutation[j] = tmp;
		
		
	}
	
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247 {
/*
수행시간 - 1,073 ms
메모리 - 22,024 kb
*/
	static int N,result;
	static int[][] me;
	static int[][] cust;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input-9.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			// 회사 좌표, 집의 좌표, 고객의 좌표
			me = new int[2][2];
			cust = new int[N][2];
			
			for(int i=0; i<2; i++) {
				me[i][0] = Integer.parseInt(st.nextToken()); // x
				me[i][1] = Integer.parseInt(st.nextToken()); // y
			}
			
			for(int i=0; i<N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken()); // x
				cust[i][1] = Integer.parseInt(st.nextToken()); // y
			}
			
			result = Integer.MAX_VALUE;
			// 가능한 모든 경로 따지기 -> 순열
			P(0);
			
			// 이동경로가 가장 짧은 경로
			System.out.println("#"+t+" "+result);
		}

	}

	private static void P(int index) {
		if(index == N) {
			int ans = 0;
			for(int i=0; i<N; i++) {
				if(i==0) { // 회사 - 집 거리
					ans += Math.abs(me[0][0] - cust[i][0]) + Math.abs(me[0][1] - cust[i][1]);
				}else {
					ans += Math.abs(cust[i][0] - cust[i-1][0]) + Math.abs(cust[i][1] - cust[i-1][1]);
				}
				
				if(i==N-1) { // 집 - 기사 집
					ans += Math.abs(me[1][0] - cust[i][0]) + Math.abs(me[1][1] - cust[i][1]);
				}
				
				if(ans > result) break; // 이미 최대를 넘으면 더 볼필요가 없으므로 break;
			}
			
			if(result > ans) result = ans;
			
			return;
		}
		
		for(int i = index; i<N; i++) {
			swap(index, i);
			P(index+1);
			swap(i, index);
			
		}
		
		
	}
	public static void swap(int i, int j) {
		int tx = cust[i][0], ty = cust[i][1];
		cust[i][0] = cust[j][0];
		cust[j][0] = tx;
		
		cust[i][1] = cust[j][1];
		cust[j][1] = ty;
	}

}

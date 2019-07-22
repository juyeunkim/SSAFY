import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			int result = 1; // 자신의 수를 합하면 무조건 N이므로 result = 1
			for(int i=1; i<N; i++) {
				sum = i;
				// i 에서 연속하는 수 합하기
				// i + (j, j+1 ...)
				for(int j=i+1;j<N;j++) {
					// 연속하는 수의 합이 N 이거나 범위를 벗어나므로 break;
					if(sum+j >= N) {
						if(sum+j == N) result++; 
						break;}
					
					sum+=j;
				}
			}
			
			
			System.out.println("#"+t+" "+result);
		}
	}

}

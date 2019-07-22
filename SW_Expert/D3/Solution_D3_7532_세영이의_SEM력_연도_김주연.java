import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	/*
	 * 태양을 기준으로 지구와 달을 비교하여 연도 구하기
	 * 이때, % 를 사용하면 범위가 0~ (범위-1) 이므로
	 * 0 이면 범위로 바꿔준다
	 * 
	 * 태양을 기준으로 year += 365 해서, 지구와 달을 나눴을때 값이 같으면
	 * result에 year 값 대입
	 * */

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] uni = new int[3];
			int[] cycle = {365,24,29};
			for(int i=0; i<3; i++)
				uni[i] = Integer.parseInt(st.nextToken());
			
			// 0 : 태양(S)  1: 지구(E)  2: 달(M)
			// 태양: 365     지구: 24	  달: 29
			
			int result = 0, year, mul = 0;
			
			// year % 24 의 범위는 (0~23) 이므로 uni[1] == 24 이면 0 으로 바꿔주기
			if(uni[1] == 24) uni[1] = 0;
			if(uni[2] == 29) uni[2] = 0;
			while(true) {
				year = uni[0] + mul * 365;
				// 태양을 기준으로 지구 달 비교
				if(year % 24 == uni[1] && year % 29 == uni[2]) {
					result = year; break;
				}
				else mul++;
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

}

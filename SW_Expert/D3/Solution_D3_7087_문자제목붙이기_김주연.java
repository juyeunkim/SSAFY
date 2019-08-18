import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7087 {
/*
메모리 - 18,812 kb
수행시간 - 117 ms

계속 틀렸던 이유 - 처음부터 증가하는 문자열을 찾고있어서 문제 !
               ==> 처음부터 앞의 대문자를 읽어 alpha에 방문했는지 체크하고 alpha를 true
                   alpha를 0부터 26까지 읽으면서 중간에 false가 발생하면 break; -> A~Z중에 한번만 등장하고, 증가하는 문자열의 길이
                              

수행시간 - 117 ms
수행시간 - 117 ms
*/
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 알파벳은 한번만 등장
		// 중간에 건너뛰면안됨, - 건너뛰면 포함 X
		System.setIn(new FileInputStream("input-9.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String s;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			char me;
			boolean[] alpha = new boolean[26];
			
			for(int i=0; i<N; i++) {
				s = br.readLine();
				me = s.charAt(0);
				
				if(!alpha[me-'A']) {
					alpha[me-'A'] = true;
				}
				
			}
			
			for(int i=0; i<26; i++) {
				if(!alpha[i]) break;
				result++;
			}
			
			
			System.out.println("#"+t+" "+result);
		}
	}

}

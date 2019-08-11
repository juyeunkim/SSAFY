import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메모리 - 23,720 kb
 * 실행시간 - 142 ms
 * */

// runtime error 떴던 이유
// 알파벳 1~26이라서 alpha 배열이 27개여야하는데 26개만 만들어줘서 에러발생!!!!!
public class Solution_7792 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] name = new String[N];
			String result="";
			char input;
			int[] m = new int[2]; // 0 은 인덱스 1은 값
			int tmp;
			for(int i=0; i<N; i++) {
				boolean[] alpha = new boolean[27];
				tmp = 0;
				
				name[i] = br.readLine();
				for(int j=0; j<name[i].length(); j++) {
					input = name[i].charAt(j);
					
					if(input == ' ') continue;
					
					if(!alpha[input-'A']) {
						alpha[input-'A'] = true; tmp++;
					}
				}
				// 알파벳 종류가 많을 수록
				// 사전순으로 앞선사람 - result와 name[i] 비교
				if(tmp >m[1]) {
					m[0] = i; m[1] = tmp; result = name[i];
				}
				else if(tmp == m[1]) {
					int len; // result와 name중 길이가 짧은곳에 len 저장
					if(result.length() > name[i].length()) len = name[i].length();
					else len = result.length();
					
					for(int j=0; j<len; j++) {
						// 사전순 비교 - 앞자리가 같으면 넘어가고, 다르면 비교
						if(result.charAt(j) == name[i].charAt(j)) continue;
						
						if(result.charAt(j) > name[i].charAt(j)) {
							m[0] = i; result = name[i];
						}
						else break;
						
					}
				}
				
			}
			

			System.out.println("#" + t + " " + result);
		}

	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메모리 - 27,756 kb
 * 수행시간 - 121 ms
 * */
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("sample_input (3).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = new String[5];
			int[] len = new int[5];
			int mm = -1; // 가장 큰 len
			String result ="";
			for(int i=0; i<5; i++) {
				s[i] = br.readLine();
				len[i] = s[i].length();
				if(len[i] > mm) mm = len[i]; 
			}
			// 세로부터 읽는다. 
			// 이때, 읽으려는 index가 len 보다 작으면 continue
			// j는 행 i는 열
			for(int i=0; i<mm; i++) {
				for(int j=0; j<5; j++) {
					if(i >= len[j]) continue;
					
					result += s[j].charAt(i);
				}
			}
			
			
			System.out.println("#"+t+" "+result);
		}
	}

	

}

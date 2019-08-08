import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	/*
	 * 메모리 - 132,496 kb
	 * 수행시간 - 590 ms
	 * */

	static int[] m = new int[2];
	static int[] arr;
	// 하루 최대 1만큼 구입
	// 판매는 얼마든지
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input-7.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr = new int[N];
			long result = 0;
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// m[0] - index, m[1] - 값
			
			for(int i=0; i<N; i++) {
				findM(i); 
				if(m[0]==i) continue; // maxIndex가 자기 자신이다 ->더이상 돌려볼 필요가 없으므로 continue;
				
				for(int j=i; j<m[0]; j++) { // Max값과 i부터 maxIndex-1까지 빼서 저장
					result += m[1] - arr[j];
				}
				i = m[0];
			}
			
			System.out.println("#"+ t + " " + result);
		}

	}
	private static void findM(int start) { // 배열에서 가장 큰값의 index과 결과값 가져오기
		m[0] = start; m[1] = arr[start];
		for(int i=start+1; i<arr.length; i++) {
			if(arr[i] > m[1]) {
				m[0] = i; m[1] = arr[i];
			}
		}
		
	}

	

	

}

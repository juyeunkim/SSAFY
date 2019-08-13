import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 메모리 - 18,296 kb
 * 수행시간 - 116 ms
 * */
public class Solution {
	
	static int[] arr;
	static int result,P;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			P = Integer.parseInt(br.readLine());
			arr = new int[P];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<P; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			result = Integer.MAX_VALUE;
			if(P==1)
				result = arr[0] * arr[0];
			else
				findP(0,1,0);
			
			System.out.println("#"+t+" "+result);
		}
	}
	private static void findP(int index, int sum, int cnt) {
		if(index == P || cnt == 2) {
			boolean IsPW = true;
			for(int i=0; i<P; i++) {
				// sum에 원소가 있고, 자기자신이 아닌지 판단
				if(sum % arr[i] !=0 || sum == arr[i]) {IsPW = false; break;}
			}
			// 작은값인지 확인
			if(IsPW && result > sum) result = sum;
			return;
		}
		
		
		for(int i=index; i<P; i++) {
			findP(i,sum*arr[i],cnt+1);
		}
	}
}

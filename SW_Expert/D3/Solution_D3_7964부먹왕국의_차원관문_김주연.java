import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	/*
	 *1) i 번째에 0인지 파악 - 0이면 벽이 허물어졌으므로 result++,
	 *	 map[i] 에 벽추가
	 *
	 *2) i 번째에서 이동거리안에 1이있는지 파악
	 *		있으면	-> i 인덱스를 i+j바꿔주고 
	 *3)	없으면 	-> i 인덱스를 i+C로 변경
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[] map = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				map[i] = Integer.parseInt(st.nextToken());
			int result = 0;
			
			for(int i=0; i<N; i++) {
				// 1)
				// 차원관문이 파괴당했으므로 벽 추가
				if(map[i]==0) {
					map[i] = 1; result ++;
				}
				boolean wall = false;
				for(int j=1; j<=C; j++) {
					if(i+j>=N) break;
					// 2)
					// 중간에 벽이있으면 i의 인덱스를 i+j로 변경
					if(map[i+j]==1) {
						i = i+j-1;
						wall = true; break;
					}
				}
				// 3)
				// 중간에 벽이없으면 i의 인덱스를 i+C로 변경후
				// map[]에 추가
				if(!wall && i+C<N) {
					result ++; i=i+C-1; map[i+1] = 1; 
				}
				
			}
			
			
			System.out.println("#"+t+" "+result);
		}
	}

}

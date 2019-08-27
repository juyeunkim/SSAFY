import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 메모리 - 8MB
 * 수행시간 - 108ms
 * */
public class Main_1828 {
	static class Temper implements Comparable<Temper>{
		int xi; // 최저
		int yi; // 최고
		
		
		public Temper(int xi, int yi) {
			super();
			this.xi = xi;
			this.yi = yi;
		}
		
		@Override
		public String toString() {
			return "Temper [xi=" + xi + ", yi=" + yi + "]";
		}

		@Override
		public int compareTo(Temper o) {
			// 최고 온도 순으로 정렬 - 값이 같으면 최저를 비교
			int value  = this.yi-o.yi;
			return value==0? this.xi-o.xi : value;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Temper[] list = new Temper[N];
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Temper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(list);
//		
		int end, result = 0;
		for(int i=0; i<N; i++) {
			if(visited[i]) continue; // 이미 방문한 자리라면 continue
			
			end = list[i].yi; // i번째의 최고 온도
			for(int j=0; j<N; j++) {
				if(i==j) continue; // 자기 자신은 볼필요 없으므로 continue
				
				// 최고온도가 다른 최저-최고 사이에 있으면
				// visited[]를 true 
				if(list[j].xi<=end && list[j].yi>=end) { 
					visited[j] = true; 
				}
				
			}
			// 필요한 냉장고 수 증가
			result++;
		}
		
		
		System.out.println(result);
	}

}

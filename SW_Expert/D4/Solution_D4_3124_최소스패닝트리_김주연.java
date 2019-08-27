import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 메모리 - 131,388 kb
 * 수행시간 - 1,912 ms
 * */
public class Solution_D4_3124_최소스패닝트리_김주연 {

	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 크루스칼 사용
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[][] map = new int[E][3]; // 0 : weight 1 : fir 2 : sec 
			parents = new int[V+1];
			Arrays.fill(parents, -1);
			
			for(int i=0; i<E; i++) {
				// A - B 가 C의 가중치로 연결
				st = new StringTokenizer(br.readLine());
				
				map[i][1] = Integer.parseInt(st.nextToken());
				map[i][2] = Integer.parseInt(st.nextToken());
				map[i][0] = Integer.parseInt(st.nextToken());
				
			}
			
			// 오름차순으로 정렬
			Arrays.sort(map,new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					int value = o1[0] - o2[0];
					return value==0? o1[1]-o2[1]:value;
				}
				
			});
			long result = 0;
			int cnt = 0;
			
			for(int i=0; i<E; i++) {
//				System.out.println(map[i][0]+" "+map[i][1]+" "+map[i][2]+" ");
				if(cnt == V-1) break;
				if(union(map[i][1], map[i][2])) {
					System.out.println(map[i][1]+" "+map[i][2]+" ");
					result += map[i][0]; cnt ++;
				}
			}
			
			
			System.out.println("#"+t+" "+result);
		}
		
		

	}
	
	private static boolean union(int a, int b) {
		// 2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		
		
		if(aRoot != bRoot) { // 3. union set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot; 
			return true;
		}
		
		return false;
	
	}
	
	private static int find(int a) {
		if(parents[a]<0) // 집합의 크기 + 루트
			return a; // 루트노드이면 자신의 번호 리턴
		
		// path compression : 리턴받은 루트노드의 값으로 자신의 부모를 갱산
		return parents[a] = find(parents[a]); // return받은 결과를 채워넣는다
		
	}

}

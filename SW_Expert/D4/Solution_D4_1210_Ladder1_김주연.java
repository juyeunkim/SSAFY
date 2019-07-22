import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 메모리 - 32,024 kb
 * 실행시간 - 182ms
 * */
public class Main {

	/*
	 * 1) map[][]=='2' 인 도착지점 좌표 구하기
	 * 2) 도착지점에서 올라가면서 좌,우,위 순서대로 가능한 경로 파악
	 * 	  x,y 값 변경, 이때 이동시 중복될 수도 있으므로 visited[][] 선언
	 * 3) x == 0 : 시작지점에 왔다는 뜻이므로,
	 * 				result = y 
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10; int tmp;
		for(int t=1; t<=T; t++) {
			int N = 100;
			int result = 0;
			tmp = Integer.parseInt(br.readLine());
			StringTokenizer st;
			char[][] map=new char[N][N];
			
			// 좌	우	위
			int dx[] = {0,0,-1};
			int dy[] = {-1,1,0};
			
			// 도착지점은 2
			int[] dest = new int[2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					// 1)
					if(map[i][j] == '2') {dest[0] = i; dest[1] = j;}
				}
			}
			
			// 목적지 x,y에서 위로 찾아가면서 col 찾기
			int x = dest[0], y = dest[1];
			boolean[][] visited = new boolean[100][100];
			while(true) {
				
				// 3)
				if(x==0) {result = y; break;}
				visited[x][y] = true;
				for(int k=0; k<3; k++) {
					// 2)
					int xx = x+dx[k], yy = y+dy[k];
					if(xx<0 || yy<0 || xx>=N || yy>=N || visited[xx][yy]) continue;
					
					// 방문하지도 않았으면서, 갈수있는 길이면 x,y값 change
					if(map[xx][yy]!= '0') {
						x = xx; y = yy; visited[x][y] = true;
					}
				}
			}
			
			
			
			
			
			System.out.println("#"+t+" "+result);
		}
	}

}

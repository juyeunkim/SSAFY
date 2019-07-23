import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 *  메모리 : 51,392 kb
 *  수행시간 : 276ms
 * */
public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		/*
		 * 위에꺼를 temp에 이동하고 ( 밑에가 3으로 이동하기 위해 1 -> 2 로 이동)
		 * 밑에꺼를 원하는 자리에 이동 후 (무조건 1 -> 3 으로 이동)
		 * 위에꺼를 합친다 (밑에가 이동하였으므로 2 -> 3 으로 이동)
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int result = (int)Math.pow(2, N) - 1; // 하노이 탑의 이동 개수는 2^N - 1
		System.out.println(result);
		moveTop(1,3,2,N);
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();
	}
	private static void moveTop(int from, int to, int temp, int N) throws IOException {
		if(N==0) return;
		
		// 위에를 이동
		moveTop(from,temp,to,N-1);
		// 자기자신 이동
		bw.write(from+" "+to+"\n");
		// 밑에 이동
		moveTop(temp,to,from,N-1);
	}
}


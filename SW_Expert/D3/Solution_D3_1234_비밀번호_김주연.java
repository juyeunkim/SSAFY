import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
메모리 - 23,680 kb
수행시간 - 107 ms
*/

public class Solution {

		public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input-7.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T ;
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문자열 길이
			String input = st.nextToken();
			Stack<Integer> s = new Stack<Integer>();
			int num;
			
			for(int i=0; i<input.length(); i++) {
				num = input.charAt(i)-'0';
				if(s.isEmpty() || s.peek()!=num) s.push(num); 
				else s.pop(); // 연속되는 수를 만나면 pop해준다
			}
			
			String result = "";
			String tmp ="";
			while(!s.isEmpty()) {
				tmp = s.pop().toString();
				result = tmp + result; // 문자열을 순서대로 
			}
			System.out.println("#" + t + " " + result);
		}

	}

	

}

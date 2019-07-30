import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Solution_D4_1218_괄호짝짓기_김주연 {

	/*
	 * 메모리 - 26,236kb
	 * 실행시간 - 111ms
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for(int t=1; t<=T; t++) {
			int len = Integer.parseInt(br.readLine());
			String line = br.readLine();
			Stack<Character> s = new Stack<Character>();
			int result = -1;
			for(int i=0; i<len; i++) {
				// 여는 괄호이면 stack에 push
				if(line.charAt(i) == '(' || line.charAt(i) == '[' || line.charAt(i) == '{'|| line.charAt(i) == '<')
					s.push(line.charAt(i));
				else if(!s.isEmpty()){
					// stack의 top과 닫는문자열 비교
					// 같으면 continue, 다르면 유효하지않음
					char tmp = s.pop();
					if(tmp == '('  && line.charAt(i) != ')' ) {result = 0; break;}
					if(tmp == '['  && line.charAt(i) != ']' ) {result = 0; break;}
					if(tmp == '{'  && line.charAt(i) != '}' ) {result = 0; break;}
					if(tmp == '<'  && line.charAt(i) != '>' ) {result = 0; break;}
					
				}else {
					// stack이 비어있으면서 닫는 괄호이면 유효하지않음
					result = 0; break;
				}
					
				result = 1;
			}
			
			
			
			System.out.println("#"+t+" "+result);
		}

	}

}

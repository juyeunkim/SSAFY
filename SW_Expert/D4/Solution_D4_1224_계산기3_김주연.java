import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
 /*
 메모리 - 23,680 kb
 실행시간 - 111 ms
 */
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            Stack<Integer> num = new Stack<Integer>();
            Stack<Character> calc = new Stack<Character>();
            int result = 0;
            int fir, sec;
            char input;
            String s = "";
 
            for (int i = 0; i < len; i++) {
                input = line.charAt(i);
 
                if (input == '(')
                    calc.push(input);
                else if (input == ')') { // 여는 괄호를 만날때 까지 모두 pop()
                    while (!calc.isEmpty() && calc.peek() != '(') {
                        s += calc.pop();
                    }
                    if (calc.peek() == '(')
                        calc.pop();
                } else if (input == '+') { // +보다 우선순위가 높은 +,*를 만날때 까지 pop
                    while (!calc.isEmpty() && (calc.peek() == '*' || calc.peek() == '+')) {
                        s += calc.pop();
                    }
                    calc.push(input);
                } else if (input == '*') {
                    while (!calc.isEmpty() && calc.peek() == '*') {
                        s += calc.pop();
                    }
                    calc.push(input);
 
                  // 숫자를 저장
                } else {
                    s += input;
                }
            }
            
            // 남아있는 모든 수를 저장 - 괄호가 없는 계산식
            while (!calc.isEmpty())
                s += calc.pop();
 
            //System.out.println(s);
            
            // S에는 후위계산식으로 저장되어있으므로 부호(+,*)를 만나면 두번 pop해서 결과 계산후 push
            for (int i = 0; i < s.length(); i++) {
                input = s.charAt(i);
                if (input == '+' || input == '*') {
                    fir = num.pop();
                    sec = num.pop();
                    if (input == '+')
                        num.push(fir + sec);
                    else
                        num.push(fir * sec);
                } else
                    num.push(input - '0');
 
            }
 
            System.out.println("#" + t + " " + num.peek());
        }
    }
 
}

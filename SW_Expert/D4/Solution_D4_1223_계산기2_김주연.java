import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
 /*
 메모리 - 25,364 kb
 실행시간 - 112 ms
 */
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("input (4).txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = 10;
        for(int t=1; t<=T; t++) {
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            Stack<Integer> num = new Stack<Integer>();
            int result = 0;
            // 부호가 *이면 앞의 수와 뒤에 수를 곱한값을 Stack num에 저장
            for(int i=0; i<len; i++) {
                if(line.charAt(i)=='*') {
                    int fir = num.pop();
                    int sec = line.charAt(i+1)-'0';
                    num.push(fir*sec);
                    i++;
                }
                // 입력받은 숫자를 Stack num에 저장
                else if(line.charAt(i)!='+'){
                    num.push(line.charAt(i)-'0');
                }
            }
             
             // num에 들어있는 수는 +를 해야하는 숫자이므로 result에 모든 결과값 더하기
            while(!num.isEmpty()) {
                result += num.pop();
            }
             
             
            System.out.println("#"+t+" "+result);
        }
    }
 
}

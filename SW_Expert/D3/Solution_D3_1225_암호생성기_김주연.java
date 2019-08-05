import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
 /*
 메모리 - 33,896 kb
 실행시간 - 142 ms
 */
public class Solution {
 
    static int[] result;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input (7).txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10;
        for (int t = 1; t <= T; t++) {
            br.readLine();
            StringTokenizer st =  new StringTokenizer(br.readLine());
             
            result = new int[8];
            bfs(st);
            // 암호값 출력
            System.out.print("#" + t + " " );
            for(int i =0; i<7; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println(result[7]);
        }
    }
     
    private static void bfs(StringTokenizer st) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<8; i++) { // 암호 8자리 입력
            q.offer(Integer.parseInt(st.nextToken()));
        }
        int current = q.peek();
        int tmp = 0;
        out:
        while(!q.isEmpty()) {
             // 한사이클(5회) 동안 1~5만큼 빼서 맨뒤에 넣어주기
             // 이때 뺀 값이 0이하가 되면 0을 넣고 실행결과 종료
            for(int i=1; i<=5; i++) {
                tmp = q.poll()-i;
                if(tmp<=0) {
                    q.offer(0); break out;
                }
                q.offer(tmp);
            }
             
        }
         // 최종 암호값 입력
        for(int i=0; i<8; i++) {
            result[i] = q.poll();
        }
         
    }
 
}

/**************************************************************
    Problem: 1175
    User: wjg365
    Language: Java
    Result: Success
    Time:182 ms
    Memory:10640 kb
****************************************************************/
 
 
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
  
public class Main {
  
    static int N,M;
    static int[] dicecase;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 던진 횟수
        M = sc.nextInt(); // 눈의 합
          
        dicecase = new int[N];
        dice(0,0);
          
        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();
    }
  
    private static void dice(int index, int sum) throws IOException {
        if(sum > M) return;
          
        if(index == N ) {
            if(sum == M) {
                for(int i=0; i<N-1; i++) {
                    bw.write(dicecase[i]+" ");
                }
                bw.write(dicecase[N-1]+"\n");
            }
              
            return;
        }
          
         
         
        for(int i=1; i<=6; i++) {
            // 남아있는 수의 합이 M이 될수 있는지 판단
            if( sum+ i + (N-index-1)*6 < M) continue;
             
            dicecase[index] = i;
             
            dice(index+1, sum+dicecase[index]);
        }
          
          
          
          
    }
  
}

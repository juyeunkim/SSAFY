import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 - 23,948kb
실행시간 - 116ms
*/ 
 
 
public class Solution {
 
    static char[][] map;
    static int result = 0, len;
    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("input (8).txt"));
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = 10;
        for(int t=1; t<=T; t++) {
            result = 0;
            len = Integer.parseInt(br.readLine());
            map = new char[8][8];
            String input;
            for(int i=0; i<8;i++) {
                input =br.readLine();
                for(int j = 0;j<8; j++) {
                    map[i][j] = input.charAt(j);
                }
            }
             
            for(int i=0; i<8;i++) {
                for(int j = 0;j<8; j++) {
                    if(i+len-1<8 && palindRow(i,j)) result++;
                    if(j+len-1<8 && palindCol(i,j)) result++;
                }
            }
             
            System.out.println("#"+t+" "+result);
        }
 
    }
    private static boolean palindRow(int x,int y) {
        int begin=x, end = x+len-1;
         
        // 가로확인
        while(begin < end && (end <8)) {
            if(map[begin][y]!=map[end][y]) return false;
            begin++; end--; 
        }
         
         
        return true;
         
    }private static boolean palindCol(int x,int y) {
        int begin=y, end = y+len-1;
         
        // 세로확인
        while(begin < end && (end <8)) {
            if(map[x][begin]!=map[x][end]) return false;
            begin++; end--;
        }
         
         
        return true;
    }
 
}

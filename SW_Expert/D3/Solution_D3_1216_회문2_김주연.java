import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 /*
 메모리 - 31,768kb
 실행시간 - 241ms
 */
public class Solution {
 
    static char[][] map;
    static int result = 0;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("input (9).txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10;
        for (int t = 1; t <= T; t++) {
            br.readLine();
            result = 0;
            map = new char[100][100];
            String input;
            for (int i = 0; i < 100; i++) {
                input = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = input.charAt(j);
                }
            }
 
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++)
                    palind(i, j);
            }
 
            System.out.println("#" + t + " " + result);
        }
 
    }
 
    private static void palind(int x, int y) {
        int begin, end;
        int mid, ans = 0;
        boolean calc = true;
        // 행 이동
        for (int i = 99; i >= x; i--) {
            begin = x;
            end = i;
            calc = true;
            while (begin < end) {
                if (map[begin][y] != map[end][y]) {
                    calc = false;
                    break;
                }
                begin++;end--;
            }
 
            if (calc) {
                ans = i - x + 1;
                if (result < ans)
                    result = ans;
            }
        }
 
        // 열 이동
        for (int i = 99; i >= y; i--) {
            begin = y;end = i;calc = true;
            while (begin < end) {
                if (map[x][begin] != map[x][end]) {
                    calc = false;
                    break;
                }
                begin++;end--;
            }
 
            if (calc) {
                ans = i - y + 1;
                if (result < ans)
                    result = ans;
            }
        }
 
         
 
    }
 
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
/*
 * 메모리 - 100,644 kb
 * 실행시간 - 612 ms
 * */
public class Solution_D4_1251_하나로_김주연 {
 
    static class Pair implements Comparable<Pair>{
        int fir;
        int sec;
        double value;
         
        public int getFir() {
            return fir;
        }
 
        public int getSec() {
            return sec;
        }
         
        public double getValue() {
            return value;
        }
 
        Pair(int fir, int sec, double value){
            this.fir = fir;
            this.sec = sec;
            this.value = value;
        }
 
        @Override
        public String toString() {
            return "Pair [fir=" + fir + ", sec=" + sec + ", value=" + value + "]";
        }
        public int compareTo(Pair p1) {
             
            return Double.compare(this.value,p1.value);
        }
         
    }
     
         
    static int[] parents;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 인도네시아의 모든 섬들을 연결
         
        //System.setIn(new FileInputStream("input.txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
             
            //// input 
            int N = Integer.parseInt(br.readLine()); // 섬의 수
            long [][] xy =  new long [N][2]; // 0 : x 1 : y
          ArrayList<Pair> list = new ArrayList<>();
             
             
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                xy[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                xy[i][1] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine()); // 환경 부담 세율
             
             
            double calc;
            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    // calc = (x1-x2)^2 + (y1-y2)^2 - 해저터널 길이
                    calc = (xy[i][0]-xy[j][0]) * (xy[i][0]-xy[j][0])
                            + (xy[i][1]-xy[j][1]) * (xy[i][1]-xy[j][1]);
                    list.add(new Pair(i, j, calc));
                }
            }
 
            // 해저 터널길이가 작은순으로 정렬
            Collections.sort(list);
             
//          for(int i=0; i<list.size(); i++)
//              System.out.println(list.get(i));
             
             
             
             
            parents = new int[N];
            Arrays.fill(parents, -1);
             
            // 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L2)만큼 지불
            double result = 0;      
            int cnt = 0;
            for(int i=0; i<list.size(); i++) {
                if(cnt == N-1) break;
                if(union(list.get(i).getFir(), list.get(i).getSec())) {
                    result += list.get(i).getValue(); cnt++;
                }
            }
             
            result = result * E;
             
            System.out.println("#" + t + " " +Math.round(result));
        }
 
    }
    private static boolean union(int a, int b) {
        // 2. find set : 자신이 속한 집합 찾기
        int aRoot = find(a);
        int bRoot = find(b);
          
          
        if(aRoot != bRoot) { // 3. union set : 두 노드의 집합이 다르면 합치기
            parents[bRoot] = aRoot; 
            return true;
        }
          
        return false;
      
    }
      
    private static int find(int a) {
        if(parents[a]<0) // 집합의 크기 + 루트
            return a; // 루트노드이면 자신의 번호 리턴
          
        // path compression : 리턴받은 루트노드의 값으로 자신의 부모를 갱산
        return parents[a] = find(parents[a]); // return받은 결과를 채워넣는다
          
    }
  
     
 
}

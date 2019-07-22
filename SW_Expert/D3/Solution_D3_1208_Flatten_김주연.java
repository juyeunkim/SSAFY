import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 메모리 - 20,784 kb
 * 실행시간 - 146 ms
 * */
/*
	강사님 풀이 : 
	int count[100]
	int height

	count[height]++
	min = height[]
	max = height[]

	높이개수만큼 배열을 생성 ex) count[1] - 높이가 1인 개수
	min = arr[], max - 가장높은 배열의 index
	index 의 값을 min -1, max+1 로 변화
	count[min+1]++, count[max-1]++;

	if(arr[min] -1 == 0) min +1; 
	if(arr[max] +1 == 0) max -1;
*/
public class Solution_D3_1208_Flatten_김주연 {
	/*
	 * 1) box 배열을 오름차순으로 정렬 - box[1] : min box[100] : max
	 * 2) box[100] - box[1] 차이가 0 or 1인지 확인 -> 평탄화 완료 break
	 * 3) 만약 배열이 정렬이 되어있지 않다면 -> Arrays.sort(box)
	 * 4) box[1] 증가, box[100] 감소
	 * 
	 * 5) 마지막으로 배열을 정렬후, 
	 *    result = box[100] - box[1] 으로 낙차 계산 
	 * */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			
			int result = -1;
			
			int[] box = new int[101];
			int dump = Integer.parseInt(br.readLine()); // dump는 1000이하
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<101; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			
			// 1)
			// box[1] - 작은값 box[100] - 큰값
			Arrays.sort(box);
			
			for(int i=1; i<=dump; i++) {
				
				// 2)
				// gap이 0 or 1 -> 평탄화 완료
				int gap = box[100] - box[1];
				if(gap==1 || gap==0) {
					result = gap; break;
				}
				
				// 3)
				if(box[100] < box[99] || box[1] > box[2]) {
					Arrays.sort(box);
				}
				
				// 4)
				box[1]++; box[100]--;
				
			}
			
			
			// 5)
			Arrays.sort(box);
			
			if(result==-1)
				result = box[100] - box[1];
			
			
			
			System.out.println("#"+t+" "+result);
			}
		}

}

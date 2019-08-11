import java.util.Scanner;

/*
 * 메모리 - 112,316 kb
 * 수행시간 - 1,269 ms
 * */

//1) i번째에서 증가하는 index 찾기
// 2) index 가 마지막원소 || 증가하는 index가 없으면 (index == i) -> result = 0 continue
// 3) index +1 에서 부터 mm의 값보다 작으면서 && peek 보다 작으면 result ++; // 크면 break;

public class Solution_4796 {
	public static void main(String[] args) {
		// System.setIn(new FileInputStream("input-7.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			
			int[] m = new int[2]; // [0] 인덱스 [1] 값 
			int mm;
			int result = 0;
			for (int i = 0; i < N - 2; i++) { // 뒤에서 첫번째, 두번째는 볼필요가 없다.

				m[0] = i; m[1] = arr[i];
				
				// 증가하는 자리 찾기
				for (int j = i + 1; j < N; j++) {
					if (m[1] > arr[j])
						break;

					m[0] = j; m[1] = arr[j];
					
				}
				
				// m[1]은 max 값이된다.
				mm = m[1];

				if (m[0] == i || m[0] == N - 1) // 증가하는 부분이 없거나, 맨 마지막에 증가하면 산이 존재하지 않으므로 안된다.
					continue;

				int cnt = 0;
				// max index ~ N 에서 감소하는 길이 찾기
				// arr[j]는 mm 보다 작고, 이전에 있던것보다 작아야한다.
				for (int j = m[0] + 1; j < N; j++) {
					if (arr[j] > mm || arr[j] > m[1])
						break;

					cnt++; m[1] = arr[j];
				}
				// i~ maxindex-1까지 증가하는 부분은 같기 때문에 
				// maxindex에서 부터 감소하는 길이에 곱한다.
				result += cnt * (m[0]-i);
				// i~maxindex-1까지 계산 완료하였으므로 다음 index 부터 확인 한다.
				i = m[0];

			}

			System.out.println("#" + t + " " + result);
		}

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 메모리 - 15,916 kb
 * 실행시간 - 106ms
 * */

public class Solution_4047 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String input = br.readLine(); // S, D, H, C
			int[][] card = new int[4][14];
			int[] need = {13,13,13,13}; // 필요한 카드 수

			String result = "";
			char shape;
			int num;
			String tmp;
			for (int i = 0; i < input.length(); i += 3) {
				shape = input.charAt(i); // 모양
				tmp = input.substring(i + 1, i + 3); 
				num = Integer.parseInt(tmp); // 숫자
				switch (shape) {

				case 'S':
					
					if (card[0][num] != 0) {
						result = "ERROR";
					} else {
						card[0][num] = --need[0];
					}

					break;
				case 'D':
					if (card[1][num] != 0) {
						result = "ERROR";
					} else {
						card[1][num] = --need[1];
					}

					break;
				case 'H':
					if (card[2][num] != 0) {
						result = "ERROR";
					} else {
						card[2][num] = --need[2];
					}

					break;
				case 'C':
					if (card[3][num] != 0) {
						result = "ERROR";
					} else {
						card[3][num] = --need[3];
					}

					break;

				}

			}

			// 정상적인경우
			if (result == "")
				System.out.println("#" + t + " " + need[0] + " " + need[1] + " " + need[2] + " " + need[3]);
			// 카드가 중복된 경우
			else
				System.out.println("#" + t + " "+ result);
		}

	}

}

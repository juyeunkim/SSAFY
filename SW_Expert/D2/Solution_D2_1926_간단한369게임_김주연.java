import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		String result = "";
		for(int i=1; i<=N; i++) {
    
			String num = Integer.toString(i);
			if(num.contains("3") || num.contains("6") || num.contains("9")) { // num에 3,6,9가 포함되어있으면 -> 개수만큼 "-" 추가
				result += " ";
				for(int j=0; j<num.length(); j++) {
					if(num.charAt(j) =='3' || num.charAt(j) =='6' || num.charAt(j) =='9')
						result += "-";
				}
			}
			else {
      // 3,6,9가 포함되어있지않다면 숫자 num추가
				result += " "+num;
			}
		}
    // 앞에 공백제거
		result = result.substring(1);
		System.out.println(result);

	}

}

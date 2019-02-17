
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1284 {

	// 집의 위치가 두 수도 회사 A, B 중간에 위치하기에 원하는 수도 회사를 선택할 수 있게 되었는데, 두 회사 중 더 적게 수도 요금을
	// 부담해도 되는 회사를 고르려고 한다.
	// 종민이가 알아본 결과 두 회사의 수도 요금은 한 달 동안 사용한 수도의 양에 따라 다음과 같이 정해진다.
	// A사 : 1리터당 P원의 돈을 내야 한다.
	// B사 : 기본 요금이 Q원이고, 월간 사용량이 R리터 이하인 경우 요금은 기본 요금만 청구된다. 하지만 R 리터보다 많은 양을 사용한 경우
	// 초과량에 대해 1리터당 S원의 요금을 더 내야 한다.
	// 집에서 한 달간 사용하는 수도의 양이 W리터
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "9 100 20 3 10\r\n" + "8 300 100 10 250";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int P, Q, R, S, W;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			int calA=W*P;
			int calB=Q;
			if(W>=R) {
				calB+=(W-R)*S;
			}
			int ans=Math.min(calA, calB);
			System.out.println("#" + tc + " "+ans);
		}
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3431 {
	// public class Solution {

	// 1주일에 L분 이상 U분 이하의 운동
	// 이번 주에 X분만큼 운동
	// 준환이가 제한되어 있는 시간을 넘은 운동을 한 것인지, 그것이 아니라면 몇 분 더 운동을 해야 제한을 맞출 수 있는지 출력하는 프로그램
	// I가 필요한 양보다 더 많은 운동을 하고 있다면 -1을 출력하고, 아니라면 추가로 몇 분을 더 운동해야 하는지
//세 정수 L, U, X
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "300 400 240\r\n" + "300 400 350\r\n" + "300 400 480";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int L, U, X;
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			L=Integer.parseInt(st.nextToken());
			U=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			
			int ans=-1;
			
			if(X<=U) {
				if(X<L) {
					ans=L-X;
				}else {
					ans=0;
				}
			}
			
			
			System.out.println("#" + tc + " "+ans);
		}
	}
}

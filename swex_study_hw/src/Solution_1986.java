
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1986 {

	// 1부터 n까지 짝수는 빼고 홀수는 더했을때 최종 누적값
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "5\r\n" + "6";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;

			for(int i=1;i<=N;i++) {
				if(i%2==1) {
					ans+=i;
				}else {
					ans-=i;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}

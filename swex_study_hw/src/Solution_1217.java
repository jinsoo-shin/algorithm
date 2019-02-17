
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1217 {

	// 다음과 같이 두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.
//2 5 = 2 X 2 X 2 X 2 X 2 = 32
//3 6 = 3 X 3 X 3 X 3 X 3 X 3 = 729
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "9 8\r\n" + "2\r\n" + "2 8";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans=nPowM(N,M);
			System.out.println("#" + tc + " "+ans);
		}
	}

	static int nPowM(int n, int m) {
		if (m == 1) {
			return n;
		}
		int tmp=nPowM(n,m/2);
		if(m%2==0) {
			return tmp*tmp;
		}else {
			return tmp*tmp*n;
		}
	}
}

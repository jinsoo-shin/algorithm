import java.io.*;
import java.util.*;

public class Solution_3752 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "3\r\n" + "2 3 5\r\n" + "10\r\n" + "1 1 1 1 1 1 1 1 1 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 문제수
			ans = 0;
			int[] test = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				test[i] = Integer.parseInt(st.nextToken());
			}
//			result = new HashSet<>();
			res = new int[10001];
			powerSet(new boolean[N], test, 0);

			for (int a : res) {
				if (a != 0) {
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;
	static int[] res;
//	static Set<Integer> result;

	static void powerSet(boolean[] flag, int[] test, int idx) {
		if (idx == test.length) {
//			System.out.println(Arrays.toString(flag));
			int sum = 0;
			for (int i = 0; i < test.length; i++) {
				if (flag[i]) {
					sum += test[i];
				}
			}
			res[sum]++;
			return;
		}

		flag[idx] = true;
		powerSet(flag, test, idx + 1);
		flag[idx] = false;
		powerSet(flag, test, idx + 1);

	}
}

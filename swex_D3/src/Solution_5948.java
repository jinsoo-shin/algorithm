import java.io.*;
import java.util.*;

public class Solution_5948 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "1 2 3 4 5 6 7\r\n" + "5 24 99 76 1 77 6";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = new TreeSet<>();
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[7];
			for (int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			per(arr, 0, 0, new boolean[7]);
			Object[] tmp = ans.toArray();
//			System.out.println(Arrays.toString(tmp));
			System.out.println("#" + tc + " " + tmp[tmp.length - 5]);
		}
	}

	static Set<Integer> ans;

	static void per(int[] arr, int idx, int cnt, boolean[] flag) {
		if (idx == arr.length) {
			if (cnt == 3) {
//				System.out.println(cnt + " " + Arrays.toString(flag));
				int tmpMax = findMax(flag, arr);
				ans.add(tmpMax);
			}
			return;
		}
		flag[idx] = true;
		per(arr, idx + 1, cnt + 1, flag);
		flag[idx] = false;
		per(arr, idx + 1, cnt, flag);

	}

	static int findMax(boolean[] flag, int[] arr) {
		int sum = 0;

		for (int i = 0; i < 7; i++) {
			if (flag[i]) {
				sum += arr[i];
			}
		}

		return sum;
	}
}

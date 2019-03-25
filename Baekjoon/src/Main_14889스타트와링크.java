import java.io.*;
import java.util.*;

public class Main_14889스타트와링크 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "6\r\n" + "0 1 2 3 4 5\r\n" + "1 0 2 3 4 5\r\n" + "1 2 0 3 4 5\r\n" + "1 2 3 0 4 5\r\n"
//				+ "1 2 3 4 0 5\r\n" + "1 2 3 4 5 0";
//		String src = "4\r\n" + "0 1 2 3\r\n" + "4 0 5 6\r\n" + "7 1 0 2\r\n" + "3 4 5 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(arr[i]));
		}
		ans = Integer.MAX_VALUE;
		set = new HashSet<>();
		per(0, 0, new boolean[N]);
		System.out.println(ans);
	}

	static int N, ans;
	static int[][] arr;
	static Set<String> set;
	static String tmp1, tmp2;

	static void per(int idx, int cnt, boolean[] flag) {
		if (cnt == N / 2) {
			int[] tmpArr1 = new int[N / 2];
			int[] tmpArr2 = new int[N / 2];
			int idx1 = 0;
			int idx2 = 0;
			for (int i = 0; i < N; i++) {
				if (flag[i]) {
					tmpArr1[idx1++] = i;
				} else {
					tmpArr2[idx2++] = i;
				}
			}
			tmp1 = tmpArr1.toString();
			tmp2 = tmpArr2.toString();
			if (set.contains(tmp1) || set.contains(tmp2)) {
				return;
			} else {
				set.add(tmp1);
				set.add(tmp2);
				cal(tmpArr1, tmpArr2);

			}

//				System.out.println("----");
//				System.out.println(Arrays.toString(tmpArr1) + Arrays.toString(tmpArr2));
			return;
		}
		if (idx == N) {
			return;
		}
		flag[idx] = true;
		per(idx + 1, cnt + 1, flag);
		flag[idx] = false;
		per(idx + 1, cnt, flag);
	}

	static void cal(int[] tmpArr1, int[] tmpArr2) {
		int tmpA = 0;
		int tmpB = 0;
		for (int i = 0; i < tmpArr1.length - 1; i++) {
			for (int j = i + 1; j < tmpArr1.length; j++) {
				tmpA += arr[tmpArr1[i]][tmpArr1[j]];
				tmpA += arr[tmpArr1[j]][tmpArr1[i]];
				tmpB += arr[tmpArr2[i]][tmpArr2[j]];
				tmpB += arr[tmpArr2[j]][tmpArr2[i]];
			}
		}
		ans = Math.min(ans, Math.abs(tmpA - tmpB));
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2005파스칼 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;

			int[] arr = { 0, 1, 0 };
			System.out.println("#" + tc);
			for (int i = 1; i <= N; i++) {// 늘어나는 배열의 크기
				int tmp[] = new int[3 + i];
				tmp[0] = 0;
				tmp[tmp.length - 2] = 0;
				int idx = 1;
				for (int j = 0; j < i; j++) {
					int tmpN = arr[j] + arr[j + 1];
					tmp[idx++] = tmpN;
				}
				arr = tmp;
				print(arr);
//				System.out.println(Arrays.toString(arr));

			}

		}
	}

	static void print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			if (i != 0) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());

	}
}

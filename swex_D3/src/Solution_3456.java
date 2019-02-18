import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3456 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "1 1 2\r\n" + "4 3 4\r\n" + "5 5 5";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 3; i++) {
				if (arr[i % 3] == arr[(i + 1) % 3]) {
					arr[i % 3] = 0;
					arr[(i + 1) % 3] = 0;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (arr[i] != 0) {
					ans = arr[i];
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}

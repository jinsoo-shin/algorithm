import java.io.*;
import java.util.*;

public class Solution_3752 {
//	public class Solution {
	static boolean[] arr;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "3\r\n" + "2 3 5\r\n" + "10\r\n" + "1 1 1 1 1 1 1 1 1 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 문제수
			String[] str = br.readLine().split(" ");
			arr = new boolean[10001];
			List<Integer> list = new ArrayList<>();
			list.add(0);
			int ans = 1;
			for (int i = 0; i < N; i++) {
				int score = Integer.parseInt(str[i]);
				int size = list.size();
				for (int j = 0; j < size; j++) {
					int tmp = list.get(j) + score;
					if (!arr[tmp]) {
						list.add(tmp);
						arr[tmp] = true;
						ans++;
					}
				}

			}
//			System.out.println(list);
			System.out.println("#" + tc + " " + ans);
		}
	}

}

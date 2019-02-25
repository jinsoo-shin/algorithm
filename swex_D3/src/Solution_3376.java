import java.io.*;
import java.util.*;

public class Solution_3376 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "100\r\n" + "12";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		// Pn= 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
		// 규칙: p0+p1= p3
		// p9=p7+p6 9= 5+4
		List<Long> list = new ArrayList<>();
		list.add((long) 1);
		list.add((long) 1);
		list.add((long) 1);
//		long[] arr = new long[101];
//		arr[0] = 1;
//		arr[1] = 1;
//		arr[2] = 1;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long ans = 0;
			int N = Integer.parseInt(br.readLine());
//			for (int i = 3; i < arr.length; i++) {
//				arr[i] = arr[i - 2] + arr[i - 3];
//			}
			if (list.size() == 3) {
				for (int i = 3; i < N; i++) {
					list.add(list.get(i - 2) + list.get(i - 3));
				}
				ans = list.get(list.size() - 1);
//				System.out.println(list);
			} else if (N > list.size()) {
				int size = list.size();
				for (int i = size; i < N; i++) {
					list.add(list.get(i - 2) + list.get(i - 3));
				}
				ans = list.get(list.size() - 1);
//				System.out.println(list);
			} else {
				ans = list.get(N-1);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}

import java.io.*;
import java.util.*;

public class Solution_4796우뚝선산 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
//		String src = "1\r\n" + "3\r\n" + "1 3 2";
//		String src = "1\r\n" + "3\r\n" + "3 2 1";
//		String src = "1\r\n" + "10\r\n" + "1 4 6 5 3 7 9 2 8 2";
//		String src = "1\r\n" + "9\r\n" + "1 4 6 5 3 7 9 2 8";
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.println(Arrays.toString(arr));
			List<Node> list = new ArrayList<>();
			int start = -1;
			int end = -1;
			int top = -1;
			boolean flag = false;// 참이면 오르막길중
			for (int i = 1; i < N; i++) {
				if (arr[i - 1] < arr[i]) {// 오르막길

					if (!flag) {
						if (start != -1 && end != -1 && top != -1) {
							list.add(new Node(start, end, top));
							start = -1;
							end = -1;
							top = -1;
						}
//						System.out.println("오르막길 시작" + (i - 1));
						start = i - 1;
					}
					flag = true;
				}
				if (arr[i - 1] > arr[i]) {// 내리막길
					if (flag) {
//						System.out.println("내리막길 시작 정상" + (i - 1));
						top = i - 1;
						flag = false;
					}
					end = i;
				}

			}
			if (start != -1 && end != -1 && top != -1) {
				list.add(new Node(start, end, top));
			}
			ans = 0;
			for (int i = 0; i < list.size(); i++) {
				int a = list.get(i).start;
				int b = list.get(i).top;
				int c = list.get(i).end;
				ans += (b - a) * (c - b);
			}

			System.out.println(list);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static class Node {
		int start;
		int end;
		int top;

		@Override
		public String toString() {
			return "Node [start=" + start + ", top=" + top + ", end=" + end + "]\n";
		}

		public Node(int start, int end, int top) {
			super();
			this.start = start;
			this.end = end;
			this.top = top;
		}

	}

	static int ans;
}

import java.io.*;
import java.util.*;

public class Main_17071숨바꼭질5 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "5 17";
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int x = sc.nextInt();
		int y = sc.nextInt();
		boolean[] visit = new boolean[500001];
		int dx[] = { -1, 1 };
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 1));
		visit[x] = true;
		int ans = -1;
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			System.out.println(tmp);
			if (tmp.x == tmp.y) {
				ans = tmp.cnt - 1;
				break;
			}
			for (int i = 2; i >= 0; i--) {
				int cx = 0;
				if (i == 2) {
					cx = tmp.x * 2;
				} else {
					cx = tmp.x + dx[i];
				}
				int cy = tmp.y + tmp.cnt;

				if (cx >= 500001 || cy >= 500001 || cx < 0 || cy < 0) {
					continue;
				}
//				if (visit[cx]) {
//					continue;
//				}
				visit[cx] = true;
				q.offer(new Node(cx, cy, tmp.cnt + 1));

			}
		}
		System.out.println(ans);
	}

	static class Node {
		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}

}
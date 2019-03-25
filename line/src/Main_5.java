import java.io.*;
import java.util.*;

public class Main_5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("11 2"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());// 코니
		int b = Integer.parseInt(st.nextToken());// 브라운
		int dx[] = { 1, -1 };
		int min = Integer.MAX_VALUE;
		boolean[] visit = new boolean[200001];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(c, b, 0));// 시작 카운트
		visit[c] = true;
		while (!q.isEmpty()) {
			Node tmp = q.poll();

			tmp.c += tmp.time;// 이동한 코니
//			System.out.println(tmp);
			if (tmp.c == tmp.b) {
				min = Math.min(min, tmp.time);
				break;
			}
			if (tmp.b >= 200000) {
				continue;
			}
			if (tmp.c >= 200000) {
				break;
			}
			if (tmp.b / tmp.c > 10) {
				break;
			}
			for (int i = 0; i < 3; i++) {// 브라운 움직임
				int bx;
				if (i == 2) {
					bx = tmp.b * 2;
				} else {
					bx = tmp.b + dx[i];
				}
				if (bx < 0 || bx >= visit.length) {
					continue;
				}
				if (visit[bx]) {
					continue;
				}
				q.offer(new Node(tmp.c, bx, tmp.time + 1));
				visit[bx] = true;
			}

		}

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	static class Node {
		int c;
		int b;
		int time;

		@Override
		public String toString() {
			return "Node [c=" + c + ", b=" + b + ", time=" + time + "]";
		}

		public Node(int c, int b, int time) {
			super();
			this.c = c;
			this.b = b;
			this.time = time;
		}

	}

}
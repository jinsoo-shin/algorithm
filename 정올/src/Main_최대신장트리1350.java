import java.io.*;
import java.util.*;

public class Main_최대신장트리1350 {
//	public class Main {
	// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=625&sca=50&sfl=wr_hit&stx=1350&sop=and
	public static void main(String[] args) throws Exception {
		String src = "5 8 \r\n" + "1 2 3 \r\n" + "1 3 7 \r\n" + "2 3 10 \r\n" + "2 4 4 \r\n" + "2 5 8 \r\n"
				+ "3 4 6 \r\n" + "3 5 2 \r\n" + "4 5 17";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		N = sc.nextInt();
		M = sc.nextInt();
//		map = new int[N][N];
		ans = 0;
		list = new PriorityQueue[N];
		for (int i = 0; i < N; i++) {
			list[i] = new PriorityQueue<Node>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();// 가중치
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		for (int i = 0; i < N; i++) {
			System.out.println(list[i]);
		}
		Queue<Node> q = new LinkedList<>();
		q.add((Node) list[0].poll());
		System.out.println(q);
	}

	static class Node implements Comparable<Node> {
		int next;
		int cost;

		@Override
		public String toString() {
			return "Node [next=" + next + ", cost=" + cost + "]";
		}

		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}

	}

	static PriorityQueue[] list;
	static int N, M, ans;
//	static int[][] map;
}
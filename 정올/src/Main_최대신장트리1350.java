import java.io.*;
import java.util.*;

public class Main_최대신장트리1350 {
//	public class Main {
	// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=625&sca=50&sfl=wr_hit&stx=1350&sop=and
	public static void main(String[] args) throws Exception {
		String src = "10 20\r\n" + "1 9 34\r\n" + "1 8 94\r\n" + "2 7 80\r\n" + "9 10 67\r\n" + "7 6 98\r\n" + "8 4 61\r\n" + "7 9 24\r\n"
				+ "9 7 20\r\n" + "10 1 59\r\n" + "2 5 58\r\n" + "7 5 66\r\n" + "10 7 35\r\n" + "3 9 92\r\n" + "5 7 13\r\n" + "3 5 68\r\n"
				+ "10 4 51\r\n" + "1 3 70\r\n" + "6 1 56\r\n" + "8 1 18\r\n" + "8 2 84";
//		String src = "5 8 \r\n" + "1 2 3 \r\n" + "1 3 7 \r\n" + "2 3 10 \r\n" + "2 4 4 \r\n" + "2 5 8 \r\n" + "3 4 6 \r\n" + "3 5 2 \r\n" + "4 5 17";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		N = sc.nextInt();
		M = sc.nextInt();
//		map = new int[N][N];
		ans = 0;
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int firstMax = 0;
		int firstIdx = 0;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();// 가중치
			pq.add(new Node(a, b, c));
			pq.add(new Node(b, a, c));
		}

		boolean[] visit = new boolean[N];

		while (!pq.isEmpty()) {
			if (check()) {
				break;
			}
			Node tmp = pq.poll();
			if (findSet(tmp.a) == findSet(tmp.b)) {
				continue;
			}
			Union(tmp.a, tmp.b);
			ans += tmp.cost;
		}
		System.out.println(ans);
	}

	static boolean check() {
		int cnt = 0;
		for (int i = 0; i < parents.length; i++) {
			if (parents[i] == i) {
				cnt++;
			}
		}
		if (cnt == 1) {
			return true;
		} else {
			return false;
		}
	}

	static class Node implements Comparable<Node> {
		int a;
		int b;
		int cost;

		public Node(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}

	}

	static int N, M, ans;
	static int[] parents;

	static int findSet(int x) {// 부모 노드 찾기
		if (parents[x] == x) {
			return x;// 자기자신과 같으면 자기 반환
		} else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}

	}

	// 부모노드를 합치는 함수
	static void Union(int x, int y) {
		int a = findSet(x);
		int b = findSet(y);// 각각 부모찾기
		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}

}
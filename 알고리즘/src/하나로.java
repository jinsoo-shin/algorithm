import java.io.*;
import java.util.*;

public class 하나로 {

//
//Disjoint-Set 서로소 집합
//Union-Find 유니온 파인드 => 합집합 찾기
//
//두개의 노드를 선택해서 해당 노드가 서로 연결되어있는지 여부를 파악하기 위한 알고리즘

	public static void main(String[] args) throws IOException {
		String src = "1\r\n" + "6\r\n" + 
				"0 0 400 400 1000 2000\r\n" + 
				"0 100 0 100 600 2000\r\n" + 
				"0.3";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 섬의 수!

			Queue<Node> pq = new PriorityQueue<>();
			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			int[][] xy = new int[N][2];// 섬의 좌표를 받아온다!!!!!
			for (int i = 0; i < N; i++) {
				xy[i][0] = Integer.parseInt(stX.nextToken());
				xy[i][1] = Integer.parseInt(stY.nextToken());
				// 섬의 좌표값을 받아오고...
			}
			double E = Double.parseDouble(br.readLine());
			parents = new int[N];
			for (int i = 0; i < N; i++) {
				makeSet(i);// 초기화 하기
			}
//			System.out.println("부모 " + Arrays.toString(parents));

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double dist = Math.pow(xy[i][0] - xy[j][0], 2) + Math.pow(xy[i][1] - xy[j][1], 2);
					pq.offer(new Node(i, j, dist));
				}
			}

//				while (!pq.isEmpty()) {
//					System.out.println(pq.poll());
//				}g

			boolean[] visit = new boolean[N];
			// 하나를 먼저 넣어놓는다.

			double ans = 0;
			while (!pq.isEmpty()) {
				if (check()) {
					break;
				}
				Node tmp = pq.poll();
//				System.out.println(tmp.toString());
				if (findSet(tmp.a) == findSet(tmp.b)) {// 부모가 같으면 갈 필요가 없다
					continue;
				}
//				System.out.println(tmp.a + " " + tmp.b);
				Union(tmp.a, tmp.b);
				ans += tmp.dist;
			}
//			System.out.println("부모 " + Arrays.toString(parents));
			System.out.println("#"+tc+" "+(long) Math.round(ans * E));
		}
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

	static int[] parents;
	static int[] rank;

	static void makeSet(int x) { // 자기자신 집합 만들기
		parents[x] = x;
	}

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

	static class Node implements Comparable<Node> {
		int a;
		int b;
		double dist;

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", dist=" + dist + "]";
		}

		public Node(int a, int b, double dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist < o.dist ? -1 : 1;
		}

	}
}

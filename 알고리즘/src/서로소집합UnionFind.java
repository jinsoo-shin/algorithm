import java.io.*;
import java.util.*;

public class 서로소집합UnionFind {

//d
//Disjoint-Set 서로소 집합
//Union-Find 유니온 파인드 => 합집합 찾기
//
//두개의 노드를 선택해서 해당 노드가 서로 연결되어있는지 여부를 파악하기 위한 알고리즘

	public static void main(String[] args) throws IOException {
		String src = "10 8\r\n" + "1 2\r\n" + "2 3\r\n" + "3 4\r\n" + "4 5\r\n" + "6 7\r\n" + "8 7\r\n" + "1 9\r\n"
				+ "1 10";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());// 점 수
		int E = Integer.parseInt(st.nextToken());// 간선 수
		int[][] edges = new int[E][2];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			edges[i][0] = a;
			edges[i][1] = b;

		}
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			makeSet(i);// 초기화 하기
		}
//		System.out.println("부모 " + Arrays.toString(parents));

		for (int i = 0; i < E; i++) {
			Union(edges[i][0], edges[i][1]);
//			System.out.println("부모 " + Arrays.toString(parents));
		}
//		Set<Integer> set = new HashSet<>();
		int ans = 0;
		for (int i = 0; i < V; i++) {
			if (parents[i] == i) {
				ans++;
			}
		}
		System.out.println(ans);
//		for (int i = 0; i < V; i++) {
//			set.add(parents[i]);
//		}
//		System.out.println("사이즈 =" + set.size());
//		System.out.println(set.size());
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

//	
//	static void makeSet(int x) { // 자기자신 집합 만들기
//		parents[x] = x;
//	}
//
//	static int findSet(int x) {
//		if (x == parents[x]) {
//			return x;
//		} else {
//			parents[x] = findSet(parents[x]);
//			return parents[x];
//		}
//	}
//
//	static void Union(int x, int y) {
//		// x,y 중 대표자를 찾아서
//		// 각 두 대표자중 Rank가 높은애를 대표자로
//		// Rank가 같은경우 대표자가 되는애를 rank++;
//		int px = findSet(x);
//		int py = findSet(y);// 부모찾고
//
////		if (px != py) {
////			parents[py] = px;
////		}
//		if (rank[px] > rank[py]) {
//			parents[py] = px;
//		} else {
//			parents[px] = py;
//			if (rank[px] == rank[py]) {
//				rank[py]++;
//			}
//		}
//
//	}
}

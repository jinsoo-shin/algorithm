import java.io.*;
import java.util.*;

public class Main_1863종교 {

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
//		int[][] edges = new int[E][2];
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			makeSet(i);// 초기화 하기
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
//			edges[i][0] = a;
//			edges[i][1] = b;

		}

//		for (int i = 0; i < E; i++) {
//			union(edges[i][0], edges[i][1]);
//		}
		int ans = 0;
		for (int i = 0; i < V; i++) {
			if (parents[i] == i) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static int[] parents;

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
	static void union(int x, int y) {
		int a = findSet(x);
		int b = findSet(y);// 각각 부모찾기
		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}
}

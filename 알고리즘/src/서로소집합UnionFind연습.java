import java.io.*;
import java.util.*;

public class 서로소집합UnionFind연습 {

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
		int ans = 0;
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			makeSet(i);
		} // 미리 초기화를 하자
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
//			edges[i][0] = a;
//			edges[i][1] = b;
			// 따로 간선 저장안하고 바로바로 저장하자
			Union(a, b);

		} // 간선들을 받아온다.

		System.out.println(Arrays.toString(parents));
		for (int i = 0; i < V; i++) {
			if (parents[i] == i) {// 자기자신이 부모다..
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
		if (parents[x] == x) {// 자기자신이 부모래
			return x;
		} else {// 위에 부모가 있다면.... 연결연결... 1- 2- 3이라면.. 3일때 2를 다시 부모노드로...?
			x = findSet(parents[x]);//
			return x;
		}
	}

	// 부모노드를 합치는 함수
	static void Union(int x, int y) {
		// 두 애의 부모를 찾자
		int cx = findSet(x);
		int cy = findSet(y);// 부모 찾았고...

		if (cx > cy) {
			parents[cy] = cx;// cy의 부모를 cx로 둔다.
		} else {
			parents[cx] = cy;// cx의 부모를 cy로 둔다.
		}

	}

}

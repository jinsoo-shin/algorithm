import java.io.*;
import java.util.*;

import javax.annotation.processing.Completion;

public class 다익스트라그래프_우선순위큐 {

	public static void main(String[] args) throws IOException {
//		꼭짓점 간의 최단 경로를 찾는 알고리즘

//		다음 알고리즘에서, 코드 u ← vertex in Q with min dist[u]는 꼭짓점 집합 Q에서 가장 작은 dist[u] 값을 가지는 꼭짓점 u를 찾는다. 
//		length(u, v)는 두 인접한 꼭짓점인 u와 v를 연결하는 변의 길이 (둘 간의 거리)를 반환한다.
//		18번째 줄의 변수 alt는 루트 꼭짓점에서 u를 통해서 인접 꼭짓점 v까지 가는 경로의 길이이다. 
//		이 경로가 현재 v에 대해서 기록된 최단 경로보다 짧다면, 현재 경로를 이 alt 경로로 대체한다. 
//		prev 배열은 소스까지 최단 경로를 찾기 위한 소스 그래프의 "다음" 꼭짓점을 나타내는 배열이다.

		String src = "6 11\r\n" + "0 1 3\r\n" + "0 2 5\r\n" + "1 2 2\r\n" + "1 3 6\r\n" + "2 1 1\r\n" + "2 4 6\r\n"
				+ "2 3 4\r\n" + "3 4 2\r\n" + "3 5 3\r\n" + "4 0 3\r\n" + "4 5 6";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());// 정점
		int E = Integer.parseInt(st.nextToken());// 간선

		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj[a][b] = c;
		}

		for (int[] row : adj) {
			System.out.println(Arrays.toString(row));
		}
		/////////////////////////////////////////////
		PriorityQueue<Node> q = new PriorityQueue<>();
//		int[] dist = new int[V];// 거리를 저장하는 배열
		boolean[] visited = new boolean[V];
		// 0번정점부터 출발하고 0번 정점까지의 거리가 0이고 다른 정점까지 알려진거리는
		// 0번부터 경로가 있는 경우 그 경로비용, 경로가없는 경우 무한대
		int[] distance = new int[V];
		distance[0] = 0;
		for (int i = 1; i < V; i++) {
			distance[i] = 987654321;// 무한대 집어넣기
		}

		System.out.println("1" + Arrays.toString(distance));
		PriorityQueue<Node> heap = new PriorityQueue<>();
		heap.offer(new Node(0, distance[0]));// 시작부분
		while (!heap.isEmpty()) {
			Node p = heap.poll();// 꺼낸다 처음엔 0 0
			if (distance[p.idx] < p.distance)//// 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸것을 무시한다.
				continue;
			for (int i = p.idx; i < V; i++) {//인접노드 전부 검색하기인데 이것도 나중에 Linkedlist로 인접노드 검색 좀 줄일수있을듯...?
				if (adj[p.idx][i] == 0) {// 인접 ㄴㄴ인곳 패스
					continue;
				}
				if (distance[i] > distance[p.idx] + adj[p.idx][i]) {
					distance[i] = distance[p.idx] + adj[p.idx][i];
					heap.offer(new Node(i, distance[i]));
				}
			}
		}
		System.out.println("1" + Arrays.toString(distance));
	}

	static class Node implements Comparable<Node> {
		int idx;
		int distance;

		public Node(int idx, int distance) {
			super();
			this.idx = idx;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Node " + idx + ", " + distance;
		}

		public int compareTo(Node target) {
//			return this.distance - target.distance;//이거 내림차순임;;
			return distance <= target.distance ? -1 : 1;

		}
	}

}

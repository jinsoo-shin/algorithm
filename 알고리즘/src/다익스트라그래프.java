import java.io.*;
import java.util.*;

public class 다익스트라그래프 {

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
		for (int tc = 1; tc <= 1; tc++) {
			int ans = 0;
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

			int[] dist = new int[V];// 거리를 저장하는 배열
			boolean[] visited = new boolean[V];
			// 0번정점부터 출발하고 0번 정점까지의 거리가 0이고 다른 정점까지 알려진거리는
			// 0번부터 경로가 있는 경우 그 경로비용, 경로가없는 경우 무한대
			for (int i = 1; i < V; i++) {
				dist[i] = adj[0][i];
				if (adj[0][i] == 0) {
					dist[i] = 987654321;
				}
			}

			System.out.println("dd" + Arrays.toString(dist));
			visited[0] = true;
			// 하나는 이미 방문했으니, 나머지 정점의 갯수만큼 최단거리 구하기
			for (int i = 1; i < V; i++) {
				int minIdx = 0;
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < V; j++) {
					// 방문 안했고 dist가 젤작은것 찾기
					if (!visited[j] && min > dist[j]) {
						minIdx = j;
						min = dist[j];
					}
				}
				// 고른애 선택으로 바꿀거고
				// 고른애로부터 갈수있는 곳 중에서 dist보다 빠른길이 있ㄷ면 그것 선택
				for (int j = 0; j < V; j++) {
					if (adj[minIdx][j] != 0 && dist[j] > dist[minIdx] + adj[minIdx][j]) {// 길이 있고 방문 ㄴㄴ
						dist[j] = dist[minIdx] + adj[minIdx][j];
					}
				}
				visited[minIdx] = true;
				System.out.println(Arrays.toString(dist));
			}

		}
	}

}

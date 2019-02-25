import java.util.*;
import java.io.*;

public class 깊이우선DFS {

	public static void main(String[] args) {
//		깊이 우선 탐색은 맹목적 탐색방법의 하나로 한 노드를 시작으로 인접한 다른 노드를 재귀적으로 탐색해가고 끝까지 탐색하면 다시 위로 와서 다음을 탐색하여 검색한다. 

		Scanner sc = new Scanner("7 8\r\n" + "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7");
		int V = sc.nextInt();
		int E = sc.nextInt();
		// 무향 그래프!!!!
		// V는 정점 E는 간선

		// 인접 리스트 표현.
		// 정점의 갯수만큼 LinedList를 만들기

		int[][] map = new int[V][V];

		for (int i = 0; i < E; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			map[x][y] = map[y][x] = 1;

		}

		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}

//		dfs(map, new boolean[V], 0, 0);

		// 스택이라 선입후출구조!
		// 때문에 깊이우선으로 밑으로 쭈우욱 찍고 내려감
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[V];
		st.push(0);// 시작 넣고
		while (!st.isEmpty()) {
			int tmp = st.pop();// 시작 위치
			if (!visited[tmp]) {// 방문한적 없다면
				System.out.println(tmp);
				visited[tmp] = true;// 방문하고
				for (int i = 1; i < map.length; i++) {// 남은 점만큼 돌기
					if (!visited[i] && map[tmp][i] == 1) {
						st.push(i);
					}
				}
			}
		}

	}

	static void dfs(int[][] map, boolean[] visited, int cnt, int idx) {
		// 정점, 간선, 정점방문여부, 현재방문 ?번째, 이번에 방문 정점정보
		System.out.println(idx);
		visited[idx] = true;
		if (cnt == map.length)
			return;
		for (int i = 1; i < map.length; i++) {
			if (map[idx][i] == 1 && !visited[i]) {
				dfs(map, visited, cnt++, i);
			}
		}
	}
}

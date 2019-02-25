import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 너비우선BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		Queue<Integer> q = new LinkedList<>();

		boolean[] visited = new boolean[V];

		q.add(0);//시작점
		while (!q.isEmpty()) {
			int tmp = q.poll();//갈수있는 방향 전부 탐색 이게 너비임
			System.out.println(tmp);
			visited[tmp] = true;
			for (int i = 1; i < V; i++) {
				if (map[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}

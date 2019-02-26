import java.io.*;
import java.util.*;

public class Main_3184_양 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "6 6\r\n" + "...#..\r\n" + ".##v#.\r\n" + "#v.#.#\r\n" + "#.o#.#\r\n" + ".###.#\r\n" + "...###";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		// 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대를 의미한다.
		// 영역 안의 양의 수가 늑대의 수보다 많다면 이기게 된다. 그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.
		// 아침이 도달했을 때 살아남은 양과 늑대의 수를 출력
		// 첫 줄에는 두 정수 R과 C가 주어지며(3 ≤ R, C ≤ 250), 각 수는 마당의 행과 열의 수를 의미한다.
		// 다음 R개의 줄은 C개의 글자를 가진다. 이들은 마당의 구조(울타리, 양, 늑대의 위치)를 의미한다.
		// 하나의 줄에 아침까지 살아있는 양과 늑대의 수를 의미하는 두 정수를 출력한다.

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][] visit = new boolean[R][C];
		String[][] map = new String[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().split("");
		} // 입력다 받았다

		sh = 0;
		wf = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visit[i][j]) {// 아직 간적이 없다면..!!!!
					bfs(map, visit, i, j);
//					System.out.println("--------------");
				}
			}
		}
		System.out.println(sh + " " + wf);
	}

	static int sh, wf;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };// 위 아래 왼 오

	static void bfs(String[][] map, boolean[][] visit, int x, int y) {
		int sheep = 0;
		int wolf = 0;
		visit[x][y] = true;// 방문했다고 체크하기

		String m = map[x][y];
		if (m.equals(".")) {
		} else if (m.equals("#")) {
			return;// 걍 종료
		} else if (m.equals("o")) {
			sheep++;
		} else if (m.equals("v")) {
			wolf++;
		}
//		System.out.println("시작이다  " + m + " " + area + " " + sheep + " " + wolf);
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(sheep, wolf, x, y));// 넣고

		// 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대를 의미한다.
		// 영역 안의 양의 수가 늑대의 수보다 많다면 이기게 된다. 그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.
		// 아침이 도달했을 때 살아남은 양과 늑대의 수를 출력
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int cx = tmp.x + dx[i];
				int cy = tmp.y + dy[i];

				if (cx < 0 || cy < 0 || cx >= map.length || cy >= map[0].length) {
					continue;
				} // 범위 ㄴㄴ 다음으로 가자
				if (visit[cx][cy]) {
					continue;// 이미 방문한적이 있다!!!!
				}
				String tmpS = map[cx][cy];
				visit[cx][cy] = true;
				if (tmpS.equals(".")) {
					// 빈필드라
					q.offer(new Node(sheep, wolf, cx, cy));
				} else if (tmpS.equals("#")) {
					// 울타리
					continue;// 갈수없으니깐
				} else if (tmpS.equals("o")) {
					// 양이다
					sheep++;
					q.offer(new Node(sheep, wolf, cx, cy));
				} else if (tmpS.equals("v")) {
					// 늑대다
					wolf++;
					q.offer(new Node(sheep, wolf, cx, cy));
				}

			}

		}

//		System.out.println(sheep + " " + wolf);
		if (sheep > wolf) {
			sh += sheep;
		} else {
			wf += wolf;
		}

		// ans에 추가하기!!!

	}

	static class Node {
		int sheep;
		int wolf;
		int x;
		int y;

		public Node(int sheep, int wolf, int x, int y) {
			super();
			this.sheep = sheep;
			this.wolf = wolf;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [sheep=" + sheep + ", wolf=" + wolf + ", x=" + x + ", y=" + y + "]";
		}

	}
}
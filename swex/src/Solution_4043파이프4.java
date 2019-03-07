import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_4043파이프4 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
//			String[][] map2 = new String[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
//					if (map[i][j] >= 3) {
//						map2[i][j] = "#";
//					} else if (map[i][j] >= 1) {
//						map2[i][j] = "|";
//					} else {
//						map2[i][j] = ".";
//					}
				}
			}
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//
//			for (String[] row : map2) {
//				System.out.println(Arrays.toString(row));
//			}
			ans = Integer.MAX_VALUE;
			////////////////////////////////////////
			boolean[][] visit = new boolean[N][N];
			// dir 위아래0 좌우1
			// 시작은 무조건 1이넹
			visit[N - 1][N - 1] = true;
			if (map[N - 1][N - 1] >= 3) {// 꺾인애라면
				bfs(new Node(N - 2, N - 1, 0, 2, visit));

			} else if (map[N - 1][N - 1] >= 1) {// 일자라면..
				bfs(new Node(N - 1, N - 2, 1, 2, visit));

			}
			// 오른쪽 진행방향 인 아이...

			// 만약 1,2라면 dxy 0 1탐색
			// 만약 아래방향으로 진행중이었다면 좌 우 탐색만 가능함
			// 만약 오른쪽 방향 진행중이었다면 위 아래만 탐색이 가능함..

			////////////////////////////////////////
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int N;
	static int ans;
	static int[][] map;
	static int[][] dxy = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 아래 위 // 왼쪽 오른쪽
	//
	static void bfs(Node node) {
		Queue<Node> q = new LinkedList<>();
		int N = map.length;
		q.offer(node);
		node.visit[node.x][node.y] = true;

		// 0,1에서 시작함.
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (tmp.x == 0 && tmp.y == 0) {
//				System.out.println(tmp.dist + "도착" + tmp);
				ans = Math.min(tmp.dist, ans);
			}
//			System.out.println("방문장소" + map[tmp.x][tmp.y] + "-- " + tmp);
			// tmp의 진행방향 아래쪽0 이었냐 오른쪽 1 이냐
			// 만약 1,2라면
			// 만약 아래방향으로 진행중이었다면 좌 우 탐색만 가능함
			// 만약 오른쪽 방향 진행중이었다면 위 아래만 탐색이 가능함..
			if (tmp.dir == 0) {// 진행방향이 아래쪽이다
				if (map[tmp.x][tmp.y] >= 3) {// 3 4 5 6
					// 좌우만가능!!!
					for (int i = 2; i <= 3; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향 좌우다
							tmp.visit[cx][cy] = true;
							q.offer(new Node(cx, cy, 1, tmp.dist + 1, tmp.visit));
						}
					}
				} else if (map[tmp.x][tmp.y] >= 1) {// 1 2
					// 위 아래로만 가자
					for (int i = 0; i <= 1; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향 위아래다
							tmp.visit[cx][cy] = true;
							q.offer(new Node(cx, cy, 0, tmp.dist + 1, tmp.visit));
						}
					}
				}

			} else if (tmp.dir == 1) {// 진행방향이 오른쪽이다
				if (map[tmp.x][tmp.y] >= 3) {// 3 4 5 6
					// 위 아래로만 가자
					for (int i = 0; i <= 1; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향위 아래다
							tmp.visit[cx][cy] = true;
							q.offer(new Node(cx, cy, 0, tmp.dist + 1, tmp.visit));
						}
					}
				} else if (map[tmp.x][tmp.y] >= 1) {// 1 2
					// 좌우로만 가자
					for (int i = 2; i <= 3; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향 좌우다
							tmp.visit[cx][cy] = true;
							q.offer(new Node(cx, cy, 1, tmp.dist + 1, tmp.visit));
						}

					}
				}

			}

		}

	}

	static class Node {// 현재...?
		int x;
		int y;
		int dir;// tmp의 진행방향 아래쪽이었냐 오른쪽이냐
		int dist;
		boolean[][] visit = new boolean[N][N];

		public Node(int x, int y, int dir, int dist, boolean[][] visit) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.dist = dist;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					this.visit[i][j] = visit[i][j];
				}
			}
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + ", dist= " + dist + "]";
		}

	}
}

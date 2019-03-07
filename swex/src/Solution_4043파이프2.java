import java.io.*;
import java.util.*;

public class Solution_4043파이프2 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
//		String src = "1\r\n" + "5\r\n" + "1 4 3 1 4\r\n" + "0 6 4 0 2\r\n" + "0 0 2 0 2\r\n" + "0 0 6 3 5\r\n"
//				+ "0 0 0 6 1";// 9
//		String src = "1\r\n" + "5\r\n" + "1 2 3 0 0 \r\n" + "0 5 6 4 3 \r\n" + "3 6 5 4 3 \r\n" + "2 4 3 2 5 \r\n"
//				+ "5 2 5 3 6 ";//11
//		String src = "1\r\n" + "10\r\n" + "1 1 1 2 2 1 2 2 2 6 \r\n" + "3 1 1 1 1 1 1 1 2 4 \r\n"
//				+ "6 1 2 2 1 2 2 1 2 6 \r\n" + "6 1 2 1 2 1 2 1 1 4 \r\n" + "4 1 1 2 1 1 2 1 1 5 \r\n"
//				+ "3 1 2 2 1 1 1 1 1 6 \r\n" + "4 2 1 2 2 2 2 2 2 4 \r\n" + "3 2 1 2 1 2 2 2 1 6 \r\n"
//				+ "1 0 0 5 3 3 0 1 0 2 \r\n" + "3 2 2 2 1 1 1 1 1 1";// 91
//		String src = "1\r\n" + "10\r\n" + "1 4 4 2 2 3 6 1 4 1 \r\n" + "0 2 5 4 4 6 3 3 5 3 \r\n"
//				+ "5 6 3 6 4 1 3 3 4 2 \r\n" + "1 2 1 4 2 1 5 6 6 0 \r\n" + "3 2 5 6 4 0 6 1 4 6 \r\n"
//				+ "0 3 2 0 6 3 5 3 0 2 \r\n" + "0 1 0 0 0 6 3 0 5 2 \r\n" + "0 4 5 2 3 1 2 2 2 4 \r\n"
//				+ "0 2 5 0 2 6 1 6 3 3 \r\n" + "0 0 4 0 5 6 0 5 4 6";// 33
		String src = "1\r\n" + "15\r\n" + "1 3 6 2 2 6 6 0 1 0 0 3 0 5 0 \r\n" + "0 4 4 0 5 4 0 0 0 3 0 3 0 0 3 \r\n"
				+ "6 0 0 2 2 2 4 0 0 0 0 0 0 0 0 \r\n" + "0 6 1 3 6 5 0 6 0 2 0 0 0 3 1 \r\n"
				+ "4 6 2 2 0 3 4 0 0 0 4 2 0 0 0 \r\n" + "0 5 0 2 3 6 0 0 2 0 3 6 0 4 0 \r\n"
				+ "0 0 0 1 0 0 4 0 0 1 5 2 0 1 0 \r\n" + "5 1 1 4 5 4 6 3 0 2 0 0 2 4 1 \r\n"
				+ "1 0 0 0 4 0 5 3 0 0 5 1 3 5 4 \r\n" + "1 0 5 3 0 0 5 4 5 5 0 0 0 1 1 \r\n"
				+ "6 5 6 0 0 0 0 2 4 0 6 2 5 2 1 \r\n" + "5 5 0 1 0 0 0 0 0 0 0 5 3 6 2 \r\n"
				+ "1 5 1 4 3 3 4 1 0 6 1 4 6 5 2 \r\n" + "6 3 0 5 3 1 5 3 3 3 4 4 1 4 2 \r\n"
				+ "5 0 6 0 5 5 3 4 4 6 0 1 6 4 6 ";// 65
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			String[][] map2 = new String[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 3) {
						map2[i][j] = "#";
					} else if (map[i][j] >= 1) {
						map2[i][j] = "|";
					} else {
						map2[i][j] = ".";
					}
				}
			}
			for (int[] row : map) {
				System.out.println(Arrays.toString(row));
			}

			for (String[] row : map2) {
				System.out.println(Arrays.toString(row));
			}
			ans = Integer.MAX_VALUE;
			////////////////////////////////////////

			// 시작은 무조건 1이넹
			boolean[][] visit = new boolean[N][N];
			bfs(new Node(0, 1, 1, 2, visit));
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
		node.visit[0][0] = true;
		node.visit[node.x][node.y] = true;
		q.offer(node);

		// 0,1에서 시작함.
		while (!q.isEmpty()) {
			Node tmp = q.poll();
//			if (tmp.x == 0 && tmp.y == 0) {
//				System.out.println(tmp.dist + "도착" + tmp);
//				ans = Math.min(tmp.dist, ans);
//			}
			if (tmp.x == N - 1 && tmp.y == N - 1) {
//				ans = tmp.dist;
				System.out.println(tmp.dist + "도착" + tmp);
				if (tmp.dir == 0) {// 위에서 내려왔다면...
					if (map[tmp.x][tmp.y] >= 3) {// 꺾인애
						System.out.println(tmp.dist + "도착" + tmp);
						ans = Math.min(tmp.dist, ans);
						break;
					} else if (map[tmp.x][tmp.y] >= 1) {// 일자면 ㄴㄴ..

					}
				} else if (tmp.dir == 1) {// 왼쪽에서 왔다면..
					if (map[tmp.x][tmp.y] >= 3) {// 꺾인애
						// ㄴㄴㄴㄴ
					} else if (map[tmp.x][tmp.y] >= 1) {//
						ans = Math.min(tmp.dist, ans);
						break;
					}
				}

			}
			System.out.println("방문장소" + map[tmp.x][tmp.y] + "-- " + tmp);
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

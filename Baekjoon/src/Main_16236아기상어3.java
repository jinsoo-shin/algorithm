import java.io.*;
import java.util.*;

public class Main_16236아기상어3 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "3\r\n" + "0 0 1\r\n" + "0 0 0\r\n" + "0 9 0";
		String src = "6\r\n" + "5 4 3 2 3 4\r\n" + "4 3 2 3 4 5\r\n" + "3 2 9 5 6 6\r\n" + "2 1 2 3 4 5\r\n"
				+ "3 2 1 6 5 4\r\n" + "6 6 6 6 6 6";
//		String src = "3\r\n" + "0 0 0\r\n" + "0 0 0\r\n" + "0 9 0";
//		String src = "4\r\n" + "4 3 2 1\r\n" + "0 0 0 0\r\n" + "0 0 9 0\r\n" + "1 2 3 4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());// 공간의 크기
		int[][] map = new int[N][N];
		xyS = new int[2];
		M = 0;// 물고기 수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if (tmp == 9) {// 상어의 위치
					xyS[0] = i;
					xyS[1] = j;
				} else if (tmp != 0) {
					M++;
				}
			}
		}
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		// 상어 처음크기는 2
		// 1초에 상하좌우 인접한 한칸씩 이동한다
		// 자신의 크기보다 큰물고기가 있는 칸은 지나갈수없어
		// 자신의 크기보다 작은 물고기만 먹을 수 있다.
		// 크기가 같은 물고기는 먹을수없지만 지나갈수는 있음.
		// 먹을수있는 물고기가 공간에 없으면 엄마에게 도움요청함.
		// 먹을수있는 물고기가 1마리면 그물고기를 먹어
		// 1마리이상이면 가장 가까운 거리의 물고기를 먹으러감.
		// 거리는 아기상어가 있는 칸에서 물고기가 있는 칸으로 이동할때 지나야하는 칸의 개수의 최소값.
		// 거리가 가까운물고기가 많으면 가장위에 있는 물고기. 그게 또 여러마리면 가장 왼쪽에 있는 물고기.
		// 물고기를 먹으면 그칸은 빈칸
		// 상어는 자신의 크기와 같은수의 물고기를 먹으면 크기가 +1 된다.
		// 2일때 물고기2마리를 먹으면 크기가 3이된다.
		// 몇초동안 도움요청안하고 물고기를 잡아먹을수있을까..?
		// 0: 빈 칸
		// 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
		// 9: 아기 상어의 위치
		bfs(xyS[0], xyS[1], map, 0, 2, 0);
	}

	static int N, M;
	static int[] xyS;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	// 위 왼쪽 아래 오른

	static void bfs(int x, int y, int[][] map, int eatF, int sizeS, int time) {
		// 만약 뭐 먹었으면 거기서부터 다시 시작하는걸로...??
		System.out.println(
				"---------------------------시작" + x + " " + y + " eatF:" + eatF + " sizeS:" + sizeS + " time:" + time);
		Queue<Shark> s = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];// 먹은거....?
		s.offer(new Shark(x, y, 0));
		visit[xyS[0]][xyS[1]] = true;
//		eatF = 0;
//		sizeS = 2;
//		time = 0;
		go: while (!s.isEmpty()) {// 깊이 우선인것같다.
			Shark tmp = s.poll();
			if (eatF == M) {
//				if (tmp.eat == M) {
				System.out.println(tmp);
				System.out.println("-----------------다먹었어" + sizeS + " " + eatF + " " + time);
				break;
			}
			System.out.println(eatF + " " + map[tmp.x][tmp.y] + " " + tmp);
			for (int i = 0; i < 4; i++) {// 4방향으로 움직인다ㅏㅏ
				int cx = tmp.x + dx[i];
				int cy = tmp.y + dy[i];

				if (cx < 0 || cy < 0 || cx >= N || cy >= N) {
					continue;// 넘어갔어
				}
				if (visit[cx][cy]) {
					// 방문했대
					continue;
				}
				if (map[cx][cy] == 0) {// 빈공간이야
					// 거리가 증가한다.//물고기를 먹는다면 초기화하고 다시 그때부터 진행할것이야.
					s.offer(new Shark(cx, cy, tmp.dist + 1));
					visit[cx][cy] = true;
//					time++;
				} else if (map[cx][cy] != 9) {// 물고기가 있는곳.
					if (map[cx][cy] == sizeS) {// 크기가 같으면 지나갈수있고 먹지는 못해
						s.offer(new Shark(cx, cy, tmp.dist + 1));
						visit[cx][cy] = true;
					} else if (map[cx][cy] < sizeS) {// 물고기보다 크면 먹을 수 있어
						// 먹었따!!!!
						map[cx][cy] = 0;// 먹었따
						eatF++;
						if (eatF == sizeS) {
							sizeS++;
						}
						s.offer(new Shark(cx, cy, 0));
						System.out.println("갸아아악" + (tmp.dist + 1) + " " + cx + " " + cy);
						time += tmp.dist + 1;
//						if (eatF == M) {
////							if (tmp.eat == M) {
//							System.out.println(tmp);
//							System.out.println("-----------------다먹었어" + sizeS + " " + eatF + " " + time);
//							break go;
//						}
						bfs(cx, cy, map, eatF, sizeS, time);
						break go;
					} else {
						continue;// 못지나가
					}
				}

			}
		}

	}

	static class Shark {
		int x, y;// 현재 좌표...
		int dist;// 거리

		public Shark(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", dist=" + dist + "]\n";
		}

	}

}
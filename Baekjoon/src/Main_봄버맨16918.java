import java.io.*;
import java.util.*;

public class Main_봄버맨16918 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "6 7 3\r\n" + ".......\r\n" + "...O...\r\n" + "....O..\r\n" + ".......\r\n" + "OO.....\r\n"
//				+ "OO.....";
//		String src = "6 7 4\r\n" + ".......\r\n" + "...O...\r\n" + "....O..\r\n" + ".......\r\n" + "OO.....\r\n"
//				+ "OO.....";
		String src = "6 7 5\r\n" + ".......\r\n" + "...O...\r\n" + "....O..\r\n" + ".......\r\n" + "OO.....\r\n"
				+ "OO.....";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String[][] map = new String[R][C];
		Queue<Bomb> bomb = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				if (tmp[j].equals("O")) {
					bomb.offer(new Bomb(i, j, 0));
				}
				map[i][j] = tmp[j];

			}
		}
		System.out.println(bomb);
		for (String[] row : map) {
			System.out.println(Arrays.toString(row));
		}

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		for (int time = 2; time <= N; time++) {// 시간...
//			System.out.println(bomb);
			System.out.println("시간" + time + "초후------------------------");
			if (time % 2 == 0) {// 폭탄을 설치한드아ㅏㅏㅏ
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j].equals(".")) {
							map[i][j] = "X";
							bomb.add(new Bomb(i, j, time));
						}
					}
				}

			}
			while (!bomb.isEmpty()) {
				if (bomb.peek().setTime + 3 != time) {
					break;
				}
				Bomb B = bomb.poll();
//				if (map[B.x][B.y].equals(".")) {
//					continue;// 이미 처리된애면...
//				}
				map[B.x][B.y] = ".";
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {

						for (int k = 0; k < 4; k++) {// 4방향을 돈다....
							int cx = B.x + dx[k];
							int cy = B.y + dy[k];
							if (cx >= R || cy >= C || cx < 0 || cy < 0) {
								continue;
							}
							if (map[cx][cy].equals(".")) {
								continue;// 이미 처리된애면...
							}
//							System.out.println("터진당" + cx + " " + cy);
							map[cx][cy] = ".";// 터졌대.
						}
					}
				}
			}
			for (String[] row : map) {
				System.out.println(Arrays.toString(row));
			}
		}
//		System.out.println(bomb);
		// 빈 칸은 '.'로, 폭탄은 'O'로 주어진다.
		// N초가 흐른 후의 격자판 상태를 구하려고 한다.
//		폭탄이 있는 칸은 3초가 지난 후에 폭발하고, 폭탄이 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸이 되며, 인접한 네 칸도 함께 파괴된다. 
//		즉, 폭탄이 있던 칸이 (i, j)인 경우에 (i+1, j), (i-1, j), (i, j+1), (i, j-1)도 함께 파괴된다. 
//		만약, 폭탄이 폭발했을 때, 인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다. 따라서, 연쇄 반응은 없다.

	}

	static class Bomb {
		int x;
		int y;
		int setTime;

		@Override
		public String toString() {
			return "Bomb [x=" + x + ", y=" + y + ", setTime=" + setTime + "]\n";
		}

		public Bomb(int x, int y, int setTime) {
			super();
			this.x = x;
			this.y = y;
			this.setTime = setTime;
		}

	}
}
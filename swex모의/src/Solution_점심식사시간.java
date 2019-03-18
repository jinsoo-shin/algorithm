import java.io.*;
import java.util.*;

public class Solution_점심식사시간 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "5\r\n" + "0 1 1 0 0\r\n" + "0 0 1 0 3\r\n" + "0 1 0 1 0\r\n" + "0 0 0 0 0\r\n"
				+ "1 0 5 0 0";// 9
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		// 1은 사람
		// 2~10은 계단의 입구, 계단의 길이
		// 이동시간은 (사람x-계단x)+(사람y-계단y) + 계단 내려가는 시간 1분당 한칸
		// 동시에 3명까지 올라갈수있다. 다른사람이 내려갈때까지 대기해야함.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
//			q = new LinkedList<>();
			map = new int[N][N];
			people = new ArrayList<>();
			int idx = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
					if (tmp == 1) {
						people.add(new People(idx, i, j, Integer.MAX_VALUE, 0));
						idx++;
					}
				}
			}
			idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						boolean[][] visit = new boolean[N][N];
						visit[i][j] = true;
						dfs(new People(idx, i, j, 0, 0), visit);
						idx++;
					}
				}
			}
			System.out.println(people);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(People tmp, boolean[][] visit) {
//		System.out.println(tmp);
		for (int i = 0; i < 4; i++) {
			int cx = tmp.x + dx[i];
			int cy = tmp.y + dy[i];
			if (cx < 0 || cy < 0 || cx >= N || cy >= N) {
				continue;
			}
			if (visit[cx][cy]) {
				continue;
			}
			if (map[cx][cy] < 2) {
				visit[cx][cy] = true;
				dfs(new People(tmp.num, cx, cy, tmp.time + 1, 0), visit);
				visit[cx][cy] = false;
			} else if (map[cx][cy] >= 2) {
				find(tmp.num, cx, cy, tmp.time + 1, map[cx][cy]);
				continue;
			}
		}

	}

	static void find(int num, int x, int y, int time, int h) {
		People tmp = people.get(num);
		if (time < tmp.time) {// 더 짧은게 발견되면
			people.set(num, new People(tmp.num, x, y, time, h));
		}

	}

	static List<People> people;
//	static Queue<People> q;
	static int N, ans;
	static int[][] map;
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };

	static class People {
		int num;
		int x;
		int y;
		int time;// 계단에 도착한 시간
		int stairH;// 계단 높이

		public People(int num, int x, int y, int time, int stairH) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.time = time;
			this.stairH = stairH;
		}

		@Override
		public String toString() {
			return "People [num=" + num + ", x=" + x + ", y=" + y + ", time=" + time + ", stairH=" + stairH + "]\n";
		}

	}
}

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
			map = new int[N][N];
			stair = new LinkedList[2];
			for (int i = 0; i < 2; i++) {
				stair[i] = new LinkedList<>();
			}
			int[][] s = new int[2][2];
			people = new PriorityQueue<>();
			int idx = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
					if (tmp > 1) {
						s[idx][0] = i;
						s[idx][1] = j;
						idx++;
					}
				}
			}
			idx = 0;
			for (int i = 0; i < N; i++) {// 일단 people리스트에
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						boolean[][] visit = new boolean[N][N];
						visit[i][j] = true;
						bfs(new People(idx, i, j, 0, 0), visit);
						idx++;
					}
				}
			}
			while (!people.isEmpty()) {
				People tmp = people.peek();
				for (int i = 0; i < 2; i++) {
					if (s[i][0] == tmp.x && s[i][1] == tmp.y) {
						stair[i].add(people.poll());
					}
				}
			}
			for (int i = 0; i < 2; i++) {
				System.out.println(stair[i]);
				System.out.println("----");
			}
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				list1.add(i);
			}
//			pow(new boolean[stair[0].size()], 0);
			cal(list1, list2);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void cal(List<Integer> list1, List<Integer> list2) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             		Queue<People> q1 = new LinkedList<>();
		while (q1.size() != 3) {
			People tmp = stair[0].poll();
			if (list1.contains(tmp.num)) {
				q1.add(tmp);
			}
		}
		System.out.println(q1);
		int time1 = q1.peek().time;
		while (!q1.isEmpty()) {
			People tmp = q1.poll();
			System.out.println(tmp);
			if (tmp.time < time1) {
				
			} else {
				time1 = time1 + tmp.time + 1;
			}
			System.out.println(time1);
		}
		Queue<People> q2 = new LinkedList<>();

	}

	static void pow(boolean[] flag, int idx) {
		if (idx == flag.length) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < flag.length; i++) {
				if (flag[i]) {
					list1.add(i);
				} else {
					list2.add(i);
				}
			}
			System.out.println(list1);
			System.out.println(list2);
			System.out.println("-----------");
			return;
		}
		flag[idx] = true;
		pow(flag, idx + 1);
		flag[idx] = false;
		pow(flag, idx + 1);
	}

	static void bfs(People p, boolean[][] visit) {// 일단 만
		Queue<People> p1 = new LinkedList<>();
		p1.add(p);
		int findS = 0;
		while (findS < 2) {
			People tmp = p1.poll();
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
					p1.add(new People(tmp.num, cx, cy, tmp.time + 1, 0));
					visit[cx][cy] = false;
				} else if (map[cx][cy] >= 2) {
					visit[cx][cy] = true;
					people.add(new People(tmp.num, cx, cy, tmp.time + 1, map[cx][cy]));
					findS++;
					continue;
				}
			}
		}
	}

	static Queue<People> people;
	static Queue<People>[] stair;// 계단별 사람도착시간
//	static Queue<People> q;
	static int N, ans;
	static int[][] map;
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };

	static class People implements Comparable<People> {
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

		@Override
		public int compareTo(People o) {
			return this.time - o.time;
		}
	}
}

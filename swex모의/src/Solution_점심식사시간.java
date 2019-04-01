import java.io.*;
import java.util.*;

public class Solution_점심식사시간 {
//	public class Solution {
	// 대기했을땐 +1안해도되뮤ㅠㅠㅠㅠ
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "8\r\n" + 
//				"3 0 0 0 0 0 5 0\r\n" + 
//				"0 0 0 0 0 0 0 0\r\n" + 
//				"1 0 0 0 0 0 0 0\r\n" + 
//				"0 0 0 0 0 0 0 0\r\n" + 
//				"1 0 1 1 0 0 0 0\r\n" + 
//				"0 0 0 0 0 0 1 0\r\n" + 
//				"0 0 0 0 0 0 0 0\r\n" + 
//				"0 0 0 0 0 0 0 0";// 9
//		String src = "1\r\n" + "5\r\n" + "0 1 1 0 0\r\n" + "0 0 1 0 3\r\n" + "0 1 0 1 0\r\n" + "0 0 0 0 0\r\n" + "1 0 5 0 0";// 9
//		String src = "1\r\n" + "9\r\n" + "0 0 0 1 0 0 0 0 0\r\n" + "0 1 0 0 0 0	 0 0 0\r\n" + "0 0 0 0 0 0 0 0 8\r\n" + "7 0 0 0 0 1 0 0 0\r\n"
//				+ "0 0 0 0 0 1 1 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "1 0 0 0 0 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0";// 9
//		String src = "1\r\n" + "10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 1 0 0 0 0 0\r\n" + "0 0 1 0 0 0 0 0 0 0\r\n"
//				+ "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "3 0 1 0 1 0 0 0 0 2\r\n" + "1 1 0 0 1 0 1 0 0 0\r\n"
//				+ "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		// 1은 사람
		// 2~10은 계단의 입구, 계단의 길이
		// 이동시간은 (사람x-계단x)+(사람y-계단y) + 계단 내려가는 시간 1분당 한칸
		// 동시에 3명까지 올라갈수있다. 다른사람이 내려갈때까지 대기해야함.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 987654321;
			map = new int[N][N];
			stair = new ArrayList[2];
			for (int i = 0; i < 2; i++) {
				stair[i] = new ArrayList<>();
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
//						boolean[][] visit = new boolean[N][N];
//						visit[i][j] = true;
						int cal1 = Math.abs(i - s[0][0]) + Math.abs(j - s[0][1]);
						int cal2 = Math.abs(i - s[1][0]) + Math.abs(j - s[1][1]);
						stair[0].add(new People(idx, s[0][0], s[0][1], cal1, map[s[0][0]][s[0][1]]));
						stair[1].add(new People(idx, s[1][0], s[1][1], cal2, map[s[1][0]][s[1][1]]));
						idx++;
					}
				}
			}
			for (int i = 0; i < 2; i++) {
				Collections.sort(stair[i]);
//				System.out.println(stair[i]);
//				System.out.println("----");
			}
			pow(new boolean[idx], 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void cal(List<Integer> list1, List<Integer> list2) {
		Queue<People> tmpS1 = new LinkedList<>();// 계단
		Queue<People> tmpS2 = new LinkedList<>();
		for (int i = 0; i < stair[0].size(); i++) {
			tmpS1.add(stair[0].get(i));
		}
		for (int i = 0; i < stair[1].size(); i++) {
			tmpS2.add(stair[1].get(i));
		}
//		System.out.println("계단" + tmpS1 + " " + tmpS2);
//		System.out.println("리스트" + list1 + " " + list2);
		Queue<People> q1 = new LinkedList<>();
//		System.out.println(list1);
		while (q1.size() < 3) {// 계단 꽉차게 넣기
			if (q1.size() == list1.size()) {
				break;
			}
			People tmp = tmpS1.poll();
			if (list1.contains(tmp.num)) {
				tmp.arriveT = tmp.time + 1 + tmp.stairH;
				q1.add(tmp);
			}
		}
//		System.out.println(q1);
		int curTime1 = 0;
		while (!q1.isEmpty()) {
			People tmp = q1.poll();
//			System.out.println(tmp);
			curTime1 = Math.max(curTime1, tmp.arriveT);
			if (curTime1 > ans) {
				return;
			}
			while (!tmpS1.isEmpty()) {
				People next = tmpS1.poll();// 꺼내고..
//				System.out.println("다음" + next);
				if (list1.contains(next.num)) {// 있을떄까지 뽑아내자
					if (tmp.arriveT > next.time) {// 대기타는 경우
						next.arriveT = tmp.arriveT + next.stairH;
					} else {// 바로 갈수있는 경우
						next.arriveT = next.time + next.stairH + 1;
					}
					q1.add(next);
					break;
				}
			}
		}
//		System.out.println("----------------------");
		Queue<People> q2 = new LinkedList<>();
//		System.out.println(list2);
		while (q2.size() < 3) {
			if (q2.size() == list2.size()) {
				break;
			}
			People tmp = tmpS2.poll();
			if (list2.contains(tmp.num)) {
				tmp.arriveT = tmp.time + 1 + tmp.stairH;
				q2.add(tmp);
			}
		}
//		System.out.println(q2);
		int curTime2 = 0;
		while (!q2.isEmpty()) {
			People tmp = q2.poll();
//			System.out.println(tmp);
			curTime2 = Math.max(tmp.arriveT, curTime2);
			if (curTime2 > ans) {
				return;
			}
			while (!tmpS2.isEmpty()) {
				People next = tmpS2.poll();// 꺼내고..
//				System.out.println("다음" + next);
				if (list2.contains(next.num)) {// 있을떄까지 뽑아내자
					if (tmp.arriveT > next.time) {// 대기타는 경우
						next.arriveT = tmp.arriveT + next.stairH;
					} else {// 바로 갈수있는 경우
						next.arriveT = next.time + next.stairH + 1;
					}
//					next.arriveT = tmp.arriveT + 1 + next.stairH;
					q2.add(next);
					break;
				}
			}
		}
//		System.out.println(curTime1 + " " + curTime2);
		ans = Math.min(ans, Math.max(curTime1, curTime2));
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
			cal(list1, list2);
			return;
		}
		flag[idx] = true;
		pow(flag, idx + 1);
		flag[idx] = false;
		pow(flag, idx + 1);
	}

	static Queue<People> people;
	static List<People>[] stair;// 계단별 사람도착시간
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
		int arriveT;

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
			return "People [num=" + num + ", x=" + x + ", y=" + y + ", time=" + time + ", stairH=" + stairH + ", arriveT=" + arriveT + "]\n";
		}

		@Override
		public int compareTo(People o) {
			if (this.arriveT == o.arriveT) {

				return this.time - o.time;
			}
			return this.arriveT - o.arriveT;
		}
	}
}

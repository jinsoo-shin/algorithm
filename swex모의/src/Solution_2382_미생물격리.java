import java.io.*;
import java.util.*;

public class Solution_2382_미생물격리 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "7 2 9\r\n" + "1 1 7 1 \r\n" + "2 1 7 1\r\n" + "5 1 5 4\r\n" + "3 2 8 4 \r\n"
				+ "4 3 14 1\r\n" + "3 4 3 3 \r\n" + "1 5 8 2 \r\n" + "3 5 100 1\r\n" + "5 5 1 1";
//		String src = "1\r\n" + "10 5 28\r\n" + "3 3 796 1\r\n" + "7 2 798 2\r\n" + "2 6 622 1\r\n" + "3 5 179 3\r\n"
//				+ "7 8 888 4\r\n" + "5 8 634 3\r\n" + "1 8 646 1\r\n" + "3 7 433 4\r\n" + "6 7 416 1\r\n"
//				+ "2 7 651 3\r\n" + "6 4 476 2\r\n" + "5 6 712 4\r\n" + "1 7 869 4\r\n" + "6 1 789 2\r\n"
//				+ "8 8 585 3\r\n" + "7 6 426 1\r\n" + "1 5 154 2\r\n" + "1 2 692 1\r\n" + "2 4 549 3\r\n"
//				+ "2 1 60 2\r\n" + "4 8 996 4\r\n" + "8 2 437 2\r\n" + "3 6 195 2\r\n" + "1 3 734 4\r\n"
//				+ "3 8 355 2\r\n" + "1 1 945 1\r\n" + "2 5 558 2\r\n" + "7 7 144 2\r\n" + "10 22 26\r\n"
//				+ "2 2 450 4\r\n" + "6 3 659 1\r\n" + "5 8 24 2\r\n" + "3 7 649 2\r\n" + "3 2 22 3\r\n"
//				+ "1 3 905 4\r\n" + "7 8 625 3\r\n" + "6 7 824 3\r\n" + "7 3 159 1\r\n" + "2 7 297 4\r\n"
//				+ "7 2 270 2\r\n" + "4 5 985 1\r\n" + "7 1 627 2\r\n" + "3 4 625 4\r\n" + "8 5 972 4\r\n"
//				+ "6 6 432 4\r\n" + "6 8 142 1\r\n" + "7 7 900 1\r\n" + "4 1 974 2\r\n" + "4 2 760 4\r\n"
//				+ "1 4 550 2\r\n" + "5 7 624 4\r\n" + "4 6 694 1\r\n" + "4 3 593 3\r\n" + "3 1 152 4\r\n" + "1 8 926 1";
		// 9709.....
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 셀의수
			M = Integer.parseInt(st.nextToken());// 격리 시간
			K = Integer.parseInt(st.nextToken());// 군집의 수

			q = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				q.add(new Sm(row, col, num, dir));
			}
			ans = 0;
			bfs();
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;
	// 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다.
	// 살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값
//이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다. 
	static List<Sm> q;
	static int N, M, K;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static void find(int time) {
		Collections.sort(q);
		if(time==M) {
		System.out.println("-------찾아라--qqq-----------");
		System.out.println(q);
		System.out.println("--------------------");
		}
		// 어으음.... 같은 애를 찾는다.....???
		List<Sm> tmp = new ArrayList<>();
		boolean flag = false;
		List<Sm> numList = new ArrayList<>();
		int idx = 0;
		for (int i = 1; i < q.size(); i++) {
			Sm bef = q.get(i - 1);
			Sm cur = q.get(i);
			if (bef.x == cur.x && bef.y == cur.y) {// 같을때...
				if (tmp.contains(bef)) {// 1 2 같을때...
					tmp.add(cur);
					bef = numList.get(idx);// 이전의 최대인거를 넣어놨다.
					if (bef.num < cur.num) {
						numList.set(idx, new Sm(bef.x, bef.y, cur.num, cur.dir));
					} else {

						numList.set(idx, new Sm(bef.x, bef.y, bef.num, bef.dir));
					}

				} else {// 0 1
					tmp.add(bef);
					tmp.add(cur);
					if (bef.num < cur.num) {
						numList.add(new Sm(bef.x, bef.y, cur.num, cur.dir));
					} else {

						numList.add(new Sm(bef.x, bef.y, bef.num, bef.dir));
					}

				}
			} else {
				idx = numList.size();
				// 다를때
			}

		}
		System.out.println("-------중복인애들-----------");
		System.out.println(tmp);
		System.out.println("--------------------");
		System.out.println("------계산했어------------");
		System.out.println(numList);
		System.out.println("--------------------");

		int[] sum = new int[numList.size()];
		int listIdx = 0;
		for (int i = 0; i < numList.size(); i++) {
			for (int j = 0; j < tmp.size(); j++) {
				if (numList.get(i).x == tmp.get(j).x && numList.get(i).y == tmp.get(j).y) {
					sum[i] += tmp.get(j).num;
				}

			}
		}
		
		
//		System.out.println(Arrays.toString(sum));
		for (int i = 0; i < numList.size(); i++) {
			Sm ssm = numList.get(i);
			numList.set(i, new Sm(ssm.x, ssm.y, sum[i], ssm.dir));
		}
		System.out.println(Arrays.toString(sum));
		for (int i = 0; i < tmp.size(); i++) {
			q.remove(tmp.get(i));
		}
		for (int i = 0; i < numList.size(); i++) {
			q.add(numList.get(i));
		}
		System.out.println("-------최종-----------");
		System.out.println(q);
		System.out.println("--------------------");

		System.out.println("시간시간" + time);
		K = q.size();
		if (time == M) {
			for (int i = 0; i < q.size(); i++) {
				ans += q.get(i).num;
			}
//			System.out.println(q);
		}
	}

	static void bfs() {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			if (i == 0 || i == N - 1) {
				for (int j = 0; j < N; j++)
					map[i][j] = -1;
			} else {
				map[i][0] = -1;
				map[i][N - 1] = -1;
			}

		}

//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		int time = 0;
		int cnt = 0;
		while (true) {
			if (cnt == K) {
				// 여기에 몇개있냐... 2개이상이면 합쳐라
				/////
				cnt = 0;
				time++;
				find(time);
//				System.out.println("미생물수만큼 돌았어");
			}
			if (time == M) {
				// 시간 끝
//				System.out.println("끝!");
				return;
			}

			Sm tmp = q.get(cnt);
//			System.out.println(tmp);
			int cx = tmp.x + dx[tmp.dir];
			int cy = tmp.y + dy[tmp.dir];

			if (map[cx][cy] == -1) {// 빨간약
				tmp.num = tmp.num / 2;// 절반 죽고...
				if (tmp.dir == 0) {
					tmp.dir = 1;
				} else if (tmp.dir == 1) {
					tmp.dir = 0;
				} else if (tmp.dir == 2) {
					tmp.dir = 3;
				} else if (tmp.dir == 3) {
					tmp.dir = 2;
				}
			}
			q.set(cnt, new Sm(cx, cy, tmp.num, tmp.dir));
			cnt++;
		}

	}

	// 상: 0, 하: 1, 좌: 2 , 우: 3
	static class Sm implements Comparable<Sm> {
		int x;// 세로위치
		int y;// 가로위치
		int num;// 미생물 수
		int dir;// 이동 방향

		public Sm(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Sm [x=" + x + ", y=" + y + ", num=" + num + ", dir=" + dir + "]\n";
		}

		@Override
		public int compareTo(Sm o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}

	}
}

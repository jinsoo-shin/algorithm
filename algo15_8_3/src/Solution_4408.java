import java.util.*;
import java.io.*;

public class Solution_4408 {

	public static void main(String[] args) throws Exception {

		String src = "1\r\n" + "4\r\n" + "10 20\r\n" + "30 40\r\n" + "50 60\r\n" + "70 80";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		boolean[] corridor;//
		boolean[] visit;//

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 학생수
			s = new int[N][2];// 학생 정보 배열

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				s[i][0] = (Integer.parseInt(st.nextToken()) + 1) / 2;
				s[i][1] = (Integer.parseInt(st.nextToken()) + 1) / 2;
			} // 인덱스로 변환해서 넣어놓는다.
				//////////// 초기화를 하는칸
			ans = 987654321;
			////////////

			for (int i = 0; i < N; i++) {

				bfs(s[i], new boolean[N], new boolean[200]);
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;
	static int[][] s;

	static void bfs(int[] st, boolean[] visit, boolean[] corridor) {
		Queue<student> q = new LinkedList<>();// 큐돌리기용!!! 학생넣자
		int time = 0;
		while (!q.isEmpty()) {

			if (check(visit)) {
				ans = Math.min(time, ans);
				break;
			}
			student tmp = q.poll();
			if (visit[tmp.num]) {
				continue;// 학생처리했으면
			}
			for (int i = tmp.x; i <= tmp.y; i++) {// 누군가 복도를 쓰고있는가...!!!!
				if (corridor[i]) {
					// 시간 올려주고
					continue;// 바로 넘어가기...
				}

			}
			// 아직 누군가가 그 복도를 안쓴다면
			for (int i = tmp.x; i <= tmp.y; i++) {
				corridor[i] = true;// 학생이 쓰고있어요!
			}
			// 복도 쓰고있다고 해주고
			visit[tmp.num] = true;

			corridor = new boolean[200];// 초기화 해주기
			q.offer(new student(tmp.num + 1, s[tmp.num + 1][0], s[tmp.num + 1][1], time+1));
		}

	}

	static boolean check(boolean[] flag) {
		for (int i = 0; i < flag.length; i++) {
			if (!flag[i]) {
				return false;
			}
		}
		return true;
	}

	static class student {
		int num;
		int x;
		int y;
		int time;

		@Override
		public String toString() {
			return "student [num=" + num + ", x=" + x + ", y=" + y + ", time=" + time + "]";
		}

		public student(int num, int x, int y, int time) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

}

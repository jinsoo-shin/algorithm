import java.util.*;
import java.io.*;

public class Solution_4408_3 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		boolean[] corridor;//
		boolean[] visit;//

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 학생수
			s = new int[N][2];// 학생 정보 배열
			Queue<Student> q = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				int x = (sc.nextInt() - 1) / 2;
				int y = (sc.nextInt() - 1) / 2;
				q.offer(new Student(i, x, y, y - x));
			} // 인덱스로 변환해서 넣어놓는다.
				//////////// 초기화를 하는칸
			ans = 987654321;
			corridor = new boolean[200];
			visit = new boolean[N];
			////////////
			int time = 1;
			while (!q.isEmpty()) {
				Student tmp = q.poll();
//				System.out.println(tmp);
				for (int i = tmp.x; i <= tmp.y; i++) {
					if (corridor[i]) {
						time++;
						corridor = new boolean[200];
						continue;
					}
				}
				for (int i = tmp.x; i <= tmp.y; i++) {
					corridor[i] = true;
				}
			}
//			for (int i = 0; i < N; i++) {
//				bfs(i, new boolean[N], new boolean[200]);
//				System.out.println("----------------------");
//			}
			System.out.println("#" + tc + " " + time);
		}
	}

	static int ans;
	static int[][] s;

	static class Student implements Comparable<Student> {
		int num;
		int x;
		int y;
		int len;

		public Student(int num, int x, int y, int len) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Student [num=" + num + ", x=" + x + ", y=" + y + ", len=" + len + "]\n";
		}

		@Override
		public int compareTo(Student o) {

			return this.len - o.len;
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

}

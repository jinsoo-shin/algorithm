import java.util.*;
import java.io.*;

public class Solution_4408_2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		boolean[] corridor;//
		boolean[] visit;//

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 학생수
			s = new int[N][2];// 학생 정보 배열

			for (int i = 0; i < N; i++) {
				int x = (sc.nextInt() - 1) / 2;
				int y = (sc.nextInt() - 1) / 2;
				s[i][0] = x;
				s[i][1] = y;
			} // 인덱스로 변환해서 넣어놓는다.
				//////////// 초기화를 하는칸
			ans = 987654321;
			////////////

//			for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			corridor = new boolean[200];
			visit[0] = true;
			int a = s[0][0];
			int b = s[0][1];
			int big, small;
			if (a > b) {
				big = a;
				small = b;
			} else {
				big = b;
				small = a;
			}
			for (int j = small; j <= big; j++) {
				corridor[j] = true;
			}
//			System.out.println("범위" + s[0][0] + " : " + s[0][1]);
//				System.out.println("시작------------" + i);
			re(0, visit, corridor, 1);
//				System.out.println("------------------------");
//			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;
	static int[][] s;

	static void re(int idx, boolean[] visit, boolean[] corridor, int time) {
//		System.out.println("------------------------");
//		System.out.println("복도" + Arrays.toString(corridor));
//		int no = 0;
		go: for (int i = idx; i < visit.length; i++) {// 학생 전부 돌기
			if (visit[i]) {// 방문했으면
				continue go;// 다음 학생으로
			}
			int a = s[i][0];
			int b = s[i][1];
			int big, small;
			if (a > b) {
				big = a;
				small = b;
			} else {
				big = b;
				small = a;
			}
//			System.out.println("범위" + small + " : " + big);
			for (int j = small; j <= big; j++) {
				if (corridor[j]) {// 누군가 사용중이다면
					re(i, visit, new boolean[200], time + 1);// 복도 초기화
					return;
//					continue go;
				}
			}
			for (int j = small; j <= big; j++) {
				corridor[j] = true;
			}
			visit[i] = true;
//			System.out.println(time + " !!!!!!!!!!!");
//			System.out.println("학생------------" + i);
			if (check(visit)) {
				ans = Math.min(time, ans);
//				System.out.println("갸악");
				return;
			}
		}
//		re(no, visit, corridor, time + 1);
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

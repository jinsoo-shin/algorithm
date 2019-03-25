import java.io.*;
import java.util.*;

public class Main_5014스타트링크 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "100 2 1 1 0";
//		String src = "10 1 10 2 1";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int F = sc.nextInt();// F층 고층
		int S = sc.nextInt();// 강호 위치
		int G = sc.nextInt();// 도착하고자하는 위치
		int U = sc.nextInt();// 올라가기
		int D = sc.nextInt();// 내려가기 가능숫자
		String ans = "use the stairs";
		boolean[] visit = new boolean[F + 1];

		Stack<int[]> q = new Stack<>();
		q.add(new int[] { S, 0 });
		while (!q.isEmpty()) {
			int[] tmp = q.pop();
			if (tmp[0] == G) {
				ans = "" + tmp[1];
				break;
			}
			for (int i = 0; i < 2; i++) {
				int cx = 0;
				if (i == 0) {
					cx = tmp[0] + U;
				} else {
					cx = tmp[0] - D;
				}
				if (cx < 0 || cx > F) {
					continue;
				}
				if (visit[cx]) {
					continue;
				}
				visit[cx] = true;
				q.add(new int[] { cx, tmp[1] + 1 });
			}
		}

		System.out.println(ans);
	}

}
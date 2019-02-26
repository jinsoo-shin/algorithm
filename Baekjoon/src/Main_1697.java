import java.io.*;
import java.util.*;

public class Main_1697 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "5 17";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 수빈
		int K = Integer.parseInt(st.nextToken());// 동생
		int dx[] = { 1, -1 };

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { N, 0 });// 시작 카운트
		List<Integer> visit = new ArrayList<>();
		visit.add(N);
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
//			System.out.println(tmp[0]);
			for (int i = 0; i < 3; i++) {
				int cx;
				if (i == 2) {
					cx = tmp[0] * 2;
				} else {
					cx = tmp[0] + dx[i];
				}
				if (tmp[1]+1 > min) {
					continue;
				}
				if (visit.contains(cx)) {
					continue;// 가본적이있다!!!!
				}
				if (cx == K) {
					System.out.println(tmp[1]+1);
					min = Math.min(min, tmp[1] + 1);
//					System.out.println("쨔쟈쟌" + min);
					continue;
				}
				q.offer(new int[] { cx, tmp[1] + 1 });
				visit.add(cx);
			}

		}
		System.out.println(min);
	}

}
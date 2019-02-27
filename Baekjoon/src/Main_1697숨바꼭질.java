import java.io.*;
import java.util.*;

 public class Main_1697숨바꼭질 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 수빈
		int K = Integer.parseInt(st.nextToken());// 동생
		int dx[] = { 1, -1 };
		int min = Integer.MAX_VALUE;
		if (N >= K) {

			min = N - K;
		} else {
			boolean[] visit = new boolean[200001];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { N, 0 });// 시작 카운트
//			List<Integer> visit = new ArrayList<>();
			visit[N] = true;
//			visit.add(N);
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int i = 0; i < 3; i++) {
					int cx;
					if (i == 2) {
						cx = tmp[0] * 2;
					} else {
						cx = tmp[0] + dx[i];
					}
					if (cx < 0 || cx >= visit.length) {
						continue;
					}
					if (visit[cx]) {
						continue;
					}
					if (cx == K) {
						min = Math.min(min, tmp[1] + 1);
						continue;
					}
					q.offer(new int[] { cx, tmp[1] + 1 });
//					visit.add(cx);
					visit[cx] = true;
				}

			}
		}
		System.out.println(min);
	}

}
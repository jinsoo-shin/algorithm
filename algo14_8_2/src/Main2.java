import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException {

		String src = "4 8 4\r\n" + "6 1 4 9\r\n" + "7 2\r\n" + "3 3\r\n" + "4 5\r\n" + "5 1\r\n" + "2 2\r\n" + "1 4\r\n"
				+ "8 4\r\n" + "9 4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());// 사대의 수
		int N = Integer.parseInt(st.nextToken());// 동물의수
		int L = Integer.parseInt(st.nextToken());// 사정거리
		int[] sadae = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sadae[i] = Integer.parseInt(st.nextToken());
		} // 사대 x좌표 받았다
//		Arrays.sort(sadae);
//		System.out.println(Arrays.toString(sadae));
		int ans = 0;
		Queue<int[]> anm = new LinkedList<>();
		go: for (int i = 0; i < N; i++) {// 동물 받는다
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (b > L) {
				// 안넣어도됨
				continue;
			}
			if (b == L) {
				for (int j = 0; j < M; j++) {// 사대 돌면서
					if (a == sadae[j] && b <= L) {
//						System.out.println(a + " " + b + " 동물");
						ans++;
						continue go;
					}
				}
			}
			anm.offer(new int[] { a, b });
		}
		go: while (!anm.isEmpty()) {
//			System.out.println(".......................");
			int[] tmparr = anm.poll();
			for (int j = 0; j < M; j++) {// 사대
				int tmp = Math.abs(sadae[j] - tmparr[0]) + tmparr[1];
				if (tmp <= L) {
//					System.out.println("사대" + sadae[j] + " " + tmparr[0] + " " + tmparr[1] + " 동물 ");
					ans++;
					continue go;
				}
			}
//
		}
		System.out.println(ans);
	}
}

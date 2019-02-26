import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int M =sc.nextInt();// 사대의 수
		int N = sc.nextInt();// 동물의수
		int L = sc.nextInt();// 사정거리
		int[] sadae = new int[M];
		for (int i = 0; i < M; i++) {
			sadae[i] = sc.nextInt();
		} // 사대 x좌표 받았다
		Arrays.sort(sadae);
//		System.out.println(Arrays.toString(sadae));
		int ans = 0;
		Queue<int[]> anm = new LinkedList<>();
		for (int i = 0; i < N; i++) {// 동물 받는다
			int a = sc.nextInt();
			int b =sc.nextInt();
			if (b > L) {
				// 안넣어도됨
				continue;
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

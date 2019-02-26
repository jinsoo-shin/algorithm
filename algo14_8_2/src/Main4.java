import java.util.*;
import java.io.*;

public class Main4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();// 사대의 수
		int N = sc.nextInt();// 동물의수
		int L = sc.nextInt();// 사정거리
		int[] sadae = new int[M];
		for (int i = 0; i < M; i++) {
			sadae[i] = sc.nextInt()-1;
		} // 사대 x좌표 받았다
		Arrays.sort(sadae);
		int ans = 0;
		boolean[][] map = new boolean[sadae[M - 1] + 2 * L][L];
//		anm = new LinkedList<>();
		go: for (int i = 0; i < N; i++) {// 동물 받는다
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			if (b > L-1) {
				// 안넣어도됨
				continue;
			}
			map[a][b] = true;
//			anm.add(new Node(a, b));
		}

		for (boolean[] row : map) {
			System.out.println(Arrays.toString(row));
		}
//		System.out.println(anm);
		for (int i = 0; i < M; i++) {// 사대 돌리기
//			cal(sadae[i], L);
		}
		System.out.println(ans);
	}

	static List<Node> anm;

	static class Node {
		int a;
		int b;

		public Node(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + "]\n";
		}

	}

	static void cal(int x, int L) {// 사대x
		for (int i = 0; i < anm.size(); i++) {

		}
	}
}

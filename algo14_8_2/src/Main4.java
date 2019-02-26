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
			sadae[i] = sc.nextInt();
		} // 사대 x좌표 받았다
//		Arrays.sort(sadae);
//		System.out.println(Arrays.toString(sadae));
		int ans = 0;
		anm = new ArrayList<>();
		go: for (int i = 0; i < N; i++) {// 동물 받는다
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (b > L) {
				// 안넣어도됨
				continue;
			}
			anm.add(new Node(a, b));
		}
		System.out.println(anm);
		int idx = 0;
		while (idx < anm.size()) {
			if (anm.isEmpty()) {
				break;
			}
			Node animal = anm.get(idx);
			System.out.println(animal.toString());
			for (int i = 0; i < M; i++) {
				System.out.println(sadae[i]);
				if (Math.abs(animal.a - sadae[i]) > L) {
					continue;
				}
				if (Math.abs(animal.a - sadae[i]) + animal.b <= L) {
					anm.remove(idx);
					System.out.println(anm);
					idx--;
					ans++;
					continue;
				}
			}
			idx++;
			if (idx < 0) {
				idx = 0;
			}
//			System.out.println(idx);

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

}

import java.io.*;
import java.util.*;

public class Main정올사냥꾼withS {
	static class Animal implements Comparable<Animal> {
		int x, y;

		public Animal(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Animal o2) {
			return this.x - o2.x;
		}

		@Override
		public String toString() {
			return "Animal [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		String src = "4 8 4\r\n" + "6 1 4 9\r\n" + "7 2\r\n" + "3 3\r\n" + "4 5\r\n" + "5 1\r\n" + "2 2\r\n" + "1 4\r\n"
				+ "8 4\r\n" + "9 4";
//		String src = "1 5 3\r\n" + "3\r\n" + "2 2\r\n" + "1 1\r\n" + "5 1\r\n" + "4 2\r\n" + "3 3";
//		String src = "4 3 13\r\n" + "7 13 16 1 \r\n" + "2 2\r\n" + "3 18\r\n" + "17 7";
//		String src = "10 19 13\r\n" + "10 17 9 18 11 16 7 4 12 3 \r\n" + "17 13\r\n" + "1 11\r\n" + "16 14\r\n"
//				+ "6 12\r\n" + "3 14\r\n" + "14 11\r\n" + "10 13\r\n" + "4 13\r\n" + "12 13\r\n" + "15 13\r\n"
//				+ "9 13\r\n" + "18 13\r\n" + "5 12\r\n" + "13 12\r\n" + "7 13\r\n" + "3 13\r\n" + "11 14\r\n"
//				+ "15 12\r\n" + "6 13";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());// 사대
		int N = Integer.parseInt(st.nextToken());// 동물
		int L = Integer.parseInt(st.nextToken());// 사정거리

		int[] gun = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(gun);
		Animal[] animal = new Animal[N];
//		int[][] anm = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
//			anm[i][0] = a;
//			anm[i][1] = a;
			animal[i] = new Animal(a, b);
		}
		Arrays.sort(animal);
//		Arrays.sort(anm, new Comparator<int[]>() {

//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
		// 사대가 동물보다 작으면 이동
		int ans = 0;
		int tmp = 0;
		go: for (int i = 0, j = 0; i < N; i++) {
			// i 동물 j 사대
			// i동물의 x좌표보다 같거나 큰 사대를 만날때까지 오른쪽 사대로 이동
			while (gun[j] < animal[i].x && j < M - 1) {
//			while (gun[j] < anm[i][0] && j < M - 1) {
				j++;
			}

			// j 사대는 i동물보다 같거나 오른쪽에 위치할것임.
			if (j - 1 >= 0 && j - 1 < M) {
//				tmp = Math.abs(anm[i][0] - gun[j - 1]) + anm[i][1];
				tmp = Math.abs(animal[i].x - gun[j - 1]) + animal[i].y;
				if (tmp <= L) {
					ans++;
					continue go;
				}
			}
//			tmp = Math.abs(anm[i][0] - gun[j]) + anm[i][1];
			tmp = Math.abs(animal[i].x - gun[j]) + animal[i].y;
			if (tmp <= L) {
				ans++;
				continue go;
			}
		}

		System.out.println(ans);

	}

}

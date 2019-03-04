import java.io.*;
import java.util.*;

public class Main정올사냥꾼 {

	public static void main(String[] args) throws IOException {
//		String src = "4 8 4\r\n" + "6 1 4 9\r\n" + "7 2\r\n" + "3 3\r\n" + "4 5\r\n" + "5 1\r\n" + "2 2\r\n" + "1 4\r\n"
//				+ "8 4\r\n" + "9 4";
//		String src = "1 5 3\r\n" + "3\r\n" + "2 2\r\n" + "1 1\r\n" + "5 1\r\n" + "4 2\r\n" + "3 3";
		String src = "4 3 13\r\n" + "7 13 16 1 \r\n" + "2 2\r\n" + "3 18\r\n" + "17 7";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());// 사대
		int N = Integer.parseInt(st.nextToken());// 동물
		int L = Integer.parseInt(st.nextToken());// 사정거리

		int[] sand = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sand[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sand);

		System.out.println(Arrays.toString(sand));
		int ans = 0;
//		int[][] animal = new int[N][2];
		for (int i = 0; i < N; i++) {
			first = 0;
			last = 0;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (b > L) {
				continue;
			}
			System.out.println("동물좌표" + " " + a + " " + b);
			binary(sand, 0, sand.length - 1, a, Math.abs(L - b));
			System.out.println(first + " " + last);
			for (int j = first; j <= last; j++) {
				int tmp = Math.abs(sand[j] - a) + b;
				if (tmp <= L) {
					ans++;
					System.out.println("-------------------호우허안어");
					break;
				}

			}
//			animal[i][0] = Integer.parseInt(st.nextToken());
//			animal[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(ans);

//		System.out.println("찾을거" + animal[0][0] + " " + animal[0][1]);
//		binary(sand, 0, sand.length - 1, animal[0][0], Math.abs(L - animal[0][1]));
//		for (int i = first; i <= last; i++) {
//			int tmp = Math.abs(sand[i] - animal[0][0]) + animal[0][1];
//			if(tmp<=L) {
//				System.out.println("호우허안어");
//			}
//
//		}
	}

	static int first, last;

	static void binary(int[] arr, int start, int end, int find, int term) {

		int mid = (start + end) / 2;
		System.out.println(start + " " + mid + " " + end);
		if (start > end) {
			return;
		}
		if (start == mid || end == mid) {
			return;
		}
		if (arr[mid] <= find && find <= arr[end]) {
			first = mid;
			last = end;
			binary(arr, mid, end, find, term);
		} else if (arr[start] <= find && find <= arr[mid]) {
			first = start;
			last = mid;
			binary(arr, start, mid, find, term);
		} else if (arr[end] < find) {
			first = end;
			last = end;
		}
	}
}

import java.io.*;
import java.util.*;

public class Solution_1493 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "10000 10000\r\n" + "3 9";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		arr = new int[300];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = (i + 1) * i / 2;
		}
//		System.out.println(Arrays.toString(arr));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int ans = 0;
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			int[] tmpP = calXy(p);
			int[] tmpQ = calXy(q);

			tmpP[0] += tmpQ[0];
			tmpP[1] += tmpQ[1];
//			System.out.println(Arrays.toString(tmpP));
			ans = calNbsp(tmpP[0], tmpP[1]);
			// System.out.println("좌표를구한다" + Arrays.toString(calXy(9)));
//			System.out.println("좌표->&"+calNbsp(2, 2));
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int[] arr;

	static int[] calXy(int p) {// &p를 받아서 좌표를 반환하자
		int[] cal = new int[2];

		// 몇번째 box인지...알아내야함....
		// &박스n 끝번호는 n(n+1)/2 이고 좌표는 (박스n,1)임
		int box = 0;
		for (int i = 1; i < arr.length; i++) {
			if (p > arr[i - 1] && p <= arr[i]) {
				box = i;
			}
		}
		// 박스 구했고
//		System.out.println(box);
		int tmp = arr[box] - p;
//		System.out.println("제일 끝과 차이 " + tmp);
//		System.out.println("좌표 x:" + (box - tmp) + " y:" + (1 + tmp));
		cal[0] = box - tmp;
		cal[1] = 1 + tmp;
		return cal;
	}

	static int calNbsp(int x, int y) {
		int p = 0;
		int box = x + y - 1;// 이게
		int tmp = box - x;
//		System.out.println("ddd" + tmp);
		return arr[box] - tmp;
	}
}

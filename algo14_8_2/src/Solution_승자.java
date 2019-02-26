import java.util.*;
import java.io.*;

public class Solution_승자 {
	public static void main(String[] args) throws IOException {

		String src = "5\r\n" + "1\r\n" + "5\r\n" + "7\r\n" + "10\r\n" + "123456789123456789";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		List<long[]> list = new LinkedList<>();
		int idx = 0;
		while (true) {
			long startA = (long) (2 * (Math.pow(4, idx) - 1) / 3);
			if (startA > Math.pow(10, 18)) {
				break;
			}
			list.add(new long[] { startA, (long) (startA + Math.pow(4, idx) - 1) });
			idx++;
		}
//		for (long[] row : list) {
//			System.out.println(Arrays.toString(row));
//		}

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Long N = Long.parseLong(br.readLine());
//
//			for (long[] row : list) {
//				System.out.println(Arrays.toString(row));
//			}
			int getIdx = 0;
			for (int i = 0; i < list.size(); i++) {
				if (N <= list.get(i)[1]) {
					getIdx = i;
					break;
				}
			}
			System.out.println(N + " " + list.get(getIdx)[0] + " " + list.get(getIdx)[1]);
			String ans = "";
			if (list.get(getIdx)[0] <= N && list.get(getIdx)[1] >= N) {
				ans = "Alice";
			} else {
				ans = "Bob";
			}
//			System.out.println("ddd" + getIdx);
			System.out.println("#" + tc + " " + ans);
//			System.out.println("---------------");
		}
	}

}
//B 1
//A 2 5   4 
//B 6 9   4
//A 10 25  16
//B 26 41  16
//A 42 105  64
//B 106 169  64
//A 170 425   256
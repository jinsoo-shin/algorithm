import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5431 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "5 3\r\n" + "2 5 3\r\n" + "7 2\r\n" + "4 6";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] stu = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				stu[tmp] = 1;// 제출한 학생번호
			}

			System.out.print("#" + tc);
			for (int i = 1; i < stu.length; i++) {
				if (stu[i] != 1)
					System.out.print(" " + i);
			}
			System.out.println();
		}
	}
}

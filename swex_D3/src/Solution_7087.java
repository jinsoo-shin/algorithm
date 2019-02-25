import java.io.*;
import java.util.*;

public class Solution_7087 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "1\r\n" + "5\r\n" + "Air\r\n" + "Dad\r\n" + "Ear\r\n" + "Blue\r\n" + "Ace";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 입력수
			char[] str = new char[N];
			int[] cnt = new int[26];// 알파벳 빈도수 체크용
			for (int i = 0; i < N; i++) {
				int tmp = br.readLine().charAt(0) - '0' - 17;
//				str[i] = br.readLine().charAt(0);// 앞글자만 받아오기
				cnt[tmp]++;
			}
//			System.out.println(Arrays.toString(cnt));
			int ans = 0;
			for (int a : cnt) {
				if (a == 0) {
					break;
				} else {
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}

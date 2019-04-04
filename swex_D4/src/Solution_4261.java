import java.io.*;
import java.util.*;

public class Solution_4261 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "1\r\n" + "6666 3\r\n" + "tomo mono dak";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		Map<String, String> map = new HashMap<>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String[] input = st.nextToken().split("");
			int N = Integer.parseInt(st.nextToken());
			int ans = 0;
			String[] tmpStr = br.readLine().split(" ");
			String[][] str = new String[N][];
			for (int i = 0; i < N; i++) {
				str[i] = tmpStr[i].split("");
//				System.out.println(Arrays.toString(str[i]));
			}

			next: for (int j = 0; j < N; j++) {// 문자열 돌려서 검색해보기
//				System.out.println("문자열" + Arrays.toString(str[j]));
				for (int i = 0; i < input.length; i++) {// 6666
					String key = input[i];// 6
//					System.out.println(key + " key");
					if (i >= str[j].length) {
						continue next;
					}
					String ch = str[j][i];
					if (!map.get(key).contains(ch)) {
						continue next;
					}
				}
//				System.out.println(j + "통과");
				ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}

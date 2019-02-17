import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1926 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "36";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			String[] tmp = String.valueOf(i).split("");
			int cnt = 0;
			for (int j = 0; j < tmp.length; j++) {
				if (tmp[j].equals("3") || tmp[j].equals("6") || tmp[j].equals("9")) {
					cnt++;
				}
			}
			if (cnt <= tmp.length&&cnt>0) {
				for (int k = 0; k < cnt; k++) {
					sb.append("-");
				}
				// 횟수만큼 짝짝
			} else {
				sb.append(i);
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}

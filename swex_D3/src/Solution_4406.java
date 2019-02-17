import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4406 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "congratulation\r\n" + "synthetic\r\n" + "fluid";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] tmp = br.readLine().split("");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].equals("a") || tmp[i].equals("e") || tmp[i].equals("i") || tmp[i].equals("o")
						|| tmp[i].equals("u")) {
				} else {
					sb.append(tmp[i]);
				}
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}

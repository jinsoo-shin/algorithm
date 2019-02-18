import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4751다이아몬드 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "APPLE\r\n" + "D";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] tmpstr = br.readLine().split("");
			int len = tmpstr.length;
			StringBuilder sb = new StringBuilder();
			int idx = 0;
			for (int i = 0; i < 5; i++) {
				int tmp = Math.abs(2 - i);
				if (tmp == 2) {// 0 4
					sb.append(".");
					for (int j = 0; j < len; j++) {
						sb.append(".#..");
					}
					if (i != 4) {
						sb.append("\n");
					}
				} else if (tmp == 1) { // 1 3
					sb.append(".");
					for (int j = 0; j < len * 2; j++) {
						sb.append("#.");
					}
					sb.append("\n");
				} else if (tmp == 0) {// 2 가운데
					sb.append("#");
					for (int j = 0; j < len; j++) {
						sb.append(".");
						sb.append(tmpstr[idx++]);
						sb.append(".#");
					}
					sb.append("\n");
				}
			}

			System.out.println(sb.toString());
		}
	}
}

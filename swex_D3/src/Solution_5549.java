import java.io.*;
import java.util.*;

public class Solution_5549 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "5\r\n" + "1\r\n" + "10\r\n" + "100\r\n" + "185787124368712386825387273871\r\n"
				+ "82518881239123819238912929292";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] tmp = br.readLine().split("");
			int tmpNum = Integer.parseInt(tmp[tmp.length - 1]);
			if(tmpNum%2==0) {
				System.out.println("#" + tc + " Even");
			}else {
				System.out.println("#" + tc + " Odd");
			}
		}
	}
}

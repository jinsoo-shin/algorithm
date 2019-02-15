package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1288 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		List<String> num = new ArrayList<>();
		String src = "5\r\n" + "1\r\n" + "2\r\n" + "11\r\n" + "1295\r\n" + "1692";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < 10; i++) {
				num.add(String.valueOf(i));
			}
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			int x = 1;
			while (!num.isEmpty()) {
				int tmpN = x * N;
				String[] tmp = String.valueOf(tmpN).split("");
//				System.out.println(Arrays.toString(tmp)+" "+num.toString());
				for (int i = 0; i < tmp.length; i++) {
					if (num.contains(tmp[i])) {
						num.remove(tmp[i]);
					}
				}
//				System.out.println(tmpN);
				ans=tmpN;
				x++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}

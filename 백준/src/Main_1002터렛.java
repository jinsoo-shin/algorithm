import java.io.*;
import java.util.*;

public class Main_1002터렛 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int[] jo = new int[3];
			int[] baek = new int[3];
			for (int i = 0; i < 3; i++) {
				jo[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 3; i++) {
				baek[i] = Integer.parseInt(st.nextToken());
			}
			double d = Math.pow(Math.abs(jo[0] - baek[0]), 2) + Math.pow(Math.abs(jo[1] - baek[1]), 2);
			int ans = 0;
			double sumR = Math.pow(jo[2] + baek[2], 2);
			double difR = Math.pow(Math.abs(jo[2] - baek[2]), 2);

			if (d == 0) {
				if (difR == 0) {
					ans = -1;
				} else {
					ans = 0;
				}
			} else if (difR == d || sumR == d) {
				ans = 1;
			} else if (difR < d && d < sumR) {
				ans = 2;
			} else {
				ans = 0;
			}

			System.out.println(ans);
		}
	}

}
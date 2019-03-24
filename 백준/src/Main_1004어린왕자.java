import java.io.*;
import java.util.*;

public class Main_1004어린왕자 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			st = new StringTokenizer(br.readLine());

			System.out.println("#" + tc + " " + ans);
		}
	}

}
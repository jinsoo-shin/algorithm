import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1234비밀번호 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		String src = "10 1238099084  \r\n" + "16 4100112380990844";
//		String src = "16 4100112380990844";
		String src = "10 1238099084\r\n" + "16 4100112380990844\r\n" + "26 12380990844100112380990844\r\n"
				+ "42 123809908444100112380990844100112380990844\r\n"
				+ "55 1238099084441001123809908441001321238099084432180990844\r\n"
				+ "60 123809908444100145351123809908441001321238099084432180990844\r\n"
				+ "71 12380990844410013218099084441001123809908441001321238099084432180990844\r\n"
				+ "99 123809908444100180990844410013211238099084410013212380990844123809908441238099084410013232180990844\r\n"
				+ "82 1238099084441001410011238099084412380990844100132123809908441238099084432180990844\r\n"
				+ "58 0899809812380990844100132123809908441238099084432180990844";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			List<String> list = new ArrayList<>();
			String[] tmp = st.nextToken().split("");
			for (String t : tmp) {
				list.add(t);
			}

			go: for (int i = 0; i < list.size() - 1; i++) {
				int tmpsize = list.size();
				if (list.get(i).equals(list.get(i + 1))) {
					cnt = 1;
					list.remove(i);
					list.remove(i);
					if (i >= tmpsize - 2 && i < 0) {
						break go;
					}
					check(i - 1, i, list);
					i = i - cnt;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (String a : list) {
				sb.append(a);
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}

	static int cnt;

	static void check(int a, int b, List list) {
		if (b >= list.size() || a < 0) {
			return;
		}
		if (list.get(a).equals(list.get(b))) {
			list.remove(a);
			list.remove(a);
			cnt += 1;
			check(a - 1, a, list);
		} else {
			return;
		}
	}
}

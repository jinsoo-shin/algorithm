import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
//소연이꺼....
public class 프림그래프 {

	static class node {
		int x;
		int y;
		long dis;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "6\r\n" + 
				"0 0 400 400 1000 2000\r\n" + 
				"0 100 0 100 600 2000\r\n" + 
				"0.3";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			node nds[] = new node[n];
			String s[] = br.readLine().split(" ");
			String s2[] = br.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				nds[i] = new node();
				nds[i].x = Integer.parseInt(s[i]);
				nds[i].y = Integer.parseInt(s2[i]);
				nds[i].dis = Long.MAX_VALUE;
			}
			double e = Double.parseDouble(br.readLine());

			boolean ck[] = new boolean[n];
			long ans = 0;

			nds[0].dis = 0;
			for (int i = 0; i < n; i++) {
				long min = Long.MAX_VALUE;
				int minidx = 0;
				for (int j = 0; j < n; j++) {
					if (!ck[j] && nds[j].dis < min) {
						min = nds[j].dis;
						minidx = j;
					}
				}
				ck[minidx] = true;
				ans += nds[minidx].dis;

				for (int j = 0; j < n; j++) {
					if (!ck[j]) {
						long tmp = (long) (Math.pow((nds[minidx].x - nds[j].x), 2)
								+ Math.pow((nds[minidx].y - nds[j].y), 2));
//                              (long) (Math.sqrt(
//                              Math.pow((nds[minidx].x - nds[j].x), 2) + Math.pow((nds[minidx].y - nds[j].y), 2)));
						if (tmp < nds[j].dis) {
							nds[j].dis = tmp;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + (long) ((ans * e) + 0.5));

		}
	}
}
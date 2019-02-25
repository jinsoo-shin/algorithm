import java.io.*;
import java.util.*;

public class Solution_4522 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "2\r\n" + "h?ih\r\n" + "b???a";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Queue<Integer> q = new LinkedList<>();
			String ans = "Exist";
			String[] tmp = br.readLine().split("");
			int cnt = 0;
			boolean flag = true;
			for (int i = 0; i < (tmp.length + 1) / 2; i++) {
				if (tmp[i].equals("?") || tmp[tmp.length - 1 - i].equals("?")) {
					q.add(i);
					q.add(tmp.length - 1 - i);
					continue;
				}
				if (tmp[i].equals(tmp[tmp.length - 1 - i])) {
					continue;
				} else {
					flag = false;//
					ans = "Not exist";
					break;
				}
			}
//			if (flag) {
//				// [1, 2]
//				for(int j=0;j<q.size();j++) {
//					int tmpIdx = q.poll();
//					if (tmp[tmp.length - 1 - tmpIdx].equals("?")) {
//						// 무조건 성공하니깐
//						break;
//					}
//					if (tmp[tmpIdx].equals(tmp[tmp.length - 1 - tmpIdx])) {
//
//					}					
//					
//					
//				}
//				System.out.println(q);
//
//			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}

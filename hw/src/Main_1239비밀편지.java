import java.io.*;
import java.util.*;

public class Main_1239비밀편지 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Map<String, Character> map = new HashMap<>();
		map.put("000000", 'A');
		map.put("001111", 'B');
		map.put("010011", 'C');
		map.put("011100", 'D');
		map.put("100110", 'E');
		map.put("101001", 'F');
		map.put("110101", 'G');
		map.put("111010", 'H');
		String ans = "";
		int N = sc.nextInt();
		String tmpStr = sc.next();
		String[] str = new String[N];
		go: for (int i = 0; i < N; i++) {
			str[i] = tmpStr.substring(i * 6, 6 * (i + 1));
			int noCnt = 0;
			for (String s : map.keySet()) {
				int cnt = 0;
				for (int j = 0; j < 6; j++) {
					if (cnt >= 2) {
						break;
					}
					if (str[i].charAt(j) == s.charAt(j)) {
					} else {
						cnt++;
					}
				}
				if (cnt <= 1) {
					ans += map.get(s);
				} else {
					noCnt++;
				}
			}
			if (noCnt == 8) {
				ans = "" + (i + 1);
				break go;
			}
		}
		System.out.println(ans);
	}

}

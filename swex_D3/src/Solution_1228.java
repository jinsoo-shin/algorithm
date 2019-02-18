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

public class Solution_1228 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "11\r\n" + "449047 855428 425117 532416 358612 929816 313459 311433 472478 589139 568205\r\n"
				+ "7\r\n"
				+ "I 1 5 400905 139831 966064 336948 119288 I 8 6 436704 702451 762737 557561 810021 771706 I 3 8 389953 706628 552108 238749 661021 498160 493414 377808 I 13 4 237017 301569 243869 252994 I 3 4 408347 618608 822798 370982 I 8 2 424216 356268 I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		for (int tc = 1; tc <= 1; tc++) {
			int N = Integer.parseInt(br.readLine());// 원본길이
			List<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int com = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < com; i++) {
				String tmp = st.nextToken();
				if (tmp.equals("I")) {
					int x = Integer.parseInt(st.nextToken());// 앞에서 x의 위치 바로 다음에
					int y = Integer.parseInt(st.nextToken());// y개의 숫자를 삽입하라
					if (x >= 10) {
						for (int k = 0; k < y; k++) {
							st.nextToken();
						}
					} else {
						for (int k = 0; k < y; k++) {
							int tmps = Integer.parseInt(st.nextToken());
							list.add(k + x, tmps);
						}
					}
				}
			}

			int ans = 0;
			System.out.print("#" + tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
}

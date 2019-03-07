import java.io.*;
import java.util.*;

public class Solution_7102 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "2\r\n" + "6 6\r\n" + "6 4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
//			각 카드 세트는 1번 카드부터 N번 카드, 1번 카드부터 M번 카드로 구성되어 있다.
//
//			심심했던 준홍이는 각 카드 세트에서 카드 한 장씩을 골랐다.
//
//			그리고 각 카드에 적힌 숫자를 더해보았다.
//
//			1번 카드와 1번 카드를 골랐다면 카드에 적힌 숫자의 합은 2가 될 것이고, N번 카드와 M번 카드를 골랐다면 카드에 적힌 숫자의 합은 N+M이 될 것이다.
//
//			문득 준홍이는 각 카드 세트에서 카드를 한 장씩 골라서 카드에 적힌 숫자를 합한 결과 중, 등장할 확률이 가장 높은 숫자는 어떤 숫자일지 궁금해졌다.
//
//			단, 카드 세트에서 어떤 카드를 선택할 확률은 모두 동일하다고 가정한다.

			int[] num1 = new int[N];
			int[] num2 = new int[M];
			List<int[]> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				num1[i] = i + 1;
//				list.add(i + 1);
			}
			for (int j = 0; j < M; j++) {
				num2[j] = j + 1;
			}
//			System.out.println(Arrays.toString(num1));
//			System.out.println(Arrays.toString(num2));

			int max = num1[N - 1] + num2[M - 1];

			int[] arr = new int[max + 1];
			for (int j = 0; j < M; j++) {
				for (int i = 0; i < N; i++) {
					int tmp = num2[j] + num1[i];
//					list.add(tmp);
					arr[tmp]++;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				list.add(new int[] { i, arr[i] });
			}

			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] a, int[] b) {
					if (b[1] == a[1]) {// 빈도수가 같다면
						return a[0] - b[0];
					}
					return b[1] - a[1];
				}
			});

//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(Arrays.toString(list.get(i)));
//			}
			int maxCnt = list.get(0)[1];

			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i)[1] == maxCnt) {
					sb.append(" " + list.get(i)[0]);
				} else {
					break;
				}
			}

			System.out.println(sb);
		}
	}
}

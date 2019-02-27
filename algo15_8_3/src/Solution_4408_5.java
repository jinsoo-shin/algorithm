import java.util.*;
import java.io.*;

public class Solution_4408_5 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] corridor;//

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int max = 0;
			int N = Integer.parseInt(br.readLine());
			int big, small;
			List<Student> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken()) - 1) / 2;
				int y = (Integer.parseInt(st.nextToken()) - 1) / 2;
				big = Math.max(x, y);
				small = Math.min(x, y);
				max = Math.max(max, big);
				list.add(new Student(small, big));
			} // 인덱스로 변환해서 넣어놓는다.

//			System.out.println(max);
//			System.out.println(list);
			//////////// 초기화를 하는칸
			corridor = new int[max + 1];

			for (int i = 0; i < list.size(); i++) {
//				Student
				Student tmp = list.get(i);
//				System.out.println(tmp);
				for (int j = tmp.x; j <= tmp.y; j++) {
					corridor[j]++;
				}
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < corridor.length; i++) {
				set.add(corridor[i]);
			}
			System.out.println(set);
			Object[] tmpA = set.toArray();
//			System.out.println(Arrays.toString(tmpA));
//			System.out.println(Arrays.toString(corridor));
			System.out.println("#" + tc + " " + tmpA[tmpA.length - 1]);
		}
	}

	static int ans;

	static class Student {
		int x;
		int y;

		public Student(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}

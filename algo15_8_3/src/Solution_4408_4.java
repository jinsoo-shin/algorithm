import java.util.*;
import java.io.*;

public class Solution_4408_4 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int[] corridor;//

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int max = 0;
			int N = sc.nextInt();// 학생수
			int big, small;
			List<Student> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int x = (sc.nextInt() - 1) / 2;
				int y = (sc.nextInt() - 1) / 2;
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

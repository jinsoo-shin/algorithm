import java.io.*;
import java.util.*;

public class Solution_특이한자석 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "2\r\n" + "0 0 1 0 0 1 0 0\r\n" + "1 0 0 1 1 1 0 1\r\n" + "0 0 1 0 1 1 0 0\r\n"
//				+ "0 0 1 0 1 1 0 1\r\n" + "1 1\r\n" + "3 -1";
//		String src = "1\r\n" + "2\r\n" + "1 0 0 1 0 0 0 0\r\n" + "0 1 1 1 1 1 1 1\r\n" + "0 1 0 1 0 0 1 0\r\n"
//				+ "0 1 0 0 1 1 0 1\r\n" + "3 1\r\n" + "1 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			// 회전시키는 횟수
			K = Integer.parseInt(br.readLine());
			// 1 번 자석부터 4 번 자석까지 각각 8 개 날의 자성정보 12시부터 시계방향
			// 0이면 N 1이면 S
			// - 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
			// - 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
			// - 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
			// - 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.
			list = new ArrayList[4];
			for (int i = 0; i < 4; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					list[i].add(Integer.parseInt(st.nextToken()));
				}
//				System.out.println(list[i]);
			}

			// 한칸씩 회전시키는 회전정보
			// 1이면 시계
			// -1이면 반대
			rot = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				rot[i][0] = Integer.parseInt(st.nextToken()) - 1;
				rot[i][1] = Integer.parseInt(st.nextToken());
//				System.out.println(Arrays.toString(rot[i]));
				rotation(rot[i][0], rot[i][1]);
			}
//			rotation(2, 1);
//			System.out.println("----");
//			rotation(0, 1);
//			check(2);
			int score = 1;
			for (int i = 0; i < 4; i++) {
				ans += score * list[i].get(0);
				score *= 2;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void rotation(int num, int dir) {
		// 0번을 시계방향으로
		// num은 무조건 돌리기
		// 돌릴수있는지 체크 끝
		boolean[] flag = check(num);
//		System.out.println(Arrays.toString(flag));
		int[] dirArr = new int[4];
		dirArr[num] = dir;
		for (int i = num + 1; i < 4; i++) {// 오른쪽
			if (flag[i]) {
				dirArr[i] = dirArr[i - 1] * (-1);
			}
		}
		for (int i = num - 1; i >= 0; i--) {// 왼쪽으로
			if (flag[i]) {
				dirArr[i] = dirArr[i + 1] * (-1);
			}
		}
		// 방향 설정끝
//		System.out.println(Arrays.toString(dirArr));
		for (int i = 0; i < 4; i++) {
			if (dirArr[i] == 1) {// 시계
				// 맨뒤가 맨앞으로
				int tmp = list[i].get(7);
				list[i].remove(7);
				list[i].add(0, tmp);
			} else if (dirArr[i] == -1) {// 반시계
				// 맨앞이 맨뒤로
				int tmp = list[i].get(0);
				list[i].remove(0);
				list[i].add(7, tmp);
			}
		}
//		for (int i = 0; i < 4; i++) {
//			System.out.println(list[i]);
//		}
	}

	static boolean[] check(int num) {
		boolean[] flag = new boolean[4];
		// true면 돌아가기
		// false면 NN SS여서 안움직임
		flag[num] = true;
		for (int i = num + 1; i < 4; i++) {
			int mag1 = list[i].get(6);// 오른쪽꺼
			int mag2 = list[i - 1].get(2);// 왼쪽꺼
			if (!flag[i - 1]) {
				flag[i] = false;
				continue;
			}
			if (mag1 == mag2) {
				flag[i] = false;
			} else {
				flag[i] = true;
			}
		}
		for (int i = num - 1; i >= 0; i--) {
			int mag1 = list[i + 1].get(6);// 오른쪽꺼
			int mag2 = list[i].get(2);// 왼쪽꺼
			if (!flag[i + 1]) {
				flag[i] = false;
				continue;
			}
			if (mag1 == mag2) {
				flag[i] = false;
			} else {
				flag[i] = true;
			}
		}
//		System.out.println(Arrays.toString(flag));
		return flag;
	}

	static List<Integer> list[];
	static int ans, K;
	static int[][] rot;
}

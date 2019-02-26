import java.io.*;
import java.util.*;

public class Solution3 {

//d
//Disjoint-Set 서로소 집합
//Union-Find 유니온 파인드 => 합집합 찾기
//
//두개의 노드를 선택해서 해당 노드가 서로 연결되어있는지 여부를 파악하기 위한 알고리즘

	public static void main(String[] args) throws IOException {
		String src = "1\r\n" + "7\r\n" + "19 26 34 12 25 48 40 \r\n" + "32 43 49 39 28 44 1 \r\n"
				+ "33 14 8 15 23 6 38 \r\n" + "3 21 24 13 9 7 41 \r\n" + "42 17 31 4 45 27 18 \r\n"
				+ "20 29 47 22 30 5 2 \r\n" + "16 46 10 37 36 35 11 ";
//		String src = "1\r\n" + "3\r\n" + "9 3 4\r\n" + "6 1 5\r\n" + "7 8 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			parents = new int[N * N + 1];
			int[] count = new int[N * N + 1];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					makeSet(map[i][j]);
				}
			}
			for (int[] row : map) {
				System.out.println(Arrays.toString(row));
			}
			/// 맵에 입력 끝
			System.out.println(Arrays.toString(parents));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					search(i, j, map[i][j]);
				}
			}
			// 출력한다
			System.out.println(Arrays.toString(parents));
			for (int i = 1; i < parents.length; i++) {
				count[parents[i]]++;
			}
			System.out.println(Arrays.toString(count));

			int[] tmp = count.clone();
			Arrays.sort(tmp);
			System.out.println(Arrays.toString(tmp));
			int maxRoom = tmp[tmp.length - 1];

			int ans = 0;
			for (int i = 1; i < count.length; i++) {
				if (count[i] == maxRoom) {
					ans = i;
					break;
				}
			}
			System.out.println("#" + tc + " " + ans + " " + maxRoom);
		}
	}

	static int map[][];
	static int count;
	static int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] parents;

	static void search(int x, int y, int num) {

		for (int i = 0; i < 4; i++) {
			int cx = x + dxy[i][0];
			int cy = y + dxy[i][1];

			if (cx < 0 || cy < 0 || cx >= map.length || cy >= map.length) {
				continue;
			} // 범위 ㄴㄴ면 넘어가고
//			if (map[x][y] + 1 == map[cx][cy]) {
			if (map[x][y] < map[cx][cy]) {
				System.out.println(map[x][y] + " " + map[cx][cy]);
				union(map[x][y], map[cx][cy]);
			}
//			}
		}

	}

	static void makeSet(int num) { // 자기자신 집합 만들기
		parents[num] = num;
	}

	static int findSet(int x) { // 숫자를 넘겨주자
		if (parents[x] == x) {
			return x;// 자기자신과 같으면 자기 반환
		} else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	// 부모노드를 합치는 함수
	static void union(int x, int y) { // x가 시작점 y가. 뒤꺼
		int a = findSet(x);
		int b = findSet(y);// 각각 부모찾기
		if (x + 1 == y) {
			parents[b] = a;
			System.out.println("부모부모" + a + " " + b);
		}
	}
}

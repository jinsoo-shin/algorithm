	import java.io.*;
	import java.util.*;
	
	public class Solution_6057 {
	//	public class Solution {
		public static void main(String[] args) throws Exception {
			String src = "1\r\n" + "3 3\r\n" + "1 2\r\n" + "2 3\r\n" + "1 3";
	//		String src = "1\r\n" + "5 5\r\n" + "1 2\r\n" + "2 3\r\n" + "2 4\r\n" + "4 3\r\n" + "3 1";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			StringTokenizer st;
	//정점이 N개, 간선이 M개 있는 그래프가 주어진다. 정점에는 1번에서 N번까지의 번호가 붙어 있다.
	//이 때, i번 정점과 j번 정점 사이에, j번 정점과 k번 정점 사이에, k번 정점과 i번 정점 사이에
	//모두 간선이 있는 ( i, j, k ) (단, i < j < k )를 삼각형이라고 하자.
	//삼각형의 개수를 구하는 프로그램을 작성하라
			int T = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= T; tc++) {
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				ans = 0;
				int[][] map = new int[N][N];
				for (int i = 0; i < M; i++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken()) - 1;
					int y = Integer.parseInt(st.nextToken()) - 1;
					map[x][y] = 1;
					map[y][x] = 1;
				}
				for (int[] row : map) {
					System.out.println(Arrays.toString(row));
				}
				for (int i = 0; i < N - 2; i++) {
					for (int j = i + 1; j < N; j++) {
						int cnt = 0;
						if (map[i][j] == 1) {
							// 여기에 넘기자ㅏㅏㅏ
							per(map, i, j, 0);
						}
					}
				}
	
				System.out.println("#" + tc + " " + ans);
			}
		}
	
		static int ans;
	
		static void per(int[][] map, int startX, int startY, int cnt) {
	
			for (int i = startY + 1; i < map.length; i++) {
				if (map[startY][i] == 1) {
					if (map[i][startX] == 1) {
						ans++;
						System.out.println(startX + " " + startY + " " + i);
					}
				}
			}
	
		}
	}

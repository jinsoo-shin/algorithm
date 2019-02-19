package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1873_1 {
	static String[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };// 아래,오른쪽,위,왼쪽

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n4 6\r\n" + "*.*..*\r\n" + "*.....\r\n" + "..-...\r\n" + "^.*#..\r\n" + "10\r\n"
				+ "SRSSRRUSSR";
//		String src = "1\r\n13 13\r\n" + "-...#-.*...*#\r\n" + ".*-...-......\r\n" + ".....#...#...\r\n"
//				+ "**.*.#.#....-\r\n" + ".....#..-...-\r\n" + ".--.....*..*#\r\n" + ".-....*>*....\r\n"
//				+ "#..#..#......\r\n" + "....*#..-*...\r\n" + "...**..*.###-\r\n" + "......#-.*..*\r\n"
//				+ "............*\r\n" + "*.**#-...-.*.\r\n" + "54\r\n"
//				+ "LLUDSSLRRDDSSSLDDSDDRRDLLSUUULSLRSLDDSSSRDUUSRSLSSUDRS";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			map = new String[H][W];

			int[] current = new int[2];
			for (int h = 0; h < H; h++) {
				String[] tmp = br.readLine().split("");
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[i].equals("<") || tmp[i].equals("^") || tmp[i].equals("v") || tmp[i].equals(">")) {
						current[0] = h;
						current[1] = i;
					}
				}
				map[h] = tmp;
			}
			int N = Integer.parseInt(br.readLine());// 명령어
			String[] input = br.readLine().split("");

			for (int n = 0; n < N; n++) {
				String tmp = input[n];// 임시로 명령어 저장해두기
				if (tmp.equals("L")) {
					int x = current[0];
					int y = current[1];
					map[x][y] = "<";// 돌려놓고!
					int dir = 3;
					if (cango(current, dir)) {
						int cx = x+ dx[dir] * 1;
						int cy = y + dy[dir] * 1;
						String go = map[x][y];// 전차모양 임시
						map[x][y] = map[cx][cy];
						map[cx][cy] = go;
						current[0] = cx;
						current[1] = cy;
					}
				} else if (tmp.equals("R")) {
					int x = current[0];
					int y = current[1];
					map[x][y] = ">";// 돌려놓고!
					int dir = 1;
					if (cango(current, dir)) {
						int cx = x+ dx[dir] * 1;
						int cy = y + dy[dir] * 1;
						String go = map[x][y];// 전차모양 임시
						map[x][y] = map[cx][cy];
						map[cx][cy] = go;
						current[0] = cx;
						current[1] = cy;
					}
				} else if (tmp.equals("U")) {
					int x = current[0];
					int y = current[1];
					map[x][y] = "^";// 돌려놓고!
					int dir = 2;
					if (cango(current, dir)) {
						int cx = x+ dx[dir] * 1;
						int cy = y + dy[dir] * 1;
						String go = map[x][y];// 전차모양 임시
						map[x][y] = map[cx][cy];
						map[cx][cy] = go;
						current[0] = cx;
						current[1] = cy;
					}
				} else if (tmp.equals("D")) {
					int x = current[0];
					int y = current[1];
					map[x][y] = "v";// 돌려놓고!
					int dir = 0;
					if (cango(current, dir)) {
						int cx = x+ dx[dir] * 1;
						int cy = y + dy[dir] * 1;
						String go = map[x][y];// 전차모양 임시
						map[x][y] = map[cx][cy];
						map[cx][cy] = go;
						current[0] = cx;
						current[1] = cy;
					}
				} else if (tmp.equals("S")) {
					String cur = map[current[0]][current[1]];
					int dir = 0;
					if (cur.equals("^")) {
						dir = 2;
					} else if (cur.equals("<")) {
						dir = 3;
					} else if (cur.equals(">")) {
						dir = 1;
					} else if (cur.equals("v")) {
						dir = 0;
					}
					Shoot(current, dir);

				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

	}

	static void Shoot(int[] current, int dir) {// 쏜다
		int x = current[0];
		int y = current[1];

		int n = 0;
		int cx = 0;
		int cy = 0;
		while (true) {
			cx = x + dx[dir] * n;
			cy = y + dy[dir] * n;
			if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length) {//범위체크
				if (map[cx][cy].equals("*")) {
					map[cx][cy] = ".";
					return;
				} else if (map[cx][cy].equals("#")) {
					return;
				}

				n++;
			
			}else {
				return;
			}
			
		}

	}

	static boolean cango(int[] current, int dir) {// 갈수있는가
		int cx = current[0] + dx[dir] * 1;
		int cy = current[1] + dy[dir] * 1;
		if (dir == 0 || dir == 2) {
			if (cx < map.length && cx >= 0 && map[cx][cy].equals(".")) {// 평지
				return true;
			}
		} else if (dir == 1 || dir == 3) {
			if (cy < map[0].length && cy >= 0 && map[cx][cy].equals(".")) {// 평지
				return true;
			}
		}
		return false;
	}

}

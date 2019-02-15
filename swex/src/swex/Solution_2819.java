package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2819 {
	// 아래 위 오른쪽 왼쪽
	static int[][] dxy = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[] s;
	static Set<String> set;
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {

		String src = "1\r\n" + "1 1 1 1\r\n" + "1 1 1 2\r\n" + "1 1 2 1\r\n" + "1 1 1 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			set = new HashSet<>();
			arr = new int[4][4];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			s = new int[7];
//			per(0, 0, 0, 0);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
//					System.out.println("좌표"+i+" "+j+" "+arr[i][j]);
					s = new int[7];
					per(i, j, 0, 0);
				}
			}
			
			System.out.println(set.size());
			System.out.println("#" + tc + " ");
		}
	}

	static void per(int x, int y, int idx, int cnt) {// 7자리 만들기
		// x,y는 시작 위치
		// idx는 dxy용!!!!!
		if (cnt == 7) {
//			System.out.println(Arrays.toString(s));
			set.add(Arrays.toString(s));
//			System.out.println(s.toString());
//			s.toString();
//			System.out.println("좌표"+x+" "+y+" ");
			return;
		}
		s[cnt] = arr[x][y];
		for (int i = 0; i < 4; i++) {
			// 범위체크하고
			// 갈수있으면 보내기
			int cx = x + dxy[i][0]*1;
			int cy = y + dxy[i][1]*1;
			if (cx >= 0 && cx < 4 && cy >= 0 && cy < 4) {
				per(cx, cy, i, cnt + 1);
			}
		}
	}
}

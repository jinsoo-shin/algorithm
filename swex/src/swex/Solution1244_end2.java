package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1244_end2 {
	// 일부 그리드 완전탐색케이스
	// 주석 왕창 달았다
	static int max;
	static boolean flag;
	static int sub;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "10\r\n" + "123 1\r\n" + "2737 1\r\n" + "757148 1\r\n" + "78466 2\r\n" + "32888 2\r\n"
				+ "777770 5\r\n" + "436659 2\r\n" + "431159 7\r\n" + "112233 3\r\n" + "456789 10\r\n";
//		String src="1\r\n88832 4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			String[] number = st.nextToken().split("");
			int change = Integer.parseInt(st.nextToken());
			max = 0;
			flag = false; // 초기화
			sub = change; // num배열보다 큰 사이즈인 경우 차 기억하기 (나중에 홀수면 맨뒤에 2개만 swap)
			while (true) {
				if (change <= number.length) {
					flag = true; // num배열크기보다 크다 bool
					sub = sub % change - 1; // 차 기억해두기
					break;
					// change>num.length인데 per은 어차피 n-1까지밖에 최대 n번 돌기때문에
					// change 10이고 num=7인 경우에
					// 0~6까지 돌고 7~9까지 돌기때문에 (0~9까지가 10이니깐)
					// 차=change-num-1도 가능하고
					// c가 100 num이 6이런경우도 대비해서 %으로..? 어차피 c=c-2여서 의미없나
				}
				change = change - 2;// 배열크기넘으면 의미없다ㅏㅏ
			}
			perm(number, 0, 0, change);
			System.out.print("#" + tc + " " + max);
			System.out.println();
		}
	}

	static int cal(String[] arr) {// 1 2 3을 123으로 바꾸고 int로 parse
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}

	static void perm(String[] arr, int start, int cnt, int C) {
		if (cnt == C) { // C가 교환횟수
			if (max < cal(arr)) {
				max = cal(arr);
				String[] result = arr;
				if (flag) {
					if (sub % 2 == 1) {
						// 아까 저장해뒀던 sub(차) 가 홀수면 맨끝에 2자리만 swap
						swap(result, result.length - 2, result.length - 1);
						max = cal(result);
					}
				}
			}
		}
		for (int i = start; i < arr.length; i++) {
			swap(arr, i, start);
			perm(arr, start + 1, cnt + 1, C);
			if (arr[i] == arr[start]) {
				// 같은거라 바꿀필요없는 경우의 수도 있기때문(이렇게 해야 cnt가 정확함)
				// but 77770 같은 경우도 있기때문에 기존의 것도 돌리기
				perm(arr, start + 1, cnt, C);// 밑으로 빼도 됨!
				// 78466의경우
				// 기존의 것만 하면 87466 84766 84676 84667로 7만움직이고
				// 87???의 경우가 없으므로 이 경우를 위해 이것도 추가함
				// 기존의 것도 값만 얻는다면 돌아가지만 cnt가 안맞음
			}
			swap(arr, i, start);// 다시 돌려놓기
			// perm(arr, start + 1, cnt, C);//여기로 빼놔도됨!!!
		}
	}

	static void swap(String[] arr, int a, int b) {
		String tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}

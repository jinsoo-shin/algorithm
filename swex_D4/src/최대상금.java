import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대상금 {
	static int max;
	static boolean flag;
	static int sub;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
					sub = sub - change - 1; // 차 기억해두기
					break;
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
				perm(arr, start + 1, cnt, C);// 밑으로 빼도 됨!
			}
			swap(arr, i, start);// 다시 돌려놓기
		}
	}

	static void swap(String[] arr, int a, int b) {
		String tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}

import java.util.Arrays;

public class 조합순열 {

	public static void main(String[] args) {
		// nCr
		int[] arr = { 1, 2, 3, 4 };
		int N = arr.length;
		int r = 3;
		nCr(arr, N, r, 0, 0, new boolean[N]);
		nCrFornPr(arr, N, r, 0, 0, new boolean[N]);
	}

	static void nCr(int[] arr, int N, int r, int idx, int cnt, boolean[] flag) {// combination
		if (idx == N) {
			if (cnt == r) {
				System.out.print("조합 :");
				for (int i = 0; i < N; i++) {
					if (flag[i]) {
						System.out.print(arr[i] + " ");
					}
				}
				System.out.println();
			}
			return;
		}

		flag[idx] = true;
		nCr(arr, N, r, idx + 1, cnt + 1, flag);
		flag[idx] = false;
		nCr(arr, N, r, idx + 1, cnt, flag);

	}

	///////////////////////

	static void nCrFornPr(int[] arr, int N, int r, int idx, int cnt, boolean[] flag) {// combination
		if (idx == N) {
			if (cnt == r) {
				int[] newArr = new int[r];
				int tmpIdx = 0;
				for (int i = 0; i < N; i++) {
					if (flag[i]) {
						newArr[tmpIdx++] = arr[i];
					}
				}
				System.out.println("원본 :" + Arrays.toString(newArr));
				nPr(newArr, r, 0);
				// 여기에서 npr호출
			}
			return;
		}

		flag[idx] = true;
		nCrFornPr(arr, N, r, idx + 1, cnt + 1, flag);
		flag[idx] = false;
		nCrFornPr(arr, N, r, idx + 1, cnt, flag);

	}

	static void nPr(int[] arr, int r, int idx) {
		if (idx == r) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = idx; i < r; i++) {
			swap(arr, idx, i);
			nPr(arr, r, idx + 1);
			swap(arr, idx, i);
		}

	}

	static void swap(int[] arr, int a, int b) {

		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}

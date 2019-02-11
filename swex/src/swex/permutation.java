package swex;

import java.util.Arrays;

public class permutation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };

		boolean[] selected = new boolean[arr.length];

		// 부분집합에서 n개중 r개선택하기
		int[] sel = new int[3];
//		combination(arr, sel, 0, 0);

		// 부분집합
		int[] arr2 = new int[arr.length];
//		powersetSum(arr, 0, selected, arr2);

		// 모든 경우의 수
		perm(arr, 0, arr.length, arr.length);
		perm2(arr, 0, arr.length);
	}

	// n개중에 r개 선택하기!
	static void combination(int[] arr, int[] sel, int n, int r) {
		// n 인덱스
		//
		if (r == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (n == arr.length) {
			return;
		}
		combination(arr, sel, n + 1, r);

		sel[r] = arr[n];
		combination(arr, sel, n + 1, r + 1);
	}

	// 부분집합
	static void powersetSum(int[] arr, int idx, boolean[] selected, int[] arr2) {
		if (arr.length == idx) {
//			System.out.println(Arrays.toString(selected));
			System.out.println(Arrays.toString(arr2));
//			System.out.println(sum);
			return;
		}

		selected[idx] = false;
		arr2[idx] = 0;
		powersetSum(arr, idx + 1, selected, arr2);
		selected[idx] = true;
		arr2[idx] = arr[idx];
		powersetSum(arr, idx + 1, selected, arr2);

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void perm(int[] arr, int start, int n, int k)

	{
		if (start == k) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = start; i < n; i++) {
			swap(arr, i, start);
			perm(arr, start + 1, n, k);
			swap(arr, i, start);
		}
	}

	static void perm2(int[] arr, int start, int n)

	{
		if (start == n) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = start; i < n; i++) {
			swap(arr, i, start);
			perm2(arr, start + 1, n);
			swap(arr, i, start);
		}
	}
	
	// 순열
		static void perm3(int[] arr, int n) {
			if (arr.length == n) {
				System.out.println(Arrays.toString(arr));
				return;
			}

			for (int i = n; i < arr.length; i++) {// 123
				swap(arr, i, n); // 123 213 321
				perm3(arr, n + 1);//끝났으면 다시 뒤부터 돌기
				swap(arr, i, n); // 132 231 312
				
				
				//1234
				//2134
				//2314
				//2341 같은 느낌
			}

		}
}

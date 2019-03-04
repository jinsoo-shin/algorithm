
public class 이진탐색 {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 7, 10, 14, 17 };
//		int[] arr = { 9, 14, 17 };
		first = 0;
		last = 0;
		binary(arr, 0, arr.length - 1, 11, 2);
		System.out.println(first + " " + last);
	}

	static int first, last;

	static void binary(int[] arr, int start, int end, int find, int term) {

		int mid = (start + end) / 2;
		System.out.println(start + " " + mid + " " + end);
		if (start > end) {
			return;
		}
		if (start == mid || end == mid) {
			return;
		}
		if (arr[mid] - term <= find && find <= arr[end] + term) {
			first = mid;
			last = end;
			binary(arr, mid, end, find, term);
		} else if (arr[start] - term <= find && find <= arr[mid] + term) {
			first = start;
			last = mid;
			binary(arr, start, mid, find, term);
		}
	}
	// 사이에 있는 것을 찾는 이진탐색
//	static void binary(int[] arr, int start, int end, int find) {
//		
//		int mid = (start + end) / 2;
//		System.out.println(start + " " + mid + " " + end);
//		if (start > end) {
//			return;
//		}
//		if (start == mid || end == mid) {
//			return;
//		}
//		if (arr[mid] < find && find < arr[end]) {
//			first = mid;
//			last = end;
//			binary(arr, mid, end, find);
//		} else if (arr[start] < find && find < arr[mid]) {
//			first = start;
//			last = mid;
//			binary(arr, start, mid, find);
//		}
//	}

	// 평범한 이진탐색
//	static int binary(int[] arr, int start, int end, int find) {
//		
//		int mid = (start + end) / 2;
//		
//		System.out.println(start + " " + mid + " " + end);
//		if (start > end) {
//			return -1;
//		}
//		if (arr[mid] == find) {
//			return mid;
//		} else if (arr[mid] < find) {
//			return binary(arr, mid + 1, end, find);
//		} else {
//			return binary(arr, start, mid - 1, find);
//		}
//	}
}

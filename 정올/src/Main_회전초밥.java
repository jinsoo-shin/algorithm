import java.util.Arrays;
import java.util.Scanner;

public class Main_회전초밥 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int arr[] = new int[N + k];
		int check[] = new int[d + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}
		for (int i = 0; i < k; i++) {
			arr[N + i] = arr[i];
		}

		int count = 0;

		for (int i = 0; i < k; i++) {
			if (check[arr[i]] == 0)
				count++;
			check[arr[i]]++;
		}
		if (check[c] == 0)
			count++;
		check[c]++;
		int start = arr[0];

		int answer = count;
		for (int i = 0; i < N; i++) {

			check[start]--;
			if (check[start] == 0)
				count--;
			if (check[arr[i + k]] == 0)
				count++;

			check[arr[i + k]]++;

			start = arr[i + 1];

			if (answer < count)
				answer = count;

		}

		System.out.println(answer);

	}
}
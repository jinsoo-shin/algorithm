import java.io.*;
import java.util.*;

public class Solution_3131_3 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//1부터 100만 사이의 소수를 구해라!!!!
		boolean[] arr = new boolean[100];
//		boolean[] arr = new boolean[1000001];
		// 에라토스테네스 체??? 뭔가 그런이름이었음
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= 10; i++) {
			// 2의 배수 전부 제거 2빼고
			// 2의 배수를 true로 놓자. 마지막엔 false만 출력하기
			if (arr[i]) {
				continue;
			}
			for (int j = 2 * i; j < arr.length; j++) {// 앞에서부터 전부 돌자
				if (arr[j]) {
					continue;
				}
				if (j % i == 0 && j != i) {// 자기 자신은 제외 하면서 배수일때
					arr[j] = true;// 소수의 배수이다
					continue;
				}
			}
		}
		for (int i = 2; i < arr.length; i++) {
			if (!arr[i]) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());
	}
}

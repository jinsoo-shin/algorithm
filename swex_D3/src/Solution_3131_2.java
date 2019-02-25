import java.io.*;
import java.util.*;

public class Solution_3131_2 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//1부터 100만 사이의 소수를 구해라!!!!
		List<Integer> list = new LinkedList<>();
		for (int i = 2; i < 100; i++) {
			list.add(i);
		}

		// 에라토스테네스 체??? 뭔가 그런이름이었음
		// 2의 배수 전부 제거 2빼고
		int size = list.size();
		for (int i = 0; i < size; i++) {// 리스트 돌면서
			for (int j = 2; j < (int) Math.sqrt(100); j++) {// 소수들..? 돌면서
				if (list.get(i) != j && list.get(i) % j == 0) {
					list.remove(i);
					i--;
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb.toString());
	}
}

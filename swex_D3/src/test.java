import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class test {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			arr.add(i);
		}
		System.out.println(arr);

		for (int i = 0; i < 2; i++) {
			arr.add(3 + i, 7);
		}
		System.out.println(arr);

		for (int i = 0; i < 2; i++) {//삭제
			arr.remove(3);
		}
		System.out.println(arr);
		arr.add(11);
		System.out.println(arr);
	}
}

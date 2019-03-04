import java.io.*;
import java.util.*;

public class Main_포켓몬마스터1620 {
//	public class Main {
	// https://www.acmicpc.net/problem/1620
	public static void main(String[] args) throws Exception {
		String src = "26 5\r\n" + "Bulbasaur\r\n" + "Ivysaur\r\n" + "Venusaur\r\n" + "Charmander\r\n" + "Charmeleon\r\n"
				+ "Charizard\r\n" + "Squirtle\r\n" + "Wartortle\r\n" + "Blastoise\r\n" + "Caterpie\r\n" + "Metapod\r\n"
				+ "Butterfree\r\n" + "Weedle\r\n" + "Kakuna\r\n" + "Beedrill\r\n" + "Pidgey\r\n" + "Pidgeotto\r\n"
				+ "Pidgeot\r\n" + "Rattata\r\n" + "Raticate\r\n" + "Spearow\r\n" + "Fearow\r\n" + "Ekans\r\n"
				+ "Arbok\r\n" + "Pikachu\r\n" + "Raichu\r\n" + "25\r\n" + "Raichu\r\n" + "3\r\n" + "Pidgey\r\n"
				+ "Kakuna";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dogam = new String[N];
		for (int i = 0; i < N; i++) {
			dogam[i] = br.readLine();
		}
		Arrays.sort(dogam);
		System.out.println(Arrays.toString(dogam));
		String[] ans = new String[K];
		for (int i = 0; i < K; i++) {
			ans[i] = br.readLine();
		}
		System.out.println(findName(0, N - 1, "Beedrill"));
	}

	static String[] dogam;

	static int findName(int start, int end, String find) {
		System.out.println(start + " " + end + " " + find);
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		}
		if (dogam[mid].equals(find)) {
			System.out.println("ㅇㅇㅇ");
			return mid;
		} else {
			if (find.compareTo(dogam[mid]) < 0) {// find가 앞에있으면
				return findName(start, mid - 1, find);
			} else {// find가 뒤에있음!!
				return findName(mid + 1, end, find);
			}
		}
	}

}
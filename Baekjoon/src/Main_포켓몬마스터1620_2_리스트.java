import java.io.*;
import java.util.*;
//시간 뻥...
public class Main_포켓몬마스터1620_2_리스트 {
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
		List<String> dogam = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			dogam.add(br.readLine());
		}
		System.out.println(dogam);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			String tmp = br.readLine();
			if (Character.isDigit(tmp.charAt(0))) {
				sb.append(dogam.get(Integer.parseInt(tmp)) + "\n");
			} else {
				sb.append((dogam.indexOf(tmp)+1) + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}
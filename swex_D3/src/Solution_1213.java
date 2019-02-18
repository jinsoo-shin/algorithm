import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1213 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
//		String src = "1\r\n" + "ti\r\n"
//				+ "Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition\r\n";
		String src = "1\r\n" + "ing\r\n"
				+ "Thedoublehelixformsthestructuralbasisofsemi-conservativeDNAreplication.1,2Lessintuitively,italsohasimplicationsontheinformationcontentofDNAfordouble-strandedDNAassuchonlyhasabouthalfthestoragecapacityofsingle-strandedDNA.Thisisbecauseagivensequenceanditsreversecomplement,whilethesameinthedouble-strandedform,aredifferententitiesinsingle-strandedDNA?exceptforthosesequenceswhichareidenticaltotheirreversecomplement\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			String[] find = br.readLine().split("");
			String[] str = br.readLine().split("");
			check(find, str);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

	static void check(String[] find, String[] str) {
		int len = find.length;
		go: for (int i = 0; i < str.length - len + 1; i++) {

			if (str[i].equals(find[0])) {
				for (int j = 1; j < find.length; j++) {
					if (!str[i + j].equals(find[j])) {
						i = i + len - 2;
						continue go;
					}
				}
				ans++;
			}
		}
	}
}

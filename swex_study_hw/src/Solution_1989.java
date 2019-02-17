
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1989 {

	//거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문
	//단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "level\r\n" + "samsung\r\n" + "eye";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));


		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] str=br.readLine().split("");
			int ans=1;
			for(int i=0;i<str.length/2;i++) {
				if(!str[i].equals(str[str.length-i-1])) {
					ans=0;
					break;
				}
			}
			
			
			System.out.println("#" + tc + " "+ans);
		}
	}
}

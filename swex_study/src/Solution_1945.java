
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1945 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "10\r\n" + "6791400\r\n" + "1646400\r\n" + "1425600\r\n" + "8575\r\n" + "185625\r\n" + "6480\r\n"
				+ "1185408\r\n" + "6561\r\n" + "25\r\n" + "330750";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = { 2, 3, 5, 7, 11 };
			int[] ans=new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				int tmpN = N;
				while (true) {
					if(tmpN%arr[i]==0) {
						tmpN/=arr[i];
						ans[i]++;
					}else {
						break;
					}
				}
			}
			
			sb= new StringBuilder();
			sb.append("#" + tc );
			for(int i=0;i<arr.length;i++) {
				sb.append(" "+ans[i]);
			}
			System.out.println(sb.toString());
		}
	}
}

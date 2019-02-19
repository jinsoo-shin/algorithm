package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6900 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "4 4\r\n" + "*******1 1\r\n" + "******12 10\r\n" + "66*66**3 1000\r\n"
				+ "87654320 1000000\r\n" + "87654320\r\n" + "85288251\r\n" + "48888812\r\n" + "12345678";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());//당첨
			int M=  Integer.parseInt(st.nextToken());//복권수
			
			String[][] get=new String[N][2];
			int[] money= new int[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				get[i]=st.nextToken().split("");
				money[i]=Integer.parseInt(st.nextToken());
			}
			String[][] mynum=new String[M][8];
			for(int i=0;i<M;i++) {
				mynum[i]=br.readLine().split("");
			}
			
			
			int ans=0;
			for(int m=0;m<M;m++) {//복권수만큼 돌리기
				next:for(int n=0;n<N;n++) {//당첨번호!!
					for(int i=0;i<8;i++) {
						//일치하면 답에 더하기
						if(get[n][i].equals("*")) {
							continue;
						}
						if(!mynum[m][i].equals(get[n][i])) {//일치 ㄴㄴ
							continue next;
						}
					}
					ans+=money[n];
				}
			}
			
			System.out.println("#"+tc+" "+ans);
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(get[i])+" "+money[i]);
//			}
//			
//			for(String[] row:mynum)
//			System.out.println(Arrays.toString(row));
			
		}
	}
}

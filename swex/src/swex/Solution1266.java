package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1266 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "0 0 2 2\r\n" + "4\r\n" + "-1 -1\r\n" + "0 0\r\n" + "1 1\r\n" + "2 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		//직사각형 내부/ 네변중하나의 위/ 직사각형 외부
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int[][] square=new int[2][2];
			
			for(int i=0;i<2;i++) {
				square[i][0]=Integer.parseInt(st.nextToken());
				square[i][1]=Integer.parseInt(st.nextToken());
			}//직사격형 꼭지점 받아옴
			
			int N=Integer.parseInt(br.readLine());//점의 개수
			
			int out=0;//외부
			int in=0;//내부
			int line=0;//선위에
			
			
			for(int j=0;j<N;j++){
				st= new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				if(x>=square[0][0]&&x<=square[1][0]&&y>=square[0][1]&&y<=square[1][1]) {//내부에 있을때
					if(x==square[0][0]||x==square[1][0]||y==square[0][1]||y==square[1][1]) {
						line++;
					}else {
						in++;
					}
				}else {//밖!!!!!!!!
					out++;
				}
				
				
			}
			
			
			
			
			System.out.println(String.format("#%d %d %d %d", tc,in,line,out));
		}
	}

	static double cal(int n, double p, int r) {// p는 확률, r은 성공 횟수
		double nCr = 1;
		double tmpR = r;
		double tmpN = n;
		for (int i = 0; i < r; i++) {
			nCr *= tmpN-- / tmpR--;
		}
		return nCr * Math.pow(p, r) * Math.pow(1 - p, n - r);
	}
}

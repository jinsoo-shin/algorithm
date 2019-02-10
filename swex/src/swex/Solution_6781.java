package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6781 {

	static class Card {
		int num;
		String rgb;

		public Card(int num, String rgb) {
			super();
			this.num = num;
			this.rgb = rgb;
		}

		@Override
		public String toString() {
			return "Card [num=" + num + ", rgb=" + rgb + "]";
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getRgb() {
			return rgb;
		}

		public void setRgb(String rgb) {
			this.rgb = rgb;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		String str="1\r\n" + 
				"111223344\r\n" + 
				"RRRRRRRRR";
//		String str = "5\r\n" + "123345777\r\n" + "RRRRRRGGG\r\n" + "122344445\r\n" + "RRRRRRRRR\r\n" + "123444555\r\n"
//				+ "RRBRRRRRR\r\n" + "111345666\r\n" + "RRBGGGRRR\r\n" + "222333111\r\n" + "RGBRGBRGB";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(br.readLine());

		// 문자열길이 9

		// 같은 색에 같은 숫자거나 연속된 3수면 ok
		// 1~9 RGB 각각 4장씩 총 108장
		for (int tc = 1; tc <= T; tc++) {
			List<Card> card = new ArrayList<>();
			String[] tmpstr = br.readLine().split("");
			for (int i = 0; i < 9; i++) {
				Card c = new Card(Integer.parseInt(tmpstr[i]), "");
				card.add(c);
			}
			tmpstr = br.readLine().split("");
			for (int j = 0; j < tmpstr.length; j++) {
				card.get(j).setRgb(tmpstr[j]);
			}
//			for (int i = 0; i < card.size(); i++) {
//				System.out.println(card.get(i).toString());
//			}

			if (checktriple(card) >= 3) {
				System.out.println("#" + tc + " Win");
			} else {
				System.out.println("#" + tc + " Continue");
			}
		}
	}

	static int checktriple(List<Card> c) {
		int cnt = 0;
		int[] su1 = new int[10];// R빈도수 체크
		int[] su2 = new int[10];// G빈도수 체크
		int[] su3 = new int[10];// B빈도수 체크
		for (int i = 0; i < c.size(); i++) {
			if (c.get(i).getRgb().equals("R")) {
				su1[c.get(i).getNum()]++;
			} else if (c.get(i).getRgb().equals("G")) {
				su2[c.get(i).getNum()]++;
			} else if (c.get(i).getRgb().equals("B")) {
				su3[c.get(i).getNum()]++;
			}
		}
		System.out.println("su1 " + Arrays.toString(su1));
		System.out.println("su2 " + Arrays.toString(su2));
		System.out.println("su3 " + Arrays.toString(su3));
//		cnt += check1(su1) + check2(su1);
//		cnt += check1(su2) + check2(su2);
//		cnt += check1(su3) + check2(su3);
		
		cnt+=check1(su1)+check1(su2)+check1(su3);
		cnt+=check2(su1)+check2(su2)+check2(su3);
		System.out.println(cnt);

		return cnt;
	}

	static int check1(int[] arr) { // 1,1,1
		int cnt = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= 3) {
				arr[i] -= 3;
				cnt++;
			}
		}
		return cnt;
	}

	static int check2(int[] arr) {// 1,2,3
		int cnt = 0;
		for (int i = 1; i < arr.length - 2; i++) {
			if (arr[i] > 0 && arr[i + 1] > 0 && arr[i + 2] > 0) {
				arr[i]--;
				arr[i + 1]--;
				arr[i + 2]--;
				cnt++;
				i--;//한번더 검사용!
			}
		}
		return cnt;
	}
}

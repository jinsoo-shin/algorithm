
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1928 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		String src = "10\r\n" + "TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u\r\n"
//				+ "U3VzcGljaW9uIGZvbGxvd3MgY2xvc2Ugb24gbWlzdHJ1c3Qu\r\n"
//				+ "VG8gZG91YnQgaXMgc2FmZXIgdGhhbiB0byBiZSBzZWN1cmUu\r\n"
//				+ "T25seSB0aGUganVzdCBtYW4gZW5qb3lzIHBlYWNlIG9mIG1pbmQu\r\n"
//				+ "QSBmdWxsIGJlbGx5IGlzIHRoZSBtb3RoZXIgb2YgYWxsIGV2aWwu\r\n"
//				+ "QSBnaWZ0IGluIHNlYXNvbiBpcyBhIGRvdWJsZSBmYXZvciB0byB0aGUgbmVlZHku\r\n"
//				+ "Qm9va3MgYXJlIHNoaXBzIHdoaWNoIHBhc3MgdGhyb3VnaCB0aGUgdmFzdCBzZWFzIG9mIHRpbWUu\r\n"
//				+ "TGV0IHRoeSBzcGVlY2ggYmUgc2hvcnQsIGNvbXByZWhlbmRpbmcgbXVjaCBpbiBmZXcgd29yZHMu\r\n"
//				+ "VGhlIHdvcmxkIGlzIGEgYmVhdXRpZnVsIGJvb2ssIGJ1dCBvZiBsaXR0bGUgdXNlIHRvIGhpbSB3aG8gY2Fubm90IHJlYWQgaXQu\r\n"
//				+ "SGUgd2hvIHNwYXJlcyB0aGUgcm9kIGhhdGVzIGhpcyBzb24sIGJ1dCBoZSB3aG8gbG92ZXMgaGltIGlzIGNhcmVmdWwgdG8gZGlzY2lwbGluZSBoaW0u\r\n";
		String src = "1\r\n" + "TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			String num = br.readLine();
			char[] num4 = new char[4];
			sb = new StringBuilder();
			for (int i = 0; i < num.length() / 4; i++) {

				for (int j = 0; j < num4.length; j++) {
					num4[j] = num.charAt(j + i * 4);
				}

				sb.append(returnNum(num4));
				// 4씩 쪼갠다ㅏㅏㅏ
//				System.out.println(Arrays.toString(num4));
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}

	static String returnNum(char[] num4) {
		//4로 쪼개진 char 배열을 받아온다
//		num4 = { 'T', 'G', 'l', 'm' };

		String[] arr2 = new String[num4.length];
		//char하나하나를 6bit로 바꾼것을 저장하려는 arr2 배열!
		for (int i = 0; i < num4.length; i++) {
			int tmp0 = num4[i] - 0;
			if (tmp0 >= 97 && tmp0 <= 122) {// 소문자라면!!!!!!!
				tmp0 -= 71;
			} else if (tmp0 >= 48 && tmp0 <= 57) {// 숫자라면
				tmp0 += 4;
			} else {// 여기는 대문자
				tmp0 -= 65;
			}
			//위에는 char을 아스키코드의 숫자로 바꾸고
			//tmp0는 swex표에 맞는 숫자로 변환한것!
			
			String tmp = Integer.toBinaryString(tmp0); //swex표숫자를 2진수로 변환한것
			String tmp2 = "";
			for (int j = 0; j < 6 - tmp.length(); j++) {
				tmp2 = "0" + tmp2; 
				//tmp가 6이하의 자릿수가 있어서 그걸 6자리수로 만들기
			}
			tmp2 = tmp2 + tmp;
			arr2[i] = tmp2;
		} // 문자열을 6bit로 변환하기

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num4.length; i++) {
			sb.append(arr2[i]);
		}

//		System.out.println(sb.toString());
		String tmp3 = sb.toString();

		String[] arr3 = new String[3];
		for (int i = 0; i < 3; i++) {
			arr3[i] = tmp3.substring(0 + 8 * i, 8 + 8 * i);
		}
//		System.out.println(Arrays.toString(arr3));

		sb = new StringBuilder();
		for (int i = 0; i < arr3.length; i++) {
			int tmp333 = Integer.valueOf(arr3[i], 2);
			sb.append((char) tmp333);
//			System.out.println((char) tmp333);
//			System.out.println(Integer.valueOf(arr3[i], 2));
		}
//		System.out.println(sb.toString());
		return sb.toString();
	}

}

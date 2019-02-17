import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;import java.util.function.ToDoubleBiFunction;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		char[] arr= {'T','G','l','m'};
		
		String[] arr2=new String[arr.length];
		for(int i=0;i<arr.length;i++) {
			int tmp0=arr[i]-0-65;
			if(tmp0>=43) {//소문자라면!!!!!!!
				tmp0-=6;
			}
			String tmp=Integer.toBinaryString(tmp0);
			System.out.println(tmp0+"  tmp  "+tmp);
			String tmp2 = "";
			for(int j=0;j<6-tmp.length();j++) {
				tmp2="0"+tmp2;
			}
			tmp2=tmp2+tmp;
			System.out.println(tmp2);
			arr2[i]=tmp2;
		} //문자열을 6bit로 변환하기
		
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			sb.append(arr2[i]);
		}
		
		
		System.out.println(sb.toString());
		String tmp3=sb.toString();
		
		String[] arr3=new String[3];
		for(int i=0;i<3;i++) {
			arr3[i]=tmp3.substring(0+8*i,8+8*i);
		}
		System.out.println(Arrays.toString(arr3));
		
		for(int i=0;i<arr3.length;i++) {
			int tmp333=Integer.valueOf(arr3[i], 2);
			System.out.println((char)tmp333);
//			System.out.println(Integer.valueOf(arr3[i], 2));
		}
		
		
		
	}

}

import java.util.*;

public class 스택 {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();

		st.push(1);
		System.out.println("하나를 넣었음" + st);
		st.push(2);
		System.out.println("두개 넣었음" + st);

		int tmp= st.peek();
		System.out.println("꺼내진않고 맨위의 것을 보여줌"+tmp);
		System.out.println("두개 넣었음" + st);
		tmp = st.pop();
		System.out.println("꺼내진것" + tmp);
		System.out.println("2를 꺼냈다" + st);

	}

}

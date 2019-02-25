import java.util.*;

public class 큐 {
	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);// 넣는다
		q.peek();// 선두를 가져온다 큐가 비어있으면 null반환

		Queue<node> nq = new LinkedList<>();
		nq.offer(new node(10, 20));
		nq.offer(new node(20, 10));
		nq.offer(new node(30, 40));
		for (node n : nq) {
			System.out.println(n.a + " " + n.b);
		}
		System.out.println();
		find(nq, nq.peek());
		for (node n : nq) {
			System.out.println(n.a + " " + n.b);
		}
	}

	static void find(Queue<node> nq, node A) {//삭제한다
		for (node n : nq) {
			if (n.a == A.b) {
				System.out.println("갸아악..");
				nq.remove(n);
			}
		}

	}

	static class node {

		int a;
		int b;

		public node(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
}

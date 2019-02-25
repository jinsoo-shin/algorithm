import java.util.*;

public class 우선순위큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.offer(3);
		pq.offer(1);
		pq.offer(5);

		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		//우선순위 순으로 뽑아낸다ㅏㅏㅏ
		//3 1 5면 큐였으면 3 1 5순인데 
		//우선순위 큐는 1 3 5순이다

	}

}

import java.util.Scanner;

public class Solution_4043파이프5 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
//			String[][] map2 = new String[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//
//			for (String[] row : map2) {
//				System.out.println(Arrays.toString(row));
//			}
			ans = Integer.MAX_VALUE;
			////////////////////////////////////////
			boolean[][] visit = new boolean[N][N];
			// dir 위아래0 좌우1
			// 시작은 무조건 1이넹
			visit[N - 1][N - 1] = true;
			if (map[N - 1][N - 1] >= 3) {// 꺾인애라면
				bfs(new Cur(N - 2, N - 1, 0, 2, visit));

			} else if (map[N - 1][N - 1] >= 1) {// 일자라면..
				bfs(new Cur(N - 1, N - 2, 1, 2, visit));

			}
			// 오른쪽 진행방향 인 아이...

			// 만약 1,2라면 dxy 0 1탐색
			// 만약 아래방향으로 진행중이었다면 좌 우 탐색만 가능함
			// 만약 오른쪽 방향 진행중이었다면 위 아래만 탐색이 가능함..

			////////////////////////////////////////
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int N;
	static int ans;
	static int[][] map;
	static int[][] dxy = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 아래 위 // 왼쪽 오른쪽
	//
	static void bfs(Cur node) {
		LinkedListQueue<Cur> q = new LinkedListQueue<Cur>();
		int N = map.length;
		q.offer(node);
		node.visit[node.x][node.y] = true;

		// 0,1에서 시작함.
		while (!q.isempty()) {
			Cur tmp = q.poll();
			if (tmp.x == 0 && tmp.y == 0) {
//				System.out.println(tmp.dist + "도착" + tmp);
				ans = Math.min(tmp.dist, ans);
			}
//			System.out.println("방문장소" + map[tmp.x][tmp.y] + "-- " + tmp);
			// tmp의 진행방향 아래쪽0 이었냐 오른쪽 1 이냐
			// 만약 1,2라면
			// 만약 아래방향으로 진행중이었다면 좌 우 탐색만 가능함
			// 만약 오른쪽 방향 진행중이었다면 위 아래만 탐색이 가능함..
			if (tmp.dir == 0) {// 진행방향이 아래쪽이다
				if (map[tmp.x][tmp.y] >= 3) {// 3 4 5 6
					// 좌우만가능!!!
					for (int i = 2; i <= 3; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향 좌우다
							tmp.visit[cx][cy] = true;
							q.offer(new Cur(cx, cy, 1, tmp.dist + 1, tmp.visit));
						}
					}
				} else if (map[tmp.x][tmp.y] >= 1) {// 1 2
					// 위 아래로만 가자
					for (int i = 0; i <= 1; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향 위아래다
							tmp.visit[cx][cy] = true;
							q.offer(new Cur(cx, cy, 0, tmp.dist + 1, tmp.visit));
						}
					}
				}

			} else if (tmp.dir == 1) {// 진행방향이 오른쪽이다
				if (map[tmp.x][tmp.y] >= 3) {// 3 4 5 6
					// 위 아래로만 가자
					for (int i = 0; i <= 1; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향위 아래다
							tmp.visit[cx][cy] = true;
							q.offer(new Cur(cx, cy, 0, tmp.dist + 1, tmp.visit));
						}
					}
				} else if (map[tmp.x][tmp.y] >= 1) {// 1 2
					// 좌우로만 가자
					for (int i = 2; i <= 3; i++) {
						int cx = tmp.x + dxy[i][0];
						int cy = tmp.y + dxy[i][1];
						if (cx >= N || cy >= N || cx < 0 || cy < 0) {
							continue;
						}
						if (tmp.visit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] != 0) {// 이동방향 좌우다
							tmp.visit[cx][cy] = true;
							q.offer(new Cur(cx, cy, 1, tmp.dist + 1, tmp.visit));
						}

					}
				}

			}

		}

	}

	static class Cur {// 현재...?
		int x;
		int y;
		int dir;// tmp의 진행방향 아래쪽이었냐 오른쪽이냐
		int dist;
		boolean[][] visit = new boolean[N][N];

		public Cur(int x, int y, int dir, int dist, boolean[][] visit) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.dist = dist;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					this.visit[i][j] = visit[i][j];
				}
			}
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + ", dist= " + dist + "]";
		}

	}

	static class LinkedListQueue<T> {
		private Node head, tail;

		private class Node {
			T item;
			Node next;
		}

		public boolean isempty() {
			return head == null;
		}

		// 데이터의 추가는 tail 에 한다 (들어온 순서대로 줄을 세우는 셈)
		public void offer(T item) {
			Node oldlast = tail; // 기존의 tail 을 잠시 보관해두고
			tail = new Node(); // 새로운 tail 을 생성한다
			tail.item = item;
			tail.next = null;
			if (isempty())
				head = tail; // queue 가 비어있으면 head = tail 로 head 와 tail 이 같은 node 를 가리키게 한다
			else
				oldlast.next = tail; // queue 가 비어있지 않으면 기존 tail 의 next = 새로운 tail 로 해주면 된다
		}

		// 데이터 꺼내는 작업은 head 로 한다 (먼저 들어왔던 데이터부터 꺼낸다)
		public T poll() {
			// 비어있는 경우
			if (isempty()) {
				tail = head;
				return null;
			}
			// 비어있지 않으면
			else {
				T item = head.item; // head 의 데이터를 저장
				head = head.next; // 기존 head 다음 node (혹은 null) 를 head 로 설정해준다
				return item;
			}
		}

	}

}

import java.io.*;
import java.util.*;

public class Solution_1248조상 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "13 12 8 13\r\n" + "1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 10 6 11 11 13";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());// 정점
			int E = Integer.parseInt(st.nextToken());// 간선
			int A = Integer.parseInt(st.nextToken());// 조상찾기
			int B = Integer.parseInt(st.nextToken());// 조상찾기
			ans = 0;
			int[] arr = new int[V + 1];
			parents = new int[V + 1];
			rank = new int[V + 1];
			int[][] xy = new int[E][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= V; i++) {
				arr[i] = i;
				make(i);
			}
			set = new HashSet<>();
			listA = new ArrayList<>();
			list = new ArrayList[V + 1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				unionS(from, to);
				list[from].add(to);
			}

			findP(A);
			findP2(B);
			int p = 0;
//			System.out.println(list);
			for (int i = 0; i < listA.size(); i++) {
				if (set.contains(listA.get(i))) {
					p = listA.get(i);
					break;
				}
			}

			findChild(p);
			ans += 1;
			System.out.println("#" + tc + " " + p + " " + ans);
		}
	}

	static List<Integer>[] list;
	static int ans;
	static int[] parents;
	static int[] rank;
	static List<Integer> listA;
	static Set<Integer> set;

	static void make(int x) {// 자기자신이 부모
		parents[x] = x;
		rank[x] = 0;
	}

	static void findChild(int x) {
		ans += list[x].size();
		if (list[x].size() == 0) {
//			ans += 1;
		} else {
			for (int i = 0; i < list[x].size(); i++) {
				findChild(list[x].get(i));
			}
		}
	}

	static int findP(int x) {
		listA.add(x);
		if (parents[x] == x) {// 자기자신이 부모다
			return x;
		} else {
			x = parents[x];// 한칸위의 부모
			return findP(x);
		}
	}

	static int findP2(int x) {
		set.add(x);
		if (parents[x] == x) {// 자기자신이 부모다
			return x;
		} else {
			x = parents[x];// 한칸위의 부모
			return findP2(x);
		}
	}

	static void unionS(int x, int y) {
		rank[x]++;
		parents[y] = x;

	}

	static void union(int x, int y) {
		int cx = findP(x);
		int cy = findP(y);

//		System.out.println("부모" + cx + " " + cy);
		parents[cy] = cx;

	}
}

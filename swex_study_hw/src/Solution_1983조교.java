	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.StringReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.StringTokenizer;
	
	public class Solution_1983조교 {
	//	public class Solution {
		public static void main(String[] args) throws NumberFormatException, IOException {
			String src = "10\r\n" + "10 2\r\n" + "87 59 88\r\n" + "99 94 78\r\n" + "94 86 86\r\n" + "99 100 99\r\n"
					+ "69 76 70\r\n" + "76 89 96\r\n" + "98 95 96\r\n" + "74 69 60\r\n" + "98 84 67\r\n" + "85 84 91\r\n"
					+ "20 12\r\n" + "76 58 78\r\n" + "96 100 99\r\n" + "97 99 98\r\n" + "96 100 98\r\n" + "98 97 100\r\n"
					+ "57 67 77\r\n" + "75 99 63\r\n" + "84 81 79\r\n" + "99 99 98\r\n" + "85 74 88\r\n" + "87 98 85\r\n"
					+ "85 80 73\r\n" + "92 79 75\r\n" + "79 93 93\r\n" + "94 83 94\r\n" + "99 99 99\r\n" + "55 94 71\r\n"
					+ "90 89 77\r\n" + "98 100 98\r\n" + "98 99 98\r\n" + "30 12\r\n" + "76 88 86\r\n" + "100 89 91\r\n"
					+ "91 90 83\r\n" + "86 82 96\r\n" + "78 76 98\r\n" + "94 85 96\r\n" + "80 91 97\r\n" + "63 63 58\r\n"
					+ "97 100 99\r\n" + "95 76 89\r\n" + "97 88 96\r\n" + "76 76 96\r\n" + "89 82 99\r\n" + "62 95 83\r\n"
					+ "63 88 60\r\n" + "74 77 72\r\n" + "98 87 92\r\n" + "99 84 58\r\n" + "74 76 99\r\n" + "81 81 84\r\n"
					+ "79 100 72\r\n" + "97 88 98\r\n" + "97 94 98\r\n" + "96 66 74\r\n" + "87 89 87\r\n" + "69 73 95\r\n"
					+ "89 97 91\r\n" + "82 94 85\r\n" + "85 89 75\r\n" + "89 80 91\r\n" + "40 18\r\n" + "69 71 57\r\n"
					+ "92 83 95\r\n" + "100 97 100\r\n" + "97 96 99\r\n" + "98 94 89\r\n" + "53 84 83\r\n" + "80 96 81\r\n"
					+ "100 96 98\r\n" + "100 75 100\r\n" + "69 62 90\r\n" + "99 63 66\r\n" + "66 99 94\r\n" + "98 78 73\r\n"
					+ "97 95 91\r\n" + "86 85 89\r\n" + "76 85 90\r\n" + "98 96 96\r\n" + "94 96 100\r\n" + "62 60 84\r\n"
					+ "70 79 70\r\n" + "97 98 90\r\n" + "94 98 100\r\n" + "75 95 82\r\n" + "94 56 65\r\n" + "80 90 90\r\n"
					+ "97 97 100\r\n" + "93 86 79\r\n" + "93 96 87\r\n" + "100 93 93\r\n" + "79 90 79\r\n" + "88 77 95\r\n"
					+ "73 83 91\r\n" + "72 57 84\r\n" + "95 99 91\r\n" + "86 75 100\r\n" + "100 69 56\r\n" + "85 99 97\r\n"
					+ "100 96 100\r\n" + "98 99 98\r\n" + "79 96 91\r\n" + "50 43\r\n" + "83 61 74\r\n" + "96 83 84\r\n"
					+ "78 81 81\r\n" + "100 100 100\r\n" + "98 100 98\r\n" + "93 93 98\r\n" + "89 77 80\r\n"
					+ "98 99 99\r\n" + "99 100 74\r\n" + "91 76 72\r\n" + "100 71 70\r\n" + "70 84 55\r\n" + "71 99 96\r\n"
					+ "79 94 77\r\n" + "95 85 100\r\n" + "99 100 99\r\n" + "99 94 99\r\n" + "89 68 74\r\n" + "89 62 66\r\n"
					+ "66 88 78\r\n" + "96 98 100\r\n" + "93 54 94\r\n" + "96 89 94\r\n" + "96 76 65\r\n" + "99 99 99\r\n"
					+ "86 98 95\r\n" + "98 97 99\r\n" + "98 90 82\r\n" + "99 98 97\r\n" + "89 74 66\r\n" + "63 76 91\r\n"
					+ "86 93 78\r\n" + "88 83 94\r\n" + "97 96 96\r\n" + "98 89 90\r\n" + "90 62 66\r\n" + "83 74 74\r\n"
					+ "57 67 77\r\n" + "95 93 89\r\n" + "66 86 73\r\n" + "70 81 68\r\n" + "94 97 80\r\n" + "75 76 90\r\n"
					+ "89 80 98\r\n" + "94 99 98\r\n" + "97 93 94\r\n" + "86 100 92\r\n" + "92 69 68\r\n" + "100 99 95\r\n"
					+ "96 97 89\r\n" + "60 6\r\n" + "83 93 86\r\n" + "72 59 75\r\n" + "98 94 99\r\n" + "93 91 70\r\n"
					+ "78 79 89\r\n" + "91 99 95\r\n" + "71 83 83\r\n" + "71 96 74\r\n" + "97 83 69\r\n" + "97 94 97\r\n"
					+ "99 98 73\r\n" + "76 70 92\r\n" + "99 100 99\r\n" + "98 99 90\r\n" + "83 95 84\r\n" + "88 85 85\r\n"
					+ "90 81 74\r\n" + "96 98 99\r\n" + "92 94 89\r\n" + "76 90 81\r\n" + "95 68 69\r\n" + "100 99 99\r\n"
					+ "83 53 67\r\n" + "84 85 94\r\n" + "91 79 96\r\n" + "99 100 98\r\n" + "100 82 84\r\n" + "100 99 96\r\n"
					+ "83 76 92\r\n" + "89 97 78\r\n" + "99 95 100\r\n" + "99 82 92\r\n" + "100 85 85\r\n" + "67 100 80\r\n"
					+ "85 91 75\r\n" + "99 92 86\r\n" + "93 86 97\r\n" + "100 94 97\r\n" + "76 67 63\r\n" + "78 89 73\r\n"
					+ "68 88 100\r\n" + "78 88 94\r\n" + "93 79 96\r\n" + "93 100 89\r\n" + "90 57 70\r\n" + "97 98 99\r\n"
					+ "79 69 77\r\n" + "99 97 94\r\n" + "87 98 93\r\n" + "84 86 90\r\n" + "64 91 64\r\n" + "94 84 99\r\n"
					+ "100 100 100\r\n" + "74 88 94\r\n" + "93 73 68\r\n" + "82 64 74\r\n" + "97 99 98\r\n" + "82 99 80\r\n"
					+ "86 87 89\r\n" + "99 96 97\r\n" + "70 37\r\n" + "70 81 80\r\n" + "83 83 80\r\n" + "84 88 93\r\n"
					+ "92 96 95\r\n" + "98 59 76\r\n" + "88 81 74\r\n" + "93 91 98\r\n" + "99 100 99\r\n" + "81 89 82\r\n"
					+ "90 89 81\r\n" + "67 95 79\r\n" + "93 89 91\r\n" + "87 79 57\r\n" + "96 92 96\r\n" + "100 86 88\r\n"
					+ "97 100 92\r\n" + "77 100 87\r\n" + "86 90 73\r\n" + "100 100 99\r\n" + "97 96 91\r\n"
					+ "90 95 97\r\n" + "70 84 76\r\n" + "90 80 78\r\n" + "71 79 86\r\n" + "98 98 98\r\n" + "94 94 85\r\n"
					+ "86 91 85\r\n" + "93 96 96\r\n" + "90 70 73\r\n" + "94 99 98\r\n" + "81 86 78\r\n" + "94 96 69\r\n"
					+ "99 97 99\r\n" + "90 96 67\r\n" + "61 69 91\r\n" + "85 82 93\r\n" + "79 95 78\r\n" + "87 81 67\r\n"
					+ "98 75 68\r\n" + "84 60 71\r\n" + "93 89 93\r\n" + "72 73 81\r\n" + "90 89 80\r\n" + "100 96 98\r\n"
					+ "91 96 99\r\n" + "100 99 100\r\n" + "81 91 84\r\n" + "82 93 97\r\n" + "92 78 100\r\n"
					+ "97 100 97\r\n" + "95 86 89\r\n" + "95 100 94\r\n" + "97 94 91\r\n" + "78 80 82\r\n" + "87 100 83\r\n"
					+ "96 55 75\r\n" + "83 94 99\r\n" + "99 97 90\r\n" + "100 99 99\r\n" + "71 91 65\r\n" + "90 69 64\r\n"
					+ "99 98 99\r\n" + "88 98 87\r\n" + "89 90 99\r\n" + "100 97 98\r\n" + "94 99 100\r\n" + "86 98 88\r\n"
					+ "84 81 90\r\n" + "83 86 94\r\n" + "70 68 93\r\n" + "80 64\r\n" + "88 93 93\r\n" + "91 63 71\r\n"
					+ "88 93 99\r\n" + "93 87 94\r\n" + "83 74 97\r\n" + "86 88 87\r\n" + "91 97 78\r\n" + "68 63 82\r\n"
					+ "64 72 60\r\n" + "72 69 75\r\n" + "69 77 76\r\n" + "78 81 91\r\n" + "95 93 95\r\n" + "77 91 80\r\n"
					+ "82 92 84\r\n" + "73 99 72\r\n" + "99 100 100\r\n" + "99 98 98\r\n" + "95 98 98\r\n" + "87 95 100\r\n"
					+ "90 95 97\r\n" + "73 75 80\r\n" + "59 100 65\r\n" + "96 93 97\r\n" + "66 92 83\r\n" + "87 93 88\r\n"
					+ "67 91 75\r\n" + "83 76 87\r\n" + "87 91 86\r\n" + "73 71 92\r\n" + "85 98 83\r\n" + "91 91 85\r\n"
					+ "99 94 91\r\n" + "81 83 63\r\n" + "97 71 79\r\n" + "82 93 94\r\n" + "92 64 94\r\n" + "74 87 81\r\n"
					+ "93 97 98\r\n" + "82 82 94\r\n" + "95 98 93\r\n" + "77 76 82\r\n" + "72 81 88\r\n" + "100 100 99\r\n"
					+ "96 99 88\r\n" + "94 92 94\r\n" + "94 86 85\r\n" + "97 96 95\r\n" + "99 94 82\r\n" + "88 78 94\r\n"
					+ "69 81 83\r\n" + "81 72 70\r\n" + "83 65 78\r\n" + "68 70 96\r\n" + "100 99 100\r\n" + "91 68 89\r\n"
					+ "78 91 79\r\n" + "99 94 91\r\n" + "89 83 86\r\n" + "93 87 86\r\n" + "94 70 84\r\n" + "92 97 90\r\n"
					+ "75 95 74\r\n" + "76 83 93\r\n" + "88 86 100\r\n" + "96 95 89\r\n" + "69 69 89\r\n" + "93 91 98\r\n"
					+ "100 77 98\r\n" + "69 59 62\r\n" + "83 97 100\r\n" + "93 100 77\r\n" + "79 88 57\r\n" + "99 86 85\r\n"
					+ "77 93 80\r\n" + "96 100 97\r\n" + "83 94 88\r\n" + "88 93 98\r\n" + "94 90 84\r\n" + "97 79 72\r\n"
					+ "90 83\r\n" + "71 95 81\r\n" + "93 87 99\r\n" + "94 95 95\r\n" + "89 84 98\r\n" + "99 99 96\r\n"
					+ "77 77 91\r\n" + "95 76 71\r\n" + "74 78 98\r\n" + "95 97 96\r\n" + "85 71 77\r\n" + "74 97 95\r\n"
					+ "65 76 94\r\n" + "90 92 89\r\n" + "92 97 96\r\n" + "86 81 84\r\n" + "85 100 77\r\n" + "95 97 100\r\n"
					+ "96 98 97\r\n" + "87 62 54\r\n" + "87 80 65\r\n" + "99 95 76\r\n" + "84 79 90\r\n" + "83 64 59\r\n"
					+ "91 95 92\r\n" + "93 90 92\r\n" + "99 94 96\r\n" + "69 90 72\r\n" + "68 99 82\r\n" + "85 77 88\r\n"
					+ "99 98 98\r\n" + "85 99 96\r\n" + "93 97 95\r\n" + "81 93 97\r\n" + "85 98 94\r\n" + "100 95 97\r\n"
					+ "88 91 87\r\n" + "100 95 95\r\n" + "76 90 76\r\n" + "88 92 99\r\n" + "90 84 95\r\n" + "95 100 100\r\n"
					+ "99 99 99\r\n" + "97 98 96\r\n" + "52 73 92\r\n" + "89 87 82\r\n" + "69 67 84\r\n" + "84 83 79\r\n"
					+ "86 70 93\r\n" + "83 86 72\r\n" + "98 87 93\r\n" + "77 62 82\r\n" + "98 100 94\r\n" + "92 75 80\r\n"
					+ "92 66 100\r\n" + "88 93 94\r\n" + "88 81 91\r\n" + "77 82 76\r\n" + "76 94 87\r\n" + "92 71 99\r\n"
					+ "70 88 73\r\n" + "64 67 72\r\n" + "77 82 86\r\n" + "77 72 98\r\n" + "90 90 97\r\n" + "100 97 96\r\n"
					+ "79 86 81\r\n" + "65 63 80\r\n" + "94 70 84\r\n" + "90 84 96\r\n" + "100 85 96\r\n" + "95 89 99\r\n"
					+ "85 100 67\r\n" + "90 69 79\r\n" + "89 91 88\r\n" + "60 90 83\r\n" + "79 70 83\r\n" + "87 88 81\r\n"
					+ "92 82 100\r\n" + "88 79 91\r\n" + "92 85 98\r\n" + "99 99 100\r\n" + "55 96 53\r\n" + "96 78 100\r\n"
					+ "74 77 80\r\n" + "92 56 65\r\n" + "90 91 96\r\n" + "95 86 96\r\n" + "83 80 89\r\n" + "100 99 98\r\n"
					+ "100 100 100\r\n" + "100 14\r\n" + "96 81 80\r\n" + "80 95 62\r\n" + "92 86 78\r\n" + "96 94 95\r\n"
					+ "88 85 85\r\n" + "100 98 94\r\n" + "94 96 97\r\n" + "86 81 90\r\n" + "97 97 89\r\n" + "88 94 86\r\n"
					+ "87 99 94\r\n" + "91 91 94\r\n" + "77 84 85\r\n" + "97 97 94\r\n" + "73 77 90\r\n" + "63 90 85\r\n"
					+ "97 96 83\r\n" + "59 73 89\r\n" + "96 89 90\r\n" + "64 62 63\r\n" + "88 77 79\r\n" + "100 99 100\r\n"
					+ "92 90 94\r\n" + "94 94 90\r\n" + "96 83 96\r\n" + "99 99 97\r\n" + "92 73 71\r\n" + "96 81 98\r\n"
					+ "80 69 71\r\n" + "63 98 79\r\n" + "100 100 99\r\n" + "99 100 99\r\n" + "99 100 97\r\n"
					+ "97 68 53\r\n" + "80 86 85\r\n" + "86 94 82\r\n" + "96 88 98\r\n" + "73 98 96\r\n" + "97 97 95\r\n"
					+ "77 93 96\r\n" + "70 97 89\r\n" + "80 77 78\r\n" + "80 92 86\r\n" + "96 94 90\r\n" + "89 84 92\r\n"
					+ "75 69 68\r\n" + "90 90 70\r\n" + "96 92 92\r\n" + "99 100 98\r\n" + "98 93 98\r\n" + "84 83 82\r\n"
					+ "100 99 100\r\n" + "80 91 99\r\n" + "99 96 93\r\n" + "89 100 94\r\n" + "93 95 90\r\n" + "89 86 95\r\n"
					+ "95 98 98\r\n" + "58 91 71\r\n" + "75 79 99\r\n" + "83 89 70\r\n" + "96 92 97\r\n" + "62 98 97\r\n"
					+ "97 91 90\r\n" + "96 81 66\r\n" + "83 77 91\r\n" + "92 86 91\r\n" + "99 99 100\r\n" + "90 86 95\r\n"
					+ "96 76 78\r\n" + "92 98 74\r\n" + "90 88 90\r\n" + "58 81 66\r\n" + "96 94 85\r\n" + "100 92 93\r\n"
					+ "74 65 65\r\n" + "79 82 74\r\n" + "95 88 70\r\n" + "99 99 99\r\n" + "98 99 82\r\n" + "84 83 88\r\n"
					+ "59 87 100\r\n" + "95 88 94\r\n" + "86 85 94\r\n" + "97 70 71\r\n" + "82 77 91\r\n" + "95 90 94\r\n"
					+ "88 67 62\r\n" + "74 77 74\r\n" + "68 75 85\r\n" + "84 73 98\r\n" + "71 56 72\r\n" + "99 98 99\r\n"
					+ "93 96 98\r\n" + "59 75 89\r\n" + "70 72 59\r\n" + "97 59 79\r\n" + "90 90 94\r\n" + "92 99 86\r\n"
					+ "75 95 98\r\n" + "";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(src));
			StringTokenizer st;
	
			int T = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= T; tc++) {
				st = new StringTokenizer(br.readLine());
				String ans = "";
				int N = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken()) - 1;
				List<String> stu = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					int tmp = (Integer.parseInt(st.nextToken()) * 35 + Integer.parseInt(st.nextToken()) * 45
							+ Integer.parseInt(st.nextToken()) * 20) / 100;
					stu.add(String.valueOf(tmp));
	
				}
				String[] tmp = stu.toArray(new String[stu.size()]);
				Arrays.sort(tmp);
	//			System.out.println(stu);
	//			System.out.println(Arrays.toString(tmp));
				String[] score = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
				int to = N / 10;
	
				int score_idx = 0;
				int tmp_to = 0;
				for (int i = tmp.length - 1; i >= 0; i--) {
					if (tmp[i].equals(stu.get(K))) {
						ans = score[score_idx];
					}
					tmp_to++;
					if (tmp_to % to == 0) {
						score_idx++;
						tmp_to = 0;
					}
				}
				System.out.println("#" + tc + " " + ans);
			}
		}
	}

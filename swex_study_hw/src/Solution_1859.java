import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1859 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "1000\r\n" + "8153 9896 9022 7489 8399 607 6466 4432 1502 3968 8333 7475 3792 84 7010 9694 7328 7354 4712 8409 6480 2643 8121 1951 3492 4420 8197 8607 7925 2167 717 3438 9200 6986 6104 6483 3620 9806 881 6858 5559 6553 8502 3554 2962 2325 7435 9279 464 7327 2549 9832 6595 8200 8720 7658 639 9992 9130 6467 8989 7958 2581 6600 7466 1473 1929 9775 2581 9770 9455 3718 4628 6807 9335 1898 1552 6530 5811 9569 4148 3384 6954 8913 114 6315 3686 9334 382 1392 8326 1008 3553 962 4957 4850 8231 2061 1185 1588 4305 2980 7564 1890 52 8747 943 1740 7593 7469 7370 2516 443 6007 9525 3299 412 7163 6699 3571 8976 7455 2217 3590 9343 4427 3220 1342 4584 4239 4496 5875 2601 1258 1449 3377 40 7428 8238 2455 3517 1653 4433 1768 1957 7307 6456 6878 2977 5368 1999 4882 3541 1826 3764 3269 1401 2098 8698 6763 1515 5413 1495 6523 4571 206 8357 5904 3310 1410 5844 7611 7484 410 3559 9262 1394 8949 1107 8546 2737 7987 4979 2306 4685 9291 5542 6542 9134 1094 2751 2089 898 5729 212 9964 8297 1823 720 5297 2280 4917 4338 7176 8183 7965 5740 3541 9555 3 3316 8256 6013 7611 3974 4931 2024 9609 6176 304 1151 4199 9876 8825 8893 3939 3737 4374 8323 6846 5819 1154 5157 814 6343 1886 1197 3100 1856 1709 3879 5479 2461 3014 9123 9744 5400 7094 9447 9020 9152 3963 9674 7829 8984 9930 5322 6665 2646 9385 9191 1353 7605 7110 4453 3356 243 7694 1854 2297 3075 9831 974 8720 1837 695 9845 7154 1673 5306 7865 5524 952 1231 5329 2353 6331 5692 8027 3413 3081 8438 5063 9858 7358 266 7801 6095 8374 4807 5051 4868 9478 9809 1304 7007 2308 2992 4499 9650 1706 8399 7822 3698 1015 6381 7267 2282 237 7119 6111 9926 3444 9788 9826 9944 3702 1888 6944 5655 3521 4489 6946 1131 6616 2445 1654 4434 3522 4850 2683 2542 5226 741 2486 6101 9661 8532 6961 3568 1903 276 4758 9772 5766 3259 3224 5836 3741 2054 9018 6325 5395 6949 5925 5056 7850 6378 2711 9083 8184 9790 2559 5945 8345 268 2322 7501 555 8772 1785 6675 1312 8665 2321 4920 3696 2516 4857 7149 948 3807 4535 1591 6284 3082 1268 898 3674 841 939 9593 3717 6003 6334 2768 6471 965 1121 1083 9103 2366 1149 5732 5776 7488 2238 3064 2736 6773 8070 2122 1274 6632 1560 7455 4748 1880 6061 5889 6954 5320 2034 6733 6345 1090 9640 8212 3717 3135 8211 7037 1483 2144 8668 1778 256 4345 4127 6398 8808 9328 5758 4566 4591 6371 6076 5805 4964 9279 8370 3309 441 8329 8125 3429 661 5241 1166 4870 9394 4314 9513 901 2687 6748 6614 9965 4222 1122 5748 2234 8311 2997 2193 9838 3172 7006 803 3711 2547 9136 5442 8343 3431 7420 2923 5843 3239 6314 7903 8901 2622 8535 5777 8275 3321 2177 1404 6261 2972 4093 8747 1562 8237 1698 4271 4836 504 9420 5101 4743 5433 3897 1277 8110 8645 9487 3324 246 3889 5524 5243 4258 7961 8389 3581 789 4619 4688 6477 3899 4025 9913 6134 1920 3179 1065 8697 4727 1051 7706 763 2500 2471 1068 5652 3266 8850 52 8000 6319 5411 4456 6626 3115 7764 1380 5517 3757 9764 679 3801 8526 9990 2967 3604 475 2416 249 1406 2199 6557 8954 7355 1991 6539 6505 3637 5268 8254 1066 9736 428 4107 6932 5332 6786 2766 2868 8159 5418 9652 9768 1968 9710 9905 6965 1269 475 8460 6802 2638 4516 9806 3002 2159 6222 4423 9326 5906 6419 8505 4721 7875 3615 9755 5674 9458 8246 1111 6149 4997 7788 76 1378 2483 3211 7964 2485 9930 8577 5583 6228 7657 5135 6671 2685 8151 5195 1338 7581 9546 9903 8836 7801 8433 2359 1986 7193 7147 8119 2927 1528 5310 9747 9323 8294 6305 7798 9399 3654 1649 5020 714 8688 1088 7735 607 4464 6417 685 6565 5781 5166 4216 5885 8131 258 2437 6528 2337 1376 6454 7143 9580 6618 256 2049 322 2378 8413 3056 1016 6636 7788 7836 2149 114 8828 6254 6741 4767 164 7638 4966 2669 8270 8646 4542 9399 9368 9925 1235 7151 274 4350 9361 8473 1106 4782 4952 8142 6035 7337 2460 8059 4049 8709 6995 4847 4974 2381 3226 2224 3809 4943 3025 1527 8610 8495 2298 4655 5567 5698 5790 8778 9995 9908 9016 2300 2633 3650 2312 5582 8853 6097 8881 8620 6427 3925 9355 5240 5070 7050 4178 8133 6739 319 4533 5388 9299 5558 7720 122 861 7766 5922 1456 7601 8377 144 8882 8966 8046 7104 8009 6149 8696 2327 7585 8555 6413 4859 5963 8139 3591 4970 8860 7834 5911 6274 4876 145 3677 2214 5545 1743 609 8879 7937 3940 4782 4553 1531 9495 6817 6994 3471 8865 2590 3886 1593 7504 2172 1493 8954 9221 8132 3060 5623 982 4181 9064 3736 4365 2371 7894 4458 3175 1956 2310 4254 1429 6274 995 7816 126 3883 4364 6352 2715 9140 9335 180 2362 7874 4345 8612 8045 8607 6654 7221 6520 5211 4807 6703 6613 2552 6263 4351 8291 7725 8774 9542 4643 6181 3342 1719 9130 9629 3953 157 6803 3001 3040 8643 1338 6671 4773 906 3889 2778 7931 6678 5919 8952 8656 49 3547 1261 7434 951 7318 8430 7391 3993 7823 4503 1963 2346 4972 2406 3854 661 3031 989 5851 8228 5263 1412 7499 9178 819 2436 3672 571 4795 5549 1554 3967 9215 289 2925 6019 6141 2583 3969 119 5015 281 1993 7200 8835 518 3781 6616 5865 9920 8504 3545 7881 783 8490 214 2082 2285 1943 307 1164 9976 3933 3047 6095 3812 6978 8593 4714 8422 8797 9536 3565 9466 6936 26 5359 7181 581 4182 3144 4179 9589 6994 232 1794 6322 6333 4719 4246 2646\r\n" ;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long ans = 0;
			long N = Long.parseLong(br.readLine());
			long arr[] = new long[(int) N];
			st = new StringTokenizer(br.readLine());
			int i = 0;
			while (st.hasMoreTokens()) {
				arr[i++] = Long.parseLong(st.nextToken());
			}
			for (int j = arr.length - 1; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {// 앞이더크면 의미없다
					continue;
				} else {
					// 작은게 나올때까지 보관하기!
					long[] tmp = cal(arr, j, 0, 0);
					j = (int) (j - tmp[0]);
					ans += tmp[1];
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static long[] cal(long[] arr, int idx, int cnt, long sum) {
		long tmp = arr[idx];
		for (int i = idx - 1; i >= 0; i--) {
			if (tmp > arr[i]) {// 뒤가 더 크다!!!!
				sum += arr[i];
				cnt++;
			} else {
				break;
			}
		}

		long res = tmp * cnt - sum;
		long[] ret = { cnt, res };
		return ret;
	}

}

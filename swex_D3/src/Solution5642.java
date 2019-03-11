import java.util.Arrays;
import java.util.Scanner;

public class Solution5642 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t =1 ; t<=T;t++)
	{
		int N = sc.nextInt();
		int[] arr = new int[N];
		int totalmax = 0;
		for(int i = 0 ; i < N;i++)
		{
			arr[i] = sc.nextInt();
			if(totalmax < arr[i])
				totalmax = arr[i];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < N;i++)
		{
			int sum = arr[i];
			
			if(max < sum)
				max = sum;
			
			if(sum < 0)
				continue;
			
			for(int j = i+1;j < N;j++)
			{
				if(sum - arr[j] < totalmax*-1)
					break;
				
				sum += arr[j];
				
				if(max < sum)
				{
					max = sum;
				}
				
			}
		}
		System.out.println("#"+ t+ " " + max);
	}
}
}

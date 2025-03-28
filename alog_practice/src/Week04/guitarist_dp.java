package Week04;

import java.util.*;
import java.io.*;

public class guitarist_dp {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int V[] = new int[N];
		for(int i=0;i<N;i++) {
			V[i] = Integer.parseInt(st.nextToken());
//			System.out.println("V["+i+"]="+V[i]);
		}
		
		//dp_version 구현
		boolean[][] dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<=M;j++) {
				if(dp[i][j]) {
					if(j-V[i]>=0)
						dp[i+1][j-V[i]]=true;
					if(j+V[i]<=M)
						dp[i+1][j+V[i]]=true;
				}
			}
		}
		
		int result = -1;
		for(int j=M;j>=0;j--) {
			if(dp[N][j]) {
				result = j;
				break;
			}
		}
		System.out.println(result);
		
	}

}

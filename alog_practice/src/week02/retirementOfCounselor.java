package week02;

import java.io.*;
import java.util.StringTokenizer;

public class retirementOfCounselor{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int list[][] = new int[N][2];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int maxList[] = new int[N+2];
		maxList[N] = 0;
		for(int i=N-1;i>=0;i--) {
			if(i+list[i][0]<=N)
				maxList[i] = (maxList[i+1])>(maxList[i+list[i][0]]+list[i][1])?(maxList[i+1]):(maxList[i+list[i][0]]+list[i][1]);
			else
				maxList[i] = maxList[i+1];
					
		}
		System.out.println(maxList[0]);
	}

}

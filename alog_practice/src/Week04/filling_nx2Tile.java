package Week04;

import java.util.*;
import java.io.*;

public class filling_nx2Tile {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int result;
		if(n==1)
			result = 1;
		if(n==2)
			result = 2;
		
		int[] ways = new int[n+1];
		ways[1]=1;
		ways[2]=2;
		
		for(int i=3;i<=n;i++) {
			ways[i]=ways[i-1]+ways[i-2];
		}
		
		System.out.println(ways[n]);
	}

}

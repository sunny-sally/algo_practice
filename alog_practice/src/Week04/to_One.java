package Week04;

import java.util.*;
import java.io.*;

public class to_One {

	static int visited[] = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		System.out.println(toOne(X));

	}
	static int toOne(int x) {
		if(x==1)
			return 0;
		if(visited[x]>0)
			return visited[x];
		
		int divThree = (x % 3 == 0) ? toOne(x / 3) : Integer.MAX_VALUE;
		int divTwo = (x % 2 == 0) ? toOne(x / 2) : Integer.MAX_VALUE;
		int minusOne = toOne(x - 1);
		
		visited[x] = 1 + Math.min(minusOne, Math.min(divTwo, divThree));

		
		return visited[x];
	}

}

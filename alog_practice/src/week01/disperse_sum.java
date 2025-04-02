package week01;

import java.util.*;
import java.io.*;

public class disperse_sum {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<N;i++) {
			int sum=i;
			int newN = i;
			
			while(newN>0) {
				sum+=newN%10;
				newN/=10;
			}
			
			if(sum==N) {
				System.out.println(i);
				break;
			}
		}
 
	}

}

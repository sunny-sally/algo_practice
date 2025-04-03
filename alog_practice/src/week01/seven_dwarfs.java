package week01;

import java.util.*;
import java.io.*;

public class seven_dwarfs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 9;
		int hights[] = new int[n];
		int sumOfAll = 0;
		for(int i=0;i<n;i++) {
			hights[i] = Integer.parseInt(br.readLine());
			sumOfAll+= hights[i];
		}
		//System.out.println("sumOfAll= "+sumOfAll);
		//int a=0,b=0;
		int i=0, j=0;
		boolean cheak= false;
		for(;i<n;i++) {
			for(j=i+1;j<n;j++)
				if(sumOfAll-(hights[i]+hights[j])==100) {
					//System.out.println("i: "+i+", j: "+j);
					hights[i]=-1;
					hights[j]=-1;
					cheak=true;
					break;
				}
			if(cheak==true)
				break;
				
		}
		Arrays.sort(hights);
		//System.out.println("i: "+i+", j: "+j);
		for(int k=0;k<n;k++) {
			//System.out.println("k="+k);
			if(hights[k]!=-1)
				System.out.println(hights[k]);
		}
	}

}

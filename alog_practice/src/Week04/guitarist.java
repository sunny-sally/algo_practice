package Week04;

import java.util.*;
import java.io.*;

public class guitarist {

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
		System.out.println(find_maxV(V,S,0,M));
		
	}
	static int find_maxV(int[] V, int p,int n, int max) {
		if(n==V.length)
			return p;
		if(p-V[n]<0&&p+V[n]>max)
			return -1;
	
//		System.out.println("현재 p는 "+p);
		int minus_ver = -1;
		int plus_ver = -1;
		if(p-V[n]>=0) {
//			System.out.println(p+"-V["+n+"]("+V[n]+")="+(p-V[n]));
			minus_ver =  find_maxV(V,p-V[n],n+1,max);
//			System.out.println("p,"+V[n]+"의 "+"minus_ver="+minus_ver);
		}
		if(p+V[n]<=max) {
//			System.out.println(p+"+V["+n+"]("+V[n]+")="+(p+V[n]));
			plus_ver = find_maxV(V,p+V[n],n+1,max);
//			System.out.println("p,"+V[n]+"의 "+"plus_ver="+plus_ver);
		}
		return plus_ver>minus_ver?plus_ver:minus_ver;
	}

}

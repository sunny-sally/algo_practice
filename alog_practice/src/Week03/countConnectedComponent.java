package Week03;

import java.io.*;
import java.util.*;

public class countConnectedComponent {

	static ArrayList<Integer>[] al;
	static boolean[] visited;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++) al[i] = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			al[u].add(v);
			al[v].add(u);
		}
	
		//연결요소 구하기
		int count = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				dfs(i);
				count ++;
			}
		}
		
		System.out.println(count);
		
	}
 	static void dfs(int i) {
 		visited[i] = true;
 		for(int friend : al[i]) {
 			if(!visited[friend]) {
 				dfs(friend);
 			}
 		}
 	}
	

}

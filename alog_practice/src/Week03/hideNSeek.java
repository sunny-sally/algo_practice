package Week03;

import java.io.*;
import java.util.*;

public class hideNSeek {
	static int[] visited = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N,K));
		
	}
	static int bfs(int X,int K) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(X);
		visited[X] = 1;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current==K)
				return visited[current]-1;
			for(int next: new int[] {current-1,current+1,current*2}) {
				if(next>=0&&next<=100000&&visited[next]==0) {
					visited[next] = visited[current]+1;
					queue.offer(next);
				}
			}
		}
		return -1;
	}

}

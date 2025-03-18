package Week03;

import java.io.*;
import java.util.*;

public class DFSnBFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		//System.out.println(N+" "+M+" "+V);
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
		
		//그래프 생성
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A);
		}
		
		for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
		
		//**DFS**
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[N+1];
		stack.push(V);
		//System.out.println("graph[1]의 값: "+graph[1]);
		
		while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue; // 이미 방문한 노드라면 스킵

            visited[node] = true; 
            System.out.print(node + " ");

            // 정점 번호가 작은 순서대로 방문하기 위해 역순 삽입
            List<Integer> neighbors = graph[node];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int next = neighbors.get(i);
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
		System.out.println();
		
		//**BFS**
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N+1];
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			visited[node] = true;
			System.out.print(node+" ");
			
			for(int next : graph[node]) {
				if(!visited[next]) {
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
	}

}

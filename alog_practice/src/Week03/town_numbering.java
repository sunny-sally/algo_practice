package Week03;

import java.util.*;
import java.io.*;

public class town_numbering {

	static int [][]my_map;
	static boolean [][] visited;
	static int N;
//	static int[] di = {0, 0, -1, 1}; 
//    static int[] dj = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		my_map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			//StringTokenizer st = new StringTokenizer(br.readLine()); => 공백이 없어 오류 발생
			for(int j=0;j<N;j++) {
				my_map[i][j] = line.charAt(j)-'0'; //Integer.parseInt(st.nextToken());
				//System.out.print(my_map[i][j]+" ");
			}
			//System.out.println();
		}
		
		List<Integer> townSizes = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(my_map[i][j]==1&&!visited[i][j]) {
					int size = dfs(i,j);
					//System.out.println(size);
					townSizes.add(size);
				}
			}
		}
		
		Collections.sort(townSizes);
		System.out.println(townSizes.size());
		for(int size: townSizes) {
			System.out.println(size);
		}
		
		
	}
	 static int dfs(int i,int j) {
		visited[i][j] = true;
		int count =1;
		

		if(i-1>=0&&my_map[i-1][j]==1&&!visited[i-1][j])
			count+=dfs(i-1,j);
		if(i+1<N&&my_map[i+1][j]==1&&!visited[i+1][j])
			count+=dfs(i+1,j);
		if(j-1>=0&&my_map[i][j-1]==1&&!visited[i][j-1])
			count+=dfs(i,j-1);
		if(j+1<N&&my_map[i][j+1]==1&&!visited[i][j+1])
			count+=dfs(i,j+1);
//		for (int d = 0; d < 4; d++) {
//            int ni = i + di[d];
//            int nj = j + dj[d];
//
//            if (ni >= 0 && nj >= 0 && ni < N && nj < N) { 
//                if (my_map[ni][nj] == 1 && !visited[ni][nj]) {
//                    count += dfs(ni, nj);
//                }
//            }
//        }
		return count;
	}

}

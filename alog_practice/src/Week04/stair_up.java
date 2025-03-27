package Week04;

import java.io.*;
import java.util.*;

public class stair_up {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int stair_scores[] = new int[n+1];
		stair_scores[0] = 0;
		for(int i=1;i<=n;i++) {
			stair_scores[i] = Integer.parseInt(br.readLine());
			System.out.println("stair_scores["+i+"]: "+stair_scores[i]);
		}
		int visited[] = new int[n+1];
//		visited[0]=stair_scores[0];
//		visited[1]=stair_scores[1];
//		
		int count=0;  //count로 연속된 세 개의 계단을 모두 밟는지 확인
//		
		for(int i=2;i<=n;i++) {
			//앞서 세 개의 계단을 밟지 않았을 때
			if(count<3&&stair_scores[i]>stair_scores[i-1]){
				visited[i]=stair_scores[i]+visited[i-1];
				count++;
			} else {
				visited[i] = visited[i-1];
				count=0;
			}
			System.out.println("visited["+i+"]: "+visited[i]);
		}
//		for(int i=2;i<=n;i++) {
//			//앞서 세 개의 계단을 밟지 않았을 때
//			if(count<3&&visited[i-1]>visited[i-2]){
//				visited[i]=stair_scores[i]+visited[i-1];
//				count++;
//			} else {
//				visited[i] = stair_scores[i]+visited[i-2];
//				count=0;
//			}
//			System.out.println("visited["+i+"]: "+visited[i]);
//		}
//		System.out.println(visited[n]);
		

	}

}

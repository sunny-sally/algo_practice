package week01;

import java.util.*;
import java.io.*;
public class eureka {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트케이스 갯수 입력
		int T = Integer.parseInt(br.readLine());
		
		//삼각수 배열
		List<Integer> list = new ArrayList<>();
		list.add(null);
		
		for(int i=1;i*(i+1)<=2000;i++){
			int Tn = i*(i+1)/2;
			list.add(Tn);
			//System.out.println(i+","+Tn+": 성공");
		}
//		System.out.println(list);
		
		//tc개의 n값 받기
		int n[] = new int[T];
 		for(int tc=0;tc<T;tc++) {
			n[tc] = Integer.parseInt(br.readLine());
			
			boolean result = false;
	 		for(int i=1;i<list.size();i++) {
	 			for(int j=i+1;j<list.size();j++) {
	 				for(int k=j+1;k<list.size();k++) {
	 					if(list.get(i)+list.get(j)+list.get(k)==n[tc]) {
	 						result = true;
	 						//System.out.println("찾았다: "+i+" "+j+" "+k);
	 						break;
	 					}
	 				}
	 				if(result)
	 					break;
	 			}
	 			if(result)
	 				break;
	 		}
	 		
	 		System.out.println(result?1:0);
		}
 		

	}

}

package octChallenge.cycledCycles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	FileReader fr;
	BufferedReader br;

//	int[][] adjMat;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dijkstra obj = new Dijkstra();
		int[][] adjMat=obj.readFile("dijkstraData");
//		System.out.println(adjMat[114][189]);
/*		for(int i=0;i<Array.getLength(adjMat);i++) {

			for(int j=0;j<Array.getLength(adjMat);j++) {
				System.out.println(adjMat[i][j]);
				System.out.println(i + "-" + j);
			}			
		}
*/

		int A[] = obj.dijkstra(adjMat);
		int dest[] = {7,37,59,82,99,115,133,165,188,197};
		for(int i=0;i<Array.getLength(dest);i++) {
			System.out.println(A[dest[i]]);
		}

	}
	public int[] dijkstra(int adjMat[][]) {
		int n = Array.getLength(adjMat)-1;
		int[] X = new int[n+1];
		int[] V = new int[n+1];
		int[] A = new int[n+1];
		for(int i=0;i<=n;i++) {
			V[i]=1;X[i]=0;A[i]=0;
		}
		
		int terminate=1,now=1,cnt=0;
		X[now]=1;
		A[now]=0;
		int w = 1,min=999999, minInd=0;
		String status="none";
		while(true) {
			status="none";
			min=999999;
			for(int j=1;j<=n;j++) {
				if(X[j]==1) {
					now=j;
					for(int i=1;i<=n;i++) {
						if(adjMat[now][i]!=0 && i!=now) {
							status="ok";
							if(X[i]==0 && X[now]==1) {						 
								if(min > A[now]+adjMat[now][i]) {
									min=A[now]+adjMat[now][i];
									minInd=i;
								}
								
							}
						}
					}
					
				}
			}
//			if(status=="none") {
//				break;
//			}
			
			A[minInd]=min;
			X[minInd]=1;
//			System.out.println(cnt++ + ";" + terminate + ";" + minInd);
			now=minInd;
			terminate=1;
			for(int i=1;i<=n;i++) {
				if(X[i]==0) {
					terminate=0;
				}
			}
			if(terminate==1) {
				break;
			}
//			if(cnt==1000) {
//				break;
//			}
		}
		return A;
	}
	
	public int[][] readFile(String filename) {
		try {
			fr = new FileReader("/home/stark/Documents/Workspace/java/" + filename + ".txt");
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {		
			String i;
			
			List<String> fileList = new ArrayList<String>();
			
			while(true) {				
				i = br.readLine();
				if (i == null)
					break;
			
				fileList.add(i);
				

			}
			br.close();
			fr.close();
			
			int n = fileList.size();
//			System.out.println(n);
			int[][] adjMat= new int[n+1][n+1];
			int k=0;
			
			for(int j=0;j<n;j++) {
				k=0;
				for(String p:fileList.get(j).split("\t")) {
					
					if(k==0) {
						k=Integer.parseInt(p);
						adjMat[k][k] = 0;
						
					}
					else {
//					System.out.println(k);
					adjMat[Integer.parseInt(p.split(",")[0])][k]=Integer.parseInt(p.split(",")[1]);
					adjMat[k][Integer.parseInt(p.split(",")[0])]=Integer.parseInt(p.split(",")[1]);
					}
				}
			}
			
			return adjMat;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}

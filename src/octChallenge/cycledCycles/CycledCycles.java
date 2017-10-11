package octChallenge.cycledCycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;


class CycledCycles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		
		int nCases=in.nextInt();
		for(int c=0;c<nCases;c++) {
			String line1=in.nextLine();
			int n=Integer.parseInt(line1.split(" ")[0]);
			int q=Integer.parseInt(line1.split(" ")[1]);
			int nVert=0;
			
			String[] cycles=new String[n];
			for(int i=0;i<n;i++) {
				cycles[i]=in.nextLine();
				nVert=nVert+Integer.parseInt(cycles[i].split(" ")[0]);			
			}
			
			
			
			int[][] adjMat=new int[nVert+1][nVert+1];
			int prevLen=0;
			int len=0;
			int lenNow=0;
			int j=0;
			int jj=0;
			ArrayList<int[]> map=new ArrayList<int[]>();
			int tmp[];
			for(int i=0;i<n;i++) {
//				if(i!=0)
//					prevLen=Integer.parseInt(cycles[i-1].split(" ")[0]);
				lenNow=Integer.parseInt(cycles[i].split(" ")[0]);	
				jj=j+jj;
				len=lenNow+jj;
				tmp=new int[lenNow+1];
				for(j=0;j<lenNow;j++) {
					
					adjMat[j+jj+1][(j+1)%lenNow+jj+1]=Integer.parseInt(cycles[i].split(" ")[j+1]);
					adjMat[(j+1)%lenNow+jj+1][j+jj+1]=Integer.parseInt(cycles[i].split(" ")[j+1]);
					tmp[j+1]=j+jj+1;
					
				}
				map.add(tmp);
			}
			String cycleCon[];
			for(int i=0;i<n;i++) {
				cycleCon=in.nextLine().split(" ");
//				out.println(map.get(i)[Integer.parseInt(cycleCon[0])-1]+";"+map.get((i+1)%n)[Integer.parseInt(cycleCon[1])-1]);
				adjMat[map.get(i)[Integer.parseInt(cycleCon[0])]][map.get((i+1)%n)[Integer.parseInt(cycleCon[1])]]=Integer.parseInt(cycleCon[2]);
				adjMat[map.get((i+1)%n)[Integer.parseInt(cycleCon[1])]][map.get(i)[Integer.parseInt(cycleCon[0])]]=Integer.parseInt(cycleCon[2]);
			}
			
/*			for(int i=0;i<=nVert;i++) {
				for(int k=0;k<=nVert;k++) {
					out.print(adjMat[i][k]);
				}			
				out.println();
			}*/		
			
			String query[];
			int a,b;
			int A[];
			CycledCycles obj=new CycledCycles();
			for(int i=0;i<q;i++) {
				query=in.nextLine().split(" ");
				
				a=map.get(Integer.parseInt(query[1])-1)[Integer.parseInt(query[0])];
				b=map.get(Integer.parseInt(query[3])-1)[Integer.parseInt(query[2])];
				A=obj.dijkstra(adjMat, a,b);
				out.println(A[b]);
/*				int cnt=0;
				for(int z=0;z<A.length;z++) {
					if(A[z]==0)
						cnt++;
				}
				out.println("cnt:"+cnt);*/
			}
			
		}
		

		out.close();
	}
	public int[] dijkstra(int adjMat[][],int now, int dest) {
		int n = Array.getLength(adjMat)-1;
		int[] X = new int[n+1];
		int[] V = new int[n+1];
		int[] A = new int[n+1];
		for(int i=0;i<=n;i++) {
			V[i]=1;X[i]=0;A[i]=0;
		}
		
		int terminate=1,cnt=0;
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
			if(minInd==dest)
				break;
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

}
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public String nextLine() {
    	String in=null;
		try {
			in = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return in;
    }

}
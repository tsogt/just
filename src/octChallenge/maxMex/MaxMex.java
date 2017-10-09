package octChallenge.maxMex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class MaxMex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		int nCases=Integer.parseInt(in.next());
		String line1;
		int nSet;
		int k;
		String set[];
		int intSet[];
		MergeSort sort;
		int maxMex;
		int[] sortedSet;
		int j=0;
		int z=0;
		for(int c=0;c<nCases;c++) {
			line1=in.nextLine();
			nSet=Integer.parseInt(line1.split(" ")[0]);
			k=Integer.parseInt(line1.split(" ")[1]);
			set=in.nextLine().split(" ");
			intSet=new int[set.length];
			for(int i=0;i<set.length;i++) {
				intSet[i]=Integer.parseInt(set[i]);
			}
			sort=new MergeSort();
			sortedSet=sort.sort(intSet, intSet.length);
			maxMex=-1;
			
			
			z=0;
			j=0;
//			out.println(sortedSet[intSet.length-1]);
			for(j=0;j<sortedSet[intSet.length-1]+1;j++) {
				
				if(j!=sortedSet[z]) {
					if(k>0) {
						k--;
					}
					else {
						maxMex=j;
//						System.out.print("here:"+j);
						break;
					}
											
				}
				else {
					z++;
				}
				if(j==sortedSet[intSet.length-1]&&k==0) {
					maxMex=j+1;
					break;
//					out.println("here");
				}
				
			}
			j--;
			while(k>0) {
				k--;
				j++;
			}
			if(maxMex==-1) {
				maxMex=j+1;
//				out.println("here2");
				out.println(maxMex);
			}
			else			
				out.println(maxMex);
			
		}
		
		out.close();
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

class MergeSort {
/*	public static void main(String args[]) {
		MergeSort obj=new MergeSort();
		int arr[]= {4,2,3,1,10,11,1,2};
		arr=obj.sort(arr, arr.length);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}*/
	public int[] sort(int arr[],int n) {
		int[] A, B, C;
		if(n==1) {
			return arr;
		}
		A=sort(Arrays.copyOfRange(arr, 0, n/2),Arrays.copyOfRange(arr, 0, n/2).length);
		B=sort(Arrays.copyOfRange(arr, n/2, n),Arrays.copyOfRange(arr, n/2, n).length);
		C=merge(A,B,n);
		return C;
	}
	public int[] merge(int[] A, int[] B, int n) {
		int[] C=new int[n];
		int i=0,j=0;
		for(int k=0;k<n;k++) {
			if(i==A.length) {
				C[k]=B[j];j++;
			}
			else if(j==B.length) {
				C[k]=A[i];i++;
			}
			else {
				if(A[i]<B[j]) {
					C[k]=A[i];
					i++;
				}
				else {
					C[k]=B[j];
					j++;
				}
				
			}
				
		}
		return C;
	}

}

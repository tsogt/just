package octChallenge.magicArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



class MagicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		
		String[] line;
		int[] ingredients,ingSorted;
		int nIng;
		MagicArray obj;
		int nCases=in.nextInt();
		ArrayList<int[]> ingList=new ArrayList<int[]>();
		int nDishes;
		int lastMax, lastMin, secondMax, secondMin;
		int secondLast[];
		int tmp[];
		int diff;
		int k=0;
		int sum=0;
		for(int c=0;c<nCases;c++) {
			nDishes=in.nextInt();
			for(int i=0;i<nDishes;i++) {
				line=in.nextLine().split(" ");
				nIng=Integer.parseInt(line[0]);
				ingredients=new int[nIng];
				for(int j=0;j<nIng;j++) {
					ingredients[j]=Integer.parseInt(line[j+1]);
				}
				ingList.add(ingredients);
				
			}
			
			obj=new MagicArray();
			tmp=obj.findMax(ingList.get(nDishes-1));
			lastMax=tmp[1];
			lastMin=tmp[0];
			int now[]=ingList.get(nDishes-2);
			tmp=obj.findMax(now);
			secondMax=tmp[1];
			secondMin=tmp[0];
			
			if(Math.abs(lastMin-secondMax)>Math.abs(lastMax-secondMin)) {
				sum=sum+Math.abs(lastMin-secondMax)*(nDishes-1);
				for(k=0;k<now.length;k++) {
					if(now[k]==secondMax) {
						break;
					}
				}
				
				for(int i=nCases-3;i>=0;i--) {					
					tmp=obj.findMax(ingList.get(i));
					int which=0;
					if((now[k+1]-tmp[0])>(now[k+1]-tmp[1])) {
						sum=sum+Math.abs(now[k+1]-tmp[0])*(i+1);
						which=tmp[0];
					}						
					else {
						sum=sum+Math.abs(now[k+1]-tmp[1])*(i+1);
						which=tmp[1];
					}
						
					now=ingList.get(i);
					for(k=0;k<now.length;k++) {
						if(now[k]==secondMax) {
							break;
						}
					}
					
				}
			}
			
			long sum1=0,sum2=0;
			
			for(int i=0;i<nDishes-1;i++) {
					sum1=sum1+Math.abs(ingList.get(i)[ingList.get(i).length-1]-ingList.get(i+1)[0])*(i+1);
					sum2=sum2+Math.abs(ingList.get(i+1)[ingList.get(i+1).length-1]-ingList.get(i)[0])*(i+1);					
									
			}
			if(sum1>sum2)
				out.println(sum1);
			else
				out.println(sum2);
			ingList.clear();
			
		}
		out.close();

	}
	public int[] findMax(int arr[]) {
		int max=arr[0];
		int min=arr[0];
		int ret[]=new int[2];
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i])
				max=arr[i];
			if(min>arr[i]) 
				min=arr[i];			
		}
		ret[0]=min;
		ret[1]=max;
		return ret;
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

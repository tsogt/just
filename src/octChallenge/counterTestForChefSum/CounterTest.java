package octChallenge.counterTestForChefSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

class CounterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);		
		int nCases=in.nextInt();
		
		int random;
		int n;
		int a[];
		
//		for(int c=0;c<nCases;c++) {
		for(int c=0;c<nCases;c++) {
			n=in.nextInt();
//			n=c;
			if(n==100000) {
				a=new int[n];
				int rand=ThreadLocalRandom.current().nextInt(1,n-1);
				for(int i=0;i<n;i++) {

					if(i!=rand)
						random=ThreadLocalRandom.current().nextInt((int)(4294767295L/(n-1))-1,(int)(4294767295L/(n-1))+3);
					else {

						random=100000;
					}
						
					a[i]=random;
				}
				
			}
			else if(n%2==0) {
				
				a=new int[n];
				int rand=ThreadLocalRandom.current().nextInt(1,n-1);
				for(int i=0;i<n;i++) {

					if(i!=rand)
						random=ThreadLocalRandom.current().nextInt((int)(4294767295L/(n-1))+1,(int)(4294767295L/(n-1))+2);
					else {

						random=100000;
					}
						
					a[i]=random;
				}
				
			}
			else if(n!=99991&&n!=99999){
				
				a=new int[n];
				int rand=ThreadLocalRandom.current().nextInt(1,n-1);
				for(int i=0;i<n;i++) {

					if(i!=rand)
						random=ThreadLocalRandom.current().nextInt((int)(4294767295L/(n-1)),(int)(4294767295L/(n-1))+2);
					else {

						random=100000;
					}
						
					a[i]=random;
	/*				if(i==n-1)
						out.println(random);								
					else
						out.print(random+" ");*/
				}
				
			}
			else {
				a=new int[n];
				int rand=ThreadLocalRandom.current().nextInt(1,n-1);
				for(int i=0;i<n;i++) {

					if(i!=rand)
						random=ThreadLocalRandom.current().nextInt((int)(4294767295L/(n-1))+1,(int)(4294767295L/(n-1))+2);
					else {

						random=100000;
					}
						
					a[i]=random;
	/*				if(i==n-1)
						out.println(random);								
					else
						out.print(random+" ");*/
				}
				
			}

/*			CounterTest obj=new CounterTest();		
			out.println(obj.wrongSolver(a));
			out.println(obj.correctSolver(a));
*/			
			
			long sum=0;
			for(int j=0;j<n;j++) {
				out.print(a[j]+" ");
//				sum=sum+(long)a[j];
			}			
			out.println();
//			out.println(sum);
//			out.println(4294967295L-sum);

		}
		out.close();
	}
	int wrongSolver(int[] a) {
		int n = a.length;
		int prefSum[]=new int[n];
		int sufSum[]=new int[n];
		prefSum[0] = a[0];
		for (int i = 1; i < n; i++) {
			prefSum[i] = prefSum[i - 1] + a[i];
		}
		sufSum[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sufSum[i] = sufSum[i + 1] + a[i];
		}
		int mn = prefSum[0] + sufSum[0];
		int where = 1;
		for (int i = 1; i < n; i++) {
			int val = prefSum[i] + sufSum[i];
			if (val < mn) {
				mn = val;
				where = i + 1;
			}
		}
		return where;
	}
	int correctSolver(int[] a) {
		int n = a.length;
		long prefSum[]=new long[n];
		long sufSum[]=new long[n];
		prefSum[0] = a[0];
		for (int i = 1; i < n; i++) {
			prefSum[i] = prefSum[i - 1] + a[i];
		}
		sufSum[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sufSum[i] = sufSum[i + 1] + a[i];
		}
		long mn = prefSum[0] + sufSum[0];
		int where = 1;
		for (int i = 1; i < n; i++) {
			long val = prefSum[i] + sufSum[i];
			if (val < mn) {
				mn = val;
				where = i + 1;
			}
		}
		return where;
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


package octChallenge.balancedContest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class BalancedContest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		InputStream input=System.in;					
		InputReader in=new InputReader(input);
		
		OutputStream outputStream = System.out;
		
		PrintWriter out = new PrintWriter(outputStream);
		
		int nCases=Integer.parseInt(in.next());
		
		int n;
		int p;
		int level[];
		int[] solved;
		String[] outStr=new String[nCases];
		String line1,line2[];
		int z=0;
		for(int j=0;j<nCases;j++) {
			level=new int[2];
			line1=in.nextLine();
			
			
			n=Integer.parseInt(line1.split(" ")[0]);
			p=Integer.parseInt(line1.split(" ")[1]);
			line2=in.nextLine().split(" ");
			solved=new int[line2.length];
			for(int k=0;k<line2.length;k++) {
				solved[k]=Integer.parseInt(line2[k]);
			}
			
			for(int i=0;i<solved.length;i++) {
				if(solved[i]>=(int)p/2) {
					level[0]++;
				}
				else if(solved[i]<=(int)p/10) {
					level[1]++;
				}			
			}
			
			if(level[0]==1&&level[1]==2) {
				outStr[z++]="yes";
//				System.out.println("yes");
			}
				
			else {
				outStr[z++]="no";
//				System.out.println("no");
			}
				
			
		}
		
		for(int i=0;i<outStr.length;i++) {
			out.println(outStr[i]);
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
package octChallenge.cycledCycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CycledCycles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		String line1=in.nextLine();
		int n=Integer.parseInt(line1.split(" ")[0]);
		int q=Integer.parseInt(line1.split(" ")[1]);
		int nVert=0;
		String[] cycles=new String[n];
		for(int i=0;i<n;i++) {
			cycles[i]=in.nextLine();
			nVert=nVert+cycles[i].length()-1;			
		}
		int[][] adjMat=new int[nVert][nVert];
		int prevLen=0;
		for(int i=0;i<n;i++) {
			if(i!=0)
				prevLen=cycles[i-1].length();
			for(int j=0;j<cycles[i].length()-1;j++) {
				adjMat[j+prevLen][((j+1)%cycles[i].length()+1)-1]=Integer.parseInt(cycles[i].split(" ")[j+1]);
			}
		}
		
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
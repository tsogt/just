package octChallenge.chefGP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


class CHEFGP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CHEFGP obj=new CHEFGP();
		obj.sol1();
		
	}
	public void sol1() {
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		
		int nCases=in.nextInt();
		String[] line1;
		String[] line2;
		int x;
		int y;
		ArrayList<String> a;
		ArrayList<String> b;
		int n,asize,bsize;
		ArrayList<String> opt;
		int i=0;
		for(int c=0;c<nCases;c++) {
			line1=in.nextLine().split("");
			line2=in.nextLine().split(" ");
			x=Integer.parseInt(line2[0]);
			y=Integer.parseInt(line2[1]);
						
			a=new ArrayList<String>();
			b=new ArrayList<String>();
			n=line1.length;
			
			for(int j=0;j<n;j++) {
				if(line1[j].equals("a")) 
					a.add(line1[j]);			
				else if(line1[j].equals("b"))
					b.add(line1[j]);			
			}
			
			opt=new ArrayList<String>();
			
			if(a.size()*y>=b.size()*x) {
				opt.add("a");
				out.print("a");
				a.remove(0);
			}
			else {
				out.print("b");
				opt.add("b");
				b.remove(0);
			}
				
			
			while(a.size()!=0||b.size()!=0) {
				if(a.size()*y>=b.size()*x) {					
					i=1;
					for(;i<=x;i++) {
						if(opt.size()-i>=0) {
							if(!opt.get(opt.size()-i).equals("a")) {
//								out.println("here");
								break;
							}
														
						}
						else {
//							out.println("here1");
							break;
						}
							
					}
//					out.print(i);
					if(i==x+1) {
						if(b.size()!=0) {
							out.print("b");
							b.remove(0);
							opt.add("b");
						}
						else {
							out.print("*");
							opt.add("*");
						}
							
					}
					else {
						out.print("a");
						a.remove(0);
						opt.add("a");					
					}
						
				}
				else {
					i=1;
					for(;i<=y;i++) {
						if(opt.size()-i>=0) {
							if(!opt.get(opt.size()-i).equals("b"))
								break;						
						}
						else
							break;
					}
					if(i==y+1) {
						if(a.size()!=0) {
							out.print("a");
							a.remove(0);
							opt.add("a");
						}
						else {
							out.print("*");
							opt.add("*");
						}
							
					}
					else {
						out.print("b");
						b.remove(0);
						opt.add("b");					
					}
					
				}
				
			}
/*			for(String s:opt) {
				out.print(s);
			}*/
			opt.clear();
			a.clear();
			b.clear();
			out.println();			
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

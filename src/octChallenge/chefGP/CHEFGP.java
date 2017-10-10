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
		obj.sol2();
		
	}
	public void sol2() {
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		
		int nCases=in.nextInt();
		char[] line1;
		String[] line2;
		int x;
		int y;
		int n;
		char[] opt;
		int i=0,ia,ib,j=0;
		
		for(int c=0;c<nCases;c++) {
			line1=in.nextLine().toCharArray();
			line2=in.nextLine().split(" ");
			x=Integer.parseInt(line2[0]);
			y=Integer.parseInt(line2[1]);
						
			n=line1.length;
			ia=0;ib=0;
			for(j=0;j<n;j++) {
				if(line1[j]=='a') 
					ia++;			
				else
					ib++;			
			}
			
			int z=0;

			opt=new char[n*2];
			
			if(ia>=ib) {
				opt[z++]='a';				
//				out.print("a");
				ia--;
				
			}
			else {
				opt[z++]='b';
//				out.print("b");								
				ib--;
				
			}
				
			
			while(ia!=0||ib!=0) {
				if(ia>=ib) {										
					if(z>=x) {
						for(i=1;i<=x;i++) {							
							if(opt[z-i]!='a') {
								break;
							}																						
								
						}
						if(i==x+1) {
							if(ib!=0) {
//								out.print("b");
								ib--;							
								opt[z++]='b';
							}
							else {
//								out.print("*");
								opt[z++]='*';
								
							}
								
						}
						else {
//							out.print("a");
							ia--;
							opt[z++]='a';
												
						}
						
					}
					else {
//						out.print("a");
						ia--;
						opt[z++]='a';
											
					}
					
//					out.print(i);
						
				}
				else {
					if(z>=y) {	
						for(i=1;i<=y;i++) {
							if(opt[z-i]!='b')
									break;						
							
						}
						if(i==y+1) {
							if(ia!=0) {
//								out.print("a");
								ia--;
								opt[z++]='a';
								
							}
							else {
//								out.print("*");
								opt[z++]='*';
								
							}
								
						}
						else {
//							out.print("b");
							ib--;
							opt[z++]='b';
												
						}
						
					}
					else {
//						out.print("b");
						ib--;
						opt[z++]='b';
											
					}

					
				}
				
			}
			for(i=0;i<z;i++) {
				out.print(opt[i]);
			}
			out.println();			
		}
		out.close();		

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

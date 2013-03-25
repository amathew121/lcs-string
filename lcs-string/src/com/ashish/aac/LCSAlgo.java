package com.ashish.aac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCSAlgo {

	
	private int[][] c;
	//private String[][] b;
	String [][] lengthLCS(String X,String Y,int m,int n)
	{
		String[][] b = new String[m+1][n+1];
		int [][] c = new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			c[i][0]=0;
		for(int j=0;j<=n;j++)
			c[0][j]=0;
		for (int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(X.charAt(i-1)==Y.charAt(j-1)){
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]="tl";
				}
				else if (c[i-1][j] >= c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]="tp";
				}
				else{
					c[i][j]=c[i][j-1];
					b[i][j]="lf";
				}
				}
			}
		
		for(int i = 0;i<=m;i++){
			
			for(int j =0;j<=n;j++)
				System.out.print(c[i][j]+" "+b[i][j] +"\t");
			System.out.println();
		}
				
		return b;
					
	}
	void printLCS(String [][] b, String X,int i,int j)
	{
		if (i==0 || j==0)
			return;
		if (b[i][j]=="tl"){
			printLCS(b,X,i-1,j-1);
			System.out.print(X.charAt(i-1));
		}
		else if (b[i][j]=="tp"){
			printLCS(b,X,i-1,j);
		}
		else
			printLCS(b,X,i,j-1);
		
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		LCSAlgo lcs = new LCSAlgo();
		
		System.out.println("Enter X String");
		String X = br.readLine();
		System.out.println("Enter Y String");
		String Y = br.readLine();
		String b[][] = lcs.lengthLCS(X, Y, X.length(), Y.length());
		System.out.println("\nThe longest common subsequence is ");
		lcs.printLCS(b, X, X.length(), Y.length());
		
	}

}

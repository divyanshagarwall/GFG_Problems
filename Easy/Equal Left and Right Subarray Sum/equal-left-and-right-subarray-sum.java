//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int [] A = new int[N];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++)
				A[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			System.out.println(ob.equalSum(A, N));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int equalSum(int [] A, int N) {
		//Write your code here
		if(N==1){
	        return N;
	    }
	    
	    int lsum=0,rsum=0,ans=-1;
	    
	    for(int i=1;i<N;i++){
	        rsum+= A[i];
	    }
	    for(int i=1;i<N;i++){
	        lsum+=A[i-1];
	        rsum = rsum-A[i];
	        if(lsum==rsum){
	            ans = i+1;
	            break;
	        }
	    }
		return ans;
	}
}
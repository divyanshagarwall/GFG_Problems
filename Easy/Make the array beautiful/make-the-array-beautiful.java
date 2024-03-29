//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {

        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.makeBeautiful(arr);
            for (int e : res) out.print(e + " ");
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        if(arr.length==0){
            return new ArrayList<>();
        }
        if(arr.length==1){
            ArrayList<Integer> al=new ArrayList<>();
            al.add(arr[0]);
            return al;
        }
        Stack<Integer> st=new Stack<>();
        st.push(arr[0]);
        int i=1;
        
        while(i<arr.length){
            if(st.isEmpty()){
                st.push(arr[i]);
            }
            else if((st.peek()<0 && arr[i]<0) || (st.peek()>=0 && arr[i]>=0)){
                st.push(arr[i]);
            }
            else if((st.peek()<0 && arr[i]>=0) || (st.peek()>=0 && arr[i]<0)){
                st.pop();
            }
            i++;
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        } 
        Collections.reverse(res);
        return res;
    }
}

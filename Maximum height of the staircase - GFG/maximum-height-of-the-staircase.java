// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.maxStairHeight(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxStairHeight(int N) {
        // code here
        int i,sum=0;
        for(i=0;;i++)
        {
            sum+=i;
            if(sum>N)
                break;
        }
        return i-1;
    }
};
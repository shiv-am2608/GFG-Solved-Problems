// { Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
            if(n%i==0)
                return false;
        return true;
    }
    static String isSumOfTwo(int N){
        // code here
        int i=2,j=N-2;
        while(i<=j)
        {
            if(isPrime(i) && isPrime(j))
                return "Yes";
            i++;
            j--;
        }
        return "No";
        
    }
}
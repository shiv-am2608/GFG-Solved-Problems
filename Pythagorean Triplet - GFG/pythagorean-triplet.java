// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
        int max=Integer.MIN_VALUE;
        for(int i:arr)
            max=Math.max(i,max);
        int freq[]=new int[max+1];
        for(int i:arr)
            freq[i]++;
        for(int i=0;i<=max;i++)
        {
            if(freq[i]==0)
                continue;
            for(int j=0;j<=max;j++)
            {
                if(freq[j]==0 ||(i==j && freq[j]==1))
                    continue;
                int val=(int)Math.sqrt((i*i)+(j*j));
                if(val>max || val*val != (i*i)+(j*j))
                    continue;
                if(freq[val]>0)
                    return true;
            }
        }
        return false;
    }
}
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int p1[] = new int[2];
            int q1[] = new int[2];
            int p2[] = new int[2];
            int q2[] = new int[2];
            String S1[] = read.readLine().split(" ");
            p1[0] = Integer.parseInt(S1[0]);
            p1[1] = Integer.parseInt(S1[1]);
            q1[0] = Integer.parseInt(S1[2]);
            q1[1] = Integer.parseInt(S1[3]);
            String S2[] = read.readLine().split(" ");
            p2[0] = Integer.parseInt(S2[0]);
            p2[1] = Integer.parseInt(S2[1]);
            q2[0] = Integer.parseInt(S2[2]);
            q2[1] = Integer.parseInt(S2[3]);
            Solution ob = new Solution();
            int ans = ob.doIntersect(p1, q1, p2, q2);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean linear(int x[],int y[],int z[])
    {
        if(z[0]<=Math.max(x[0],y[0]) && z[0]>=Math.min(x[0],y[0])
        && z[1]<=Math.max(x[1],y[1]) && z[1]>=Math.min(x[1],y[1]))
            return true;
        return false;
    }
    int orientation(int x[],int y[],int z[])
    {
        int val=(y[1]-x[1])*(z[0]-y[0])-(z[1]-y[1])*(y[0]-x[0]);
        if(val==0)
            return 0;
        return val<0?1:2;
    }
    int doIntersect(int p1[], int q1[], int p2[], int q2[]) {
        // code here
        int o1=orientation(p1,q1,p2);
        int o2=orientation(p1,q1,q2);
        int o3=orientation(p2,q2,p1);
        int o4=orientation(p2,q2,q1);
        
        if(o1!=o2 && o3!=o4)
            return 1;
        
        if(o1==0 && linear(p1,q1,p2))
            return 1;
        
        if(o2==0 && linear(p1,q1,q2))
            return 1;
            
        if(o3==0 && linear(p2,q2,p1))
            return 1;
        
        if(o4==0 && linear(p2,q2,q1))
            return 1;
        
        return 0;
    }
};
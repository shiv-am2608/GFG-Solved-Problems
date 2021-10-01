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
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int presum[][]=new int[R+1][C];
        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                presum[i+1][j]=presum[i][j]+M[i][j];
        int rstart=0,rend=0,cstart=0,cend=0;
        int negx=0,negy=0;
        int minsum=Integer.MIN_VALUE,maxsum=-1;
        for(int rowstart=0;rowstart<R;rowstart++)
        {
            for(int row=rowstart;row<R;row++)
            {
                int sum=0;
                int curColStart=0;
                for(int col=0;col<C;col++)
                {
                    sum+=presum[row+1][col]-presum[rowstart][col];
                    if(sum<0)
                    {
                        if(sum>minsum)
                        {
                            minsum=sum;
                            negx=row;
                            negy=col;
                        }
                        curColStart=col+1;
                        sum=0;
                    }
                    else if(sum>maxsum)
                    {
                        maxsum=sum;
                        rstart=rowstart;
                        rend=row;
                        cstart=curColStart;
                        cend=col;
                    }
                }
            }
        }
        if(maxsum==-1)
            return minsum;
        return maxsum;
    }
};
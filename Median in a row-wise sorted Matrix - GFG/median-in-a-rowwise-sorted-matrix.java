// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findSmallerThanEqualTo(int arr[],int x)
    {
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]<=x)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
    int median(int matrix[][], int r, int c) {
        // code here     
        int freq=((r*c))/2;
        int min=matrix[0][0],max=matrix[0][c-1];
        for(int i=1;i<r;i++)
        {
            min=Math.min(min,matrix[i][0]);
            max=Math.max(max,matrix[i][c-1]);
        }
        while(min<=max)
        {
            int mid=(min+max)/2;
            int count=0;
            for(int i=0;i<r;i++)
                count+=findSmallerThanEqualTo(matrix[i],mid);
            if(count<=freq)
                min=mid+1;
            else
                max=mid-1;
        }
        return min;
    }
}
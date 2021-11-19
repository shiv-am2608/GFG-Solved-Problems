// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int idx=0;
    public void driver(int nums[],int low,int high,int ans[])
    {
        if(high<low)
            return;
        int mid=low+(high-low)/2;
        ans[idx]=nums[mid];
        idx++;
        driver(nums,low,mid-1,ans);
        driver(nums,mid+1,high,ans);
        
    }
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        idx=0;
        int ans[]=new int[nums.length];
        driver(nums,0,nums.length-1,ans);
        return ans;
    }
}
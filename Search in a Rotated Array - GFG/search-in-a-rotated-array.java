// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findIndex(int arr[],int left,int right)
    {
        if(left>right)
            return -1;
        int mid=right-(right-left)/2;
        if(mid>0 && arr[mid]<arr[mid-1])
            return mid;
        if(mid<arr.length-1 && arr[mid]>arr[mid+1])
            return mid+1;
        if(arr[mid]<arr[0])
            return findIndex(arr,left,mid-1);
        else
            return findIndex(arr,mid+1,right);
    }
    int findElement(int arr[],int left,int right,int key)
    {
        if(left>right)
            return -1;
        int mid=right-(right-left)/2;
        if(arr[mid]==key)
            return mid;
        if(arr[mid]>key)
            return findElement(arr,left,mid-1,key);
        else
            return findElement(arr,mid+1,right,key);
    }
    int search(int arr[], int l, int h, int key)
    {
        // Complete this function
        int pivot=findIndex(arr,0,arr.length-1);
        if(pivot==-1)
            return findElement(arr,0,arr.length-1,key);
        if(arr[pivot]<=key && key<=arr[arr.length-1])
            return findElement(arr,pivot,arr.length-1,key);
        return findElement(arr,0,pivot-1,key);
        
    }
}
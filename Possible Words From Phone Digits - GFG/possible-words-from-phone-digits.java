// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static void initialize(HashMap<Integer,String>hmap)
    {
        hmap.put(2,"abc");
        hmap.put(3,"def");
        hmap.put(4,"ghi");
        hmap.put(5,"jkl");
        hmap.put(6,"mno");
        hmap.put(7,"pqrs");
        hmap.put(8,"tuv");
        hmap.put(9,"wxyz");
    }
    static void recur(String str,HashMap<Integer,String>hmap,ArrayList<String>ans,int n,int arr[],int idx)
    {
        if(str.length()==n)
        {
            ans.add(str);
            return;
        }
        String curr=hmap.get(arr[idx]);
        for(int i=0;i<curr.length();i++)
        recur(str+curr.charAt(i),hmap,ans,n,arr,idx+1);
    }
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        HashMap<Integer,String>hmap=new HashMap<Integer,String>();
        initialize(hmap);
        ArrayList<String>ans=new ArrayList<String>();
        recur("",hmap,ans,N,a,0);
        return ans;
    }   
}



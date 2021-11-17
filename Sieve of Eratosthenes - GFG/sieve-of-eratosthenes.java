// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static void createSieve(int arr[],int N)
    {
        for(int i=2;i*i<=N;i++)
        {
            if(arr[i]==1)
                continue;
            for(int j=i*i;j<=N;j+=i)
                arr[j]=1;
        }
    }
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        int arr[]=new int[N+1];
        createSieve(arr,N);
        ArrayList<Integer>ans=new ArrayList<Integer>();
        for(int i=2;i<=N;i++)
            if(arr[i]==0)
                ans.add(i);
        return ans;
    }
}
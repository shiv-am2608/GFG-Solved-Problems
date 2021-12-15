// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Pair
{
    long data;
    int index;
    Pair(long x,int y)
    {
        data=x;
        index=y;
    }
}
class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Pair>q=new LinkedList<Pair>();
        for(int i=0;i<K-1;i++)
            if(A[i]<0)
                q.offer(new Pair(A[i],i));
        long ans[]=new long[N-K+1];
        int j=0;
        for(int i=K-1;i<N;i++)
        {
            if(A[i]<0)
                q.offer(new Pair(A[i],i));
            while(!q.isEmpty() && q.peek().index<=i-K)
                q.poll();
            if(q.isEmpty())
                ans[j]=0;
            else
                ans[j]=q.peek().data;
            j++;
        }
        return ans;
    }
}
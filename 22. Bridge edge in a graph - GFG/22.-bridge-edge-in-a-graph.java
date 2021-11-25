// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static void DFS(int src,ArrayList<ArrayList<Integer>>adj,boolean visited[])
    {
        visited[src]=true;
        for(int i:adj.get(src))
            if(!visited[i])
                DFS(i,adj,visited);
    }
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        boolean visited[]=new boolean[V];
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        DFS(c,adj,visited);
        if(!visited[d])
            return 1;
        return 0;
    }
}
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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void check(char grid[][],String word,ArrayList<int[]>res,int sx,int sy)
    {
        int x[]={-1,-1,-1,0,0,1,1,1};
        int y[]={-1,0,1,-1,1,-1,0,1};
        for(int dir=0;dir<8;dir++)
        {
            int k=1,idx=sx+x[dir],idy=sy+y[dir];
            while(k!=word.length())
            {
                if(idx<0 || idy<0 || idx>=grid.length || idy>=grid[0].length || grid[idx][idy]!=word.charAt(k))
                    break;
                k++;
                idx+=x[dir];
                idy+=y[dir];
            }
            if(k==word.length())
            {
                res.add(new int[]{sx,sy});
                return;
            }
        }
    }
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        ArrayList<int[]>res=new ArrayList<int[]>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==word.charAt(0))
                    check(grid,word,res,i,j);
            }
        }
        //System.out.println(res.size());
        int ans[][]=new int[res.size()][2];
        int k=0;
        for(int i[]:res)
        {
            ans[k][0]=i[0];
            ans[k][1]=i[1];
            k++;
        }
        return ans;
    }
}
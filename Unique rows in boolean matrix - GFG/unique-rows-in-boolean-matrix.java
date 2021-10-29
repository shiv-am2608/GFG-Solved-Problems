// { Driver Code Starts
import java.lang.Math;
import java.util.*;
class UniqueRows{
public static void main(String[] args)
 {  Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
			for(int i = 0;i<arr.size();i++){
			    ArrayList<Integer> demo = arr.get(i);
			    for(int j = 0;j<demo.size();j++){
			        System.out.print(demo.get(j)+" ");
			    }
			    System.out.print("$");
			}
			System.out.println();
		}
 }
}// } Driver Code Ends


/*Complete the given function*/
class TrieNode
{
    TrieNode arr[]=new TrieNode[2];
    boolean isPresent=false;
}
class GfG
{
    static void dfs(TrieNode root,ArrayList<Integer>res,ArrayList<ArrayList<Integer>>ans)
    {
        if(root==null)
            return;
        if(root.isPresent)
            ans.add(new ArrayList<Integer>(res));
        for(int i=1;i>=0;i--)
        {
            res.add(i);
            dfs(root.arr[i],res,ans);
            res.remove(res.size()-1);
        }
        
    }
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        //add code here.
        TrieNode root=new TrieNode();
        ArrayList<ArrayList<Integer>>ans=new ArrayList<ArrayList<Integer>>();
        for(int i[]:a)
        {
            TrieNode curr=root;
            ArrayList<Integer>res=new ArrayList<Integer>();
            for(int j:i)
            {
                res.add(j);
                if(curr.arr[j]==null)
                    curr.arr[j]=new TrieNode();
                curr=curr.arr[j];
            }
            if(!curr.isPresent)
                ans.add(res);
            curr.isPresent=true;
        }
        return ans;
    }
}
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
// { Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int histogram(int arr[])
    {
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        left[0]=-1;
        Stack<Integer>st=new Stack<Integer>();
        st.push(0);
        for(int i=1;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                left[i]=-1;
            else
                left[i]=st.peek();
            st.push(i);
        }
        st.clear();
        right[arr.length-1]=arr.length;
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                right[i]=arr.length;
            else
                right[i]=st.peek();
            st.push(i);
        }
        int max=-1;
        for(int i=0;i<arr.length;i++)
        {
            int area=arr[i]*(right[i]-left[i]-1);
            max=Math.max(max,area);
        }
        return max;
    }
    public int maxArea(int M[][], int n, int m) {
        // add code here
        int grid[][]=new int[n+1][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(M[i][j]==0)
                    grid[i+1][j]=0;
                else
                    grid[i+1][j]=grid[i][j]+M[i][j];
            }
        int max=-1;
        for(int i=0;i<n;i++)
            max=Math.max(max,histogram(grid[i+1]));
        return max;
    }
}
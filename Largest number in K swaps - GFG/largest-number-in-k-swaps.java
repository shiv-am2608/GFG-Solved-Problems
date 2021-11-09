// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}// } Driver Code Ends




class Solution
{
    //Function to find the largest number after k swaps.
    static String max;
    public static void permute(String str,int k,int start)
    {
        if(max.compareTo(str)<0)
            max=str;
        if(k==0)
            return;
        char ch[]=str.toCharArray();
        for(int i=start;i<str.length();i++)
        {
            int index=i;
            for(int j=i+1;j<str.length();j++)
            {
                if(ch[i]<ch[j])
                {
                    char temp=ch[j];
                    ch[j]=ch[index];
                    ch[index]=temp;
                    permute(String.valueOf(ch),k-1,start+1);
                    temp=ch[j];
                    ch[j]=ch[index];
                    ch[index]=temp;
                }
            }
        }
    }
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            max="-1";
            permute(str,k,0);
            return max;
        }
}
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static boolean backTrack(String str,ArrayList<String>words,HashMap<String,Boolean>hmap)
    {
        if(str.length()==0)
            return true;
        if(hmap.containsKey(str))
            return hmap.get(str);
        boolean ans=false;
        for(int i=1;i<=str.length();i++)
        {
            if(words.contains(str.substring(0,i)))
            {
                if(backTrack(str.substring(i),words,hmap))
                {
                    ans=true;
                    break;
                }
            }
        }
        hmap.put(str,ans);
        return ans;
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        HashMap<String,Boolean>hmap=new HashMap<String,Boolean>();
        return backTrack(A,B,hmap)?1:0;
    }
}
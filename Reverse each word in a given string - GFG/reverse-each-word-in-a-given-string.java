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
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {
        // your code here
        Stack<Character>st=new Stack<Character>();
        String res="",res2="";
        for(int i=0;i<S.length();i++)
            st.push(S.charAt(i));
        while(!st.isEmpty())
        {
            if(st.peek()=='.')
            {
                res=st.pop()+res2+res;
                res2="";
            }
            else
            res2+=st.pop();
        }
        res=res2+res;
        return res;
    }
}
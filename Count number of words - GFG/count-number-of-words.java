// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.countWords(S));
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countWords(String s) 
    { 
        // code here
        int count=0;
        for(int i=0;i<s.length();)
        {
            while(i<s.length())
            {
                if(s.charAt(i)=='\\')
                    i+=2;
                else if(s.charAt(i)==' ')
                    i++;
                else
                    break;
            }
            if(i>=s.length())
                return count;
            while(i<s.length() && (s.charAt(i)!='\\' && s.charAt(i)!=' '))
                i++;
             count++;
        }
        return count;
    }
} 
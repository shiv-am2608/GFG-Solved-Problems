// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        long count=0;
        HashMap<String,Integer>hmap=new HashMap<String,Integer>();
        int oc=0,zc=0,tc=0;
        hmap.put("0*0",1);
        for(int i=0;i<str.length();i++)
        {
            int digit=str.charAt(i)-'0';
            if(digit==0)
                zc++;
            else if(digit==1)
                oc++;
            else
                tc++;
            String key=(tc-oc)+"*"+(oc-zc);
            if(hmap.containsKey(key))
            {
                count+=hmap.get(key);
                hmap.put(key,hmap.get(key)+1);
            }
            else
                hmap.put(key,1);
        }
        return count;
    }
} 
// { Driver Code Starts
import java.util.*;
public class MSP
{	
    public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-- != 0)
		{
			int n=sc.nextInt();
			ArrayList<String> s = new ArrayList<String>(n);
			for (int i=0;i<n;i++)
			    s.add(sc.next());
			String tt;
			tt=sc.next();
			GfG g=new GfG();
			ArrayList<String> res =g.findMatchedWords(s, tt);
			Collections.sort(res);
			for (int i = 0;i < res.size();i++)
			    System.out.print(res.get(i)+" ");
			System.out.println();

		}
	}
}// } Driver Code Ends


/*Complete the provided function*/

class GfG
{
/* The function returns an array of strings 
present in the dictionary which matches
the string pattern.
You are required to complete this method */
public static String hash(String str)
{
    HashMap<Character,Integer>hmap=new HashMap<Character,Integer>();
    int count=0;
    String res="";
    for(int i=0;i<str.length();i++)
    {
        if(!hmap.containsKey(str.charAt(i)))
            hmap.put(str.charAt(i),count++);
        res+=hmap.get(str.charAt(i));
    }
    return res;
}
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
	    //add code here.
	    ArrayList<String>res=new ArrayList<String>();
	    String pat=hash(pattern);
	    for(String i:dict)
	    {
	        String mat=hash(i);
	        if(mat.equals(pat))
	            res.add(i);
	    }
	    return res;
	}
}
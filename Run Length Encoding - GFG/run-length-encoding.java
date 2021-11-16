// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
         //Your code here
        String ans="";
        int i=0,j=1;
        while(j<=str.length())
        {
            while(j<str.length()&&str.charAt(i)==str.charAt(j))
                j++;
            ans+=str.charAt(i)+String.valueOf(j-i);
            i=j;
            j++;
        }
        return ans;
	}
	
 }
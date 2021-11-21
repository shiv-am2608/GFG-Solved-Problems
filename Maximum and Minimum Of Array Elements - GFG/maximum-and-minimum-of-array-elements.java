import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
	    while(test-->0)
	    {
	        int n=sc.nextInt();
	        int min=Integer.MAX_VALUE;
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<n;i++)
	        {
	            int temp=sc.nextInt();
	            max=Math.max(max,temp);
	            min=Math.min(min,temp);
	        }
	        System.out.println(max+" "+min);
	    }
	 }
}
// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        Queue<Integer>pos=new LinkedList<Integer>();
        Queue<Integer>neg=new LinkedList<Integer>();
        for(int i:arr)
            if(i>=0)
                pos.offer(i);
            else
                neg.offer(i);
        boolean flag=true;
        int i=0;
        while(!pos.isEmpty() && !neg.isEmpty())
        {
            if(flag)
                arr[i]=pos.poll();
            else
                arr[i]=neg.poll();
            flag=!flag;
            i++;
        }
        while(!pos.isEmpty())
            arr[i++]=pos.poll();
        while(!neg.isEmpty())
            arr[i++]=neg.poll();
    }
}
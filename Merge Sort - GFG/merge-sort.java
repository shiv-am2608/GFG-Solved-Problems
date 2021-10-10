// { Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}


// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
        int arr1[]=new int[m-l+1];
        int arr2[]=new int[r-m];
        for(int i=l;i<=m;i++)
            arr1[i-l]=arr[i];
        for(int i=m+1;i<=r;i++)
            arr2[i-m-1]=arr[i];
        int k=l;
        int p=0,q=0;
        while(p<arr1.length && q<arr2.length)
        {
            if(arr1[p]<arr2[q])
            {
                arr[k]=arr1[p];
                p++;
                k++;
            }
            else
            {
                arr[k]=arr2[q];
                q++;
                k++;
            }
        }
        while(p<arr1.length)
            arr[k++]=arr1[p++];
        while(q<arr2.length)
            arr[k++]=arr2[q++];
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l>=r)
            return;
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}

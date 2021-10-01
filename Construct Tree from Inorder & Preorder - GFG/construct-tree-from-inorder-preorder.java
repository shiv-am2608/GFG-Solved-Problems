// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    static int pre=0;
    public static Node build(int inorder[],int preorder[],int inStart,int inEnd)
    {
        if(inStart>inEnd || pre>=preorder.length)
            return null;
        Node root=new Node(preorder[pre]);
        int idx=-1;
        for(int i=inStart;i<=inEnd;i++)
        {
            if(inorder[i]==preorder[pre])
            {
                idx=i;
                break;
            }
        }
        pre++;
        root.left=build(inorder,preorder,inStart,idx-1);
        root.right=build(inorder,preorder,idx+1,inEnd);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        pre=0;
        return build(inorder,preorder,0,n-1);
        
    }
}

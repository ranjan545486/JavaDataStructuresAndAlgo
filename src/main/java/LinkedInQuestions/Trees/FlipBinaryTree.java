package LinkedInQuestions.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by rmukherj on 7/30/16.
 * 1. Recursively traverse to the leftmost node.
 2. This becomes the NewRoot, and keep returning this value, up the chain.
 3. Make the following changes
 - CurrentRoot. Left.Left = CurrentRoot.Right
 - CurrentRoot.Left.Right = CurrentRoot
 - CurrentRoot.Left = CurrentRoot.Right = NULL
 */
public class FlipBinaryTree {

    static class BinaryTree{
        int data;
        BinaryTree left, right;

        public BinaryTree(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    /*
    1. Recursively traverse to the leftmost node.
    2. This becomes the NewRoot, and keep returning this value, up the chain.
    3. Make the following changes
        - CurrentRoot. Left.Left = CurrentRoot.Right
        - CurrentRoot.Left.Right = CurrentRoot
        - CurrentRoot.Left = CurrentRoot.Right = NULL
     */

    BinaryTree flipTree(BinaryTree root){
        if(root == null){
            return null;

        }

        if(root.left == null && root.right == null){
            return root;
        }

        BinaryTree newRoot = flipTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    //book solution
public BinaryTree flipTreeRecursive(BinaryTree root, BinaryTree left, BinaryTree right, BinaryTree newRoot){
    if(root == null){
        return newRoot;
    }

    newRoot = flipTreeRecursive(root.left, root, root.right, root.left==null?root:root.left);
    root.left = right;
    root.right = left;
    return newRoot;
}
    public int height(BinaryTree root){
        if (root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public void levelOrderNaiveApproach(BinaryTree root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            printLevels(root,i);
            System.out.println("");
        }
    }
    public void printLevels(BinaryTree root, int h){
        if(root==null) return;
        if(h==1) System.out.print(" " + root.data);
        else{
            printLevels(root.left,h-1);
            printLevels(root.right,h-1);
        }
    }


    public void levelOrderQueue(BinaryTree root){
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();

        int levelNodes =0;
        if(root==null) return;
        q.add(root);
        while(!q.isEmpty()){
            //levelNodes = q.size();
           // while(levelNodes>0){
                BinaryTree n = (BinaryTree)q.remove();
                System.out.print(" " + n.data);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
               // levelNodes--;
            //}
            //System.out.println("");
        }
    }

    private static void levelOrderTraversal(BinaryTree root) {
        BinaryTree temp;
        Queue<BinaryTree> q = new LinkedBlockingDeque<BinaryTree>();
        q.add(root);
        q.add(new BinaryTree(-1));
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data == -1) {
                System.out.println();
                if (!q.isEmpty())
                    q.add(new BinaryTree(-1));

            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }

    }


    /*

   class Node
      int data;
      Node left;
      Node right;
  */
//    void LevelOrder(Node root)
//    {
//        if(root == null){
//            return;
//        }
//
//        Queue q = (Queue)new LinkedList();
//        q.add(root);
//        while(!q.isEmpty()){
//            Node n = (Node)q.remove();
//            System.out.println(n.data + " ");
//            if(n.left!=null){
//                q.add(n.left);
//            }
//
//            if(n.right!=null){
//                q.add(n.right);
//            }
//        }
//    }

    public static BinaryTree Reverse(BinaryTree root){
        if(root == null){
            return null;
        }

        BinaryTree temp = root.left;
        root.left = Reverse(root.right);
        root.right = Reverse(temp);
        return root;
    }

    public static void main(String[] args){
//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.right = new BinaryTree(3);
//        tree.left.left = new BinaryTree(4);
//        tree.left.right = new BinaryTree(5);

//        tree.left.left.left = new BinaryTree(6);
//        tree.left.left.right = new BinaryTree(7);

//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(3);
//        tree.right = new BinaryTree(5);
//        tree.left.left = new BinaryTree(2);
//        tree.left.right = new BinaryTree(4);
//        tree.right.right = new BinaryTree(7);
//        // tree.right.left = new BinaryTree(30);
//        // tree.right.right = new BinaryTree(35);
//        tree.left.left.left = new BinaryTree(9);
//        tree.left.left.right = new BinaryTree(6);
//        tree.left.right.right = new BinaryTree(8);

        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);

        tree.left.left.left = new BinaryTree(6);
        tree.left.left.right = new BinaryTree(7);

        FlipBinaryTree bt = new FlipBinaryTree();
        //int h = bt.height(tree);
        //bt.levelOrderNaiveApproach(tree);
        //tree = Reverse(tree);
        tree = bt.flipTree(tree);
        //tree = inverse(tree);0
       // tree = flippityFlip(tree);
       // tree = bt.flipTreeRecursive(tree, null, null,null);
     //   bt.printLevels(tree, h);
       // bt.levelOrderNaiveApproach(tree);
       // bt.levelOrderQueue(tree);
        bt.levelOrderTraversal(tree);

    }



}

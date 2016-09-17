package LinkedInQuestions.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rmukherj on 8/22/16.
 */
public class MirrorBT {
    Node root;

    void mirror()
    {
        root = mirror(root);
    }

    Node mirror(Node node)
    {
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }
    public static TreeNode mirrorBinaryTreeIterative(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return root;

        TreeNode parent = root;
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);

        while(!treeStack.empty()){
            parent = treeStack.pop();

            TreeNode temp = parent.right;
            parent.right = parent.left;
            parent.left = temp;

            if(parent.right != null)
                treeStack.push(parent.right);
            if(parent.left != null)
                treeStack.push(parent.left);
        }
        return root;
    }
    public void mirrorIterativeUsingQueue() {
        Queue<Node> nodeQ = new LinkedList<Node>();
        nodeQ.add(root);
        while(!nodeQ.isEmpty()) {
            Node node = nodeQ.remove();
            if(node.left == null && node.right == null)
                continue;
            if(node.left != null && node.right != null) {
                Node temp = node.left;
                node.left = node.right;
                node.right = temp;
                nodeQ.add(node.left);
                nodeQ.add(node.right);
            }
            else if(node.left == null) {
                node.left = node.right;
                node.right = null;
                nodeQ.add(node.left);
            } else {
                node.right = node.left;
                node.left = null;
                nodeQ.add(node.right);
            }
        }
    }


    void inOrder()
    {
        inOrder(root);
    }

    /* Helper function to test mirror(). Given a binary
       search tree, print out its data elements in
       increasing sorted order.*/
    void inOrder(Node node)
    {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }
    /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        MirrorBT tree = new MirrorBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror();

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();

    }
}

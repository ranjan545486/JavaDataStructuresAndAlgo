package LinkedInQuestions.Trees;

import java.util.Scanner;

/**
 * Created by rmukherj on 8/22/16.
 * Swap operation: Given a tree and a integer, K, we have to swap the subtrees of all
 * the nodes who are at depth h, where h ∈ [K, 2K, 3K,...].

 You are given a tree of N nodes where nodes are indexed from [1..N] and it is
 rooted at 1. You have to perform T swap operations on it, and after each swap
 operation print the inorder traversal of the current state of the tree.

 Input Format: First line of input contains N, number of nodes in tree.
 Then N lines follow. Here each of ith line (1 <= i <= N) contains two integers, a b,
 where a is the index of left child, and b is the index of right child of ith node. -1
 is used to represent null node. Next line contain an integer, T. T
 hen again T lines follows. Each of these line contains an integer K.
 */
public class SwapSubTreesAtDepthH {
    public static final int ROOT_NODE = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int N = s.nextInt();
        int[][] tree = new int[N+ROOT_NODE][2];

        for (int i = ROOT_NODE; i < N+ROOT_NODE; i++) {
            for (int j = 0; j < 2; j++) {
                tree[i][j] = s.nextInt();
            }
        }

        int numDepths = s.nextInt();
        for (int i = 0; i < numDepths; i++) {
            swap(tree, ROOT_NODE, s.nextInt(), 1);
            System.out.println();
        }
    }

    public static void swap(int [][] tree, int node, int targetDepth,
                            int depth) {
        if(node == -1) return;

        if(depth % targetDepth == 0) {
            int temp = tree[node][0];
            tree[node][0] = tree[node][1];
            tree[node][1] = temp;
        }
        swap(tree, tree[node][0], targetDepth, depth+1);
        System.out.print(Integer.toString(node) + " ");
        swap(tree, tree[node][1], targetDepth, depth+1);
    }
}

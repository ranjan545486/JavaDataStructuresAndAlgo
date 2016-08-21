package LinkedInQuestions.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rmukherj on 8/10/16.
 */
public class BTIsBST {

    private boolean isValidBST(Node node, int MIN, int MAX) {
        if(node == null)
            return true;
        if(node.data > MIN
                && node.data < MAX
                && isValidBST(node.left, MIN, node.data)
                && isValidBST(node.right, node.data, MAX))
            return true;
        else
            return false;
    }

    boolean checkBST(Node root) {
        return isValidBST(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);

    }

    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isMonotonicIncreasing(root);
    }
    private boolean isMonotonicIncreasing(TreeNode p) {
        if (p == null) return true;
        if (isMonotonicIncreasing(p.left)) {
            if (prev != null && p.data <= prev.data) return false;
            prev = p;
            return isMonotonicIncreasing(p.right);
        }
        return false;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rightMost = root;
        int depth = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null) break;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            if (node == rightMost) {
                depth++;
                rightMost = (node.right != null) ? node.right : node.left;
            }
        }
        return depth;
    }
}

package LinkedInQuestions.Trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rmukherj on 8/22/16.
 * Given a binary tree, compute the min depth of a leaf node
 */
public class MinDepthBTLeaf {
    // 'static' here ensures that each 'Node' does not cache a reference to
    // 'Tree'.
    private static class Node {

        int  datum;
        Node left;
        Node right;

        Node(final int datum) {
            this.datum = datum;
        }
    }

    // Keeping the root final is not a good idea:
    // You have to deal somehow with zero size trees.
    private /*final*/ Node root;

    // It is odd to have a constructor which accepts only one single element.
    // Accept none or arbitrary amount of initializers.
    public MinDepthBTLeaf(final int[] data) {
        for (final int datum : data) {
            insert(datum);
        }
    }

    // This is a matter of taste, but I prefer to use a singular form, which
    // for word "data" is "datum". The 'final' keyword would not hurt either.
    // This way you ensure that you cannot involuntarily assign to
    // variables that should not be assigned to.
    public void insert(final int datum) {
        if (root == null) {
            root = new Node(datum);
            return;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            current = datum < current.datum ?
                    current.left :
                    current.right;
        }

        if (datum < parent.datum) {
            parent.left = new Node(datum);
        } else {
            parent.right = new Node(datum);
        }
    }

    public int getMinDepth() {
        return getMinDepth(root);
    }

    private int getMinDepth(final Node root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int minLeft = Integer.MAX_VALUE;

        if (root.left != null) {
            minLeft = getMinDepth(root.left);
        }

        int minRight = Integer.MAX_VALUE;

        if (root.right != null) {
            minRight = getMinDepth(root.right);
        }

        return Math.min(minLeft, minRight) + 1;
    }

    public int getMinDepthBFS() {
        if (root == null) {
            // Let us define that the depth (height) of an empty tree is -1.
            // 0 is for the tree with only one node.
            return -1;
        }

        final Deque<Node> queue = new LinkedList<>();
        int depth = 0;

        Node endOfLevel = root;
        queue.add(root);

        for (;;) {
            final Node current = queue.poll();

            // Reached the closest leaf.
            if (current.left == null && current.right == null) {
                return depth;
            }

            // Expand the left node.
            if (current.left != null) {
                queue.addLast(current.left);
            }

            // Expand the right node.
            if (current.right != null) {
                queue.addLast(current.right);
            }

            // If 'current' has child nodes, they were added above,
            // the 'queue' cannot be empty. Otherwise, we would have reached
            // a leaf node, and thus terminate.
            if (current == endOfLevel) {
                // We just finished a tree level.
                // Choose the new level terminator and increment depth.
                endOfLevel = queue.getLast();
                ++depth;
            }
        }
    }
}

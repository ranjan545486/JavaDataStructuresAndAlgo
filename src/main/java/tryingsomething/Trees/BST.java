package tryingsomething.Trees;

import java.util.HashMap;

/**
 * Created by rmukherj on 9/17/16.
 */
public class BST {

    class Node{
        int key;
        Node left, right;

        Node(int key){
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    BST(){
        root = null;
    }

    void insert(int key){
        root = insertRecords(root, key);
    }

    public Node insertRecords(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key<root.key){
            root.left = insertRecords(root.left, key);

        } else if(key>root.key){
            root.right = insertRecords(root.right, key);
        }

        return root;
    }


    int inorder(HashMap<Integer, Integer> map){
        return inOrderRec(root, map);
    }

    public int inOrderRec(Node root, HashMap<Integer, Integer> map){
        if(root != null){
            inOrderRec(root.left, map);
            if(root.key<Integer.MIN_VALUE || root.key>Integer.MAX_VALUE){
                return 0;
            } else if(!map.containsValue(root.key)){
                return 0;
            }

            inOrderRec(root.right, map);
        }

        return 1;
    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        BST bst = new BST();
        map = new HashMap<>();
        bst.insert(50);;
        map.put(0,50);
        bst.insert(30);
        map.put(1,30);
        System.out.println(bst.inorder(map));

    }

}

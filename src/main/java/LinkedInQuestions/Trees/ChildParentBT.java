package LinkedInQuestions.Trees;


import java.util.*;

/**
 * Created by rmukherj on 8/20/16.
 */

class Relation{
    public Integer parent;
    public Integer child;
    public boolean isLeft;
    public Relation(int child, int parent, boolean isLeft) {
        this.parent = parent;
        this.child = child;
        this.isLeft = isLeft;
    }
}


public class ChildParentBT {

    public static Node buildTreeUsingQueue (List<Relation> data) {
        if (data == null) {
            return new Node();
        }

        Node root = new Node();
        int children = 0;
        for (int i = 0; i < data.size(); i++) {
            Relation x = data.get(i);
            if (x.parent == null) {
                root = new Node();
                root.data = x.child;

                break;
            }

        }

        if (root == null) return root;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node x = q.poll();
            for (int i = 0; i < data.size(); i++) {
                Relation y = data.get(i);
                if(y.parent == null){
                    y.parent = 0;
                }
                if (y.parent == x.data) {
                    Node n = new Node();
                    n.data = y.child;

                    if (y.isLeft)
                        x.left = n;
                    else x.right = n;
                    q.add(n);
                    children++;
                    if (children == 2) {
                        children = 0;
                        break;
                    }
                }
            }
        }
        return root;
    }
    public static Node buildTreeON(List<Relation> data){
        if(data==null) return new Node();
        Node root=new Node();
        HashMap<Integer,ArrayList<Relation>> tree = new HashMap<Integer,ArrayList<Relation>>();
        for(Relation d:data){
            if(d.parent==null)
                root=new Node(d.child);
            else{
                if(tree.containsKey(d.parent)){
                    ArrayList<Relation> value=tree.get(d.parent);
                    value.add(d);
                } else {
                    ArrayList<Relation> value = new ArrayList<Relation>();
                    value.add(d);
                    tree.put(d.parent,value);
                }
            }
        }
        if(root==null) return root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node x = q.poll();
            if(tree.containsKey(x.data)){
                ArrayList<Relation> value=tree.get(x.data);
                for(Relation v:value){
                    Node child = new Node(v.child);
                    q.add(child);
                    if(v.isLeft)
                        x.left=child;
                    else x.right=child;
                }
            }
        }
        return root;
    }

//    public static Node buildTree(List<Relation> data) {
//        if (data == null || data.isEmpty()) {
//            return null;
//        }
//
//        Node root = null;
//        Map<Integer, Node> mapNode = new HashMap<Integer, Node>();
//        for (Relation relation : data) {
//            if (relation.parent == null) {
//                if (mapNode.containsKey(relation.child)) {
//                    root = mapNode.get(relation.child);
//                } else {
//                    root = new Node(relation.child);
//                    mapNode.put(root.data, root);
//                }
//                continue;
//            }
//
//            Node parent;
//            if (mapNode.containsKey(relation.parent)) {
//                parent = mapNode.get(relation.parent);
//                addChild(mapNode, relation, parent);
//            } else {
//                parent = new Node(relation.parent);
//                mapNode.put(parent.data, parent);
//                addChild(mapNode, relation, parent);
//            }
//        }
//
//        return root;
//    }
//
//    private static void addChild(Map<Integer, Node> mapNode, Relation relation, Node parent) {
//        Node childNode =
//                mapNode.containsKey(relation.child) ?
//                        mapNode.get(relation.child) : new Node(relation.child);
//        if (relation.isLeft) {
//            parent.left = childNode;
//        } else {
//            parent.right = childNode;
//        }
//        mapNode.put(childNode.data, childNode);
//    }

    public static void preOrder(Node root){
        if(root == null){
            return ;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);

    }

    public void levelOrderNaiveApproach(Node root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            printLevels(root,i);
            System.out.println("");
        }
    }
    public void printLevels(Node root, int h){
        if(root==null) return;
        if(h==1) System.out.print(" " + root.data);
        else{
            printLevels(root.left,h-1);
            printLevels(root.right,h-1);
        }
    }
    public int height(Node root){
        if (root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList() {{
            add(new Relation(15, 20, true));
            add(new Relation(19, 80, true));
            add(new Relation(17, 20, false));
            add(new Relation(16, 80, false));
            add(new Relation(80, 50, false));
            add(new Relation(50, 0, false));
            add(new Relation(20, 50, true));
        }};
        Node xpr = buildTreeUsingQueue(list);
        //preOrder(xpr);
        Node pr = buildTreeON(list);
        ChildParentBT bt = new ChildParentBT();
        preOrder(pr);
        bt.levelOrderNaiveApproach(pr);

    }

}

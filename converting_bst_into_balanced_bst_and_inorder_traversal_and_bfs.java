package March;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class converting_bst_into_balanced_bst_and_inorder_traversal_and_bfs {
    
    static void inorder(ArrayList<Integer> list, Node root) {
        if (root == null)
            return;

        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    static void bfs(ArrayList<Integer> list, Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            Node n = q.poll();
            list.add(n.val);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }

    }

    static Node balanceTree(ArrayList<Integer> list, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new Node(list.get(start));
        int mid = start + (end - start) / 2;
        Node root = new Node(list.get(mid));
        root.left = balanceTree(list, start, mid - 1);
        root.right = balanceTree(list, mid + 1, end);
        return root;

    }

    public static void main(String args[]) {
        Node root = new Node(10);
        Node node = new Node(5);
        root.left = node;
        node = new Node(2);
        root.left.left = node;
        node = new Node(1);
        root.left.left.left = node;
        ArrayList<Integer> list = new ArrayList<>();
        bfs(list, root);
        System.out.println(list);
        list.clear();
        inorder(list, root);
        System.out.println(list);
        root = balanceTree(list, 0, list.size() - 1);
        ArrayList<Integer> nList = new ArrayList<>();
        bfs(nList, root);
        System.out.println(nList);

    }

}

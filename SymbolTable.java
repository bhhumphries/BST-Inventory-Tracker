import java.util.LinkedList;
import java.util.Queue;

public class SymbolTable<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;           // key
        private Value val;         // associated value
        private Node lchild;       // left link to subtree
        private Node rchild;       // right link to subtree
        private int N;             // number nodes in subtree rooted here

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.lchild = null;
            this.rchild = null;
        }
    }

    private Node root;   // root of BST

    // initializes BST
    public SymbolTable() {
        this.root = null;
    }

    // returns number of items in BST
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null)
            return 0;
        else
            return n.N;
    }

    // insert the item into the BST
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node n, Key key, Value val) {
        if (n == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.lchild = put(n.lchild, key, val);
        }
        else if (cmp > 0) {
            n.rchild = put(n.rchild, key, val);
        }
        else {
            n.val = val;
        }
        n.N = 1 + size(n.lchild) + size(n.rchild);
        return n;
    }

    // return the values for a specific key
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node n, Key key) {
        if (key == null)
            return null;
        if (n == null)
            return null;
        int cmp = key.compareTo(n.key);
        if (cmp < 0)
            return get(n.lchild, key);
        else if (cmp > 0)
            return get(n.rchild, key);
        else
            return n.val;
    }

    // return the minimum item
    public Key min() {
        return min(root).key;
    }

    private Node min(Node n) {
        if (n.lchild == null)
            return n;
        return min(n.lchild);
    }

    // delete the minimum item
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node n) {
        if (n.lchild == null)
            return n.rchild;
        n.lchild = deleteMin(n.lchild);
        n.N = size(n.lchild) + size(n.rchild) + 1;
        return n;
    }

    // delete an item from the BST
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node n, Key key) {
        if (n == null) {
            return null;
        }
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.lchild = delete(n.lchild, key);
        }
        else if (cmp > 0) {
            n.rchild = delete(n.rchild, key);
        }
        else {
            if (n.rchild == null)
                return n.lchild;
            if (n.lchild == null)
                return n.rchild;
            Node t = n;
            n = min(t.rchild);
            n.rchild = deleteMin(t.rchild);
            n.lchild = t.lchild;
        }
        n.N = size(n.lchild) + size(n.rchild) + 1;
        return n;
    }
    
    // used to order the BST by Key into a Queue and returned
    public Queue<Key> traverse() {
        Queue<Key> traversal = new LinkedList<>();
        inorder(root, traversal);
        return traversal;
    }

    private void inorder(Node n, Queue<Key> traversal) {
        if (n == null) {
            return;
        }
        inorder(n.lchild, traversal);
        traversal.add(n.key);
        inorder(n.rchild, traversal);
    }
}

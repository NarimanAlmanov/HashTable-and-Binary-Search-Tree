import java.util.LinkedList;

public class NBinarySearchTree <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node,K key, V val) {
        if(node == null) return new Node(key, val);
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) node.left = put(node.left, key, val);
        else if (compareResult > 0) node.right = put(node.right, key, val);
        else node.val = val;
        return node;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key){
        if(node == null) return null;
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) return get(node.left, key);
        else if (compareResult > 0) return get(node.right, key);
        else return node.val;
    }

    private Node min(Node node){
        if (node.left == null) return node;
        return min(node.left);
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node deleteMin(Node node){
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    private Node delete(Node node, K key){
        if (node == null) return null;
        int compareResult = key.compareTo(node.key);
        if(compareResult < 0) node.left = delete(node.left, key);
        else if(compareResult > 0) node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node _node = node;
            node = min(_node.right);
            node.right = deleteMin(_node.right);
            node.left = _node.left;
        }
        return node;
    }

    public Iterable<K> iterator() {
        LinkedList<K> q = new LinkedList<K>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, LinkedList<K> q){
        if (x == null) return;
        inorder(x.left, q);
        q.push(x.key);
        inorder(x.right, q);
    }
}

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

    }

    private void put(Node node,K key, V val) {

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

    public void delete(K key) {

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

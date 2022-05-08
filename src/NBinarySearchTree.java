import java.security.Key;
import java.util.LinkedList;
import java.util.Queue;

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
    public void put(K key, V val) {}

    public V get(K key) {
        return null;
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

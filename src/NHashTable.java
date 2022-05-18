import java.util.Arrays;

public class NHashTable <K, V>{
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11; // default number of chains
    private int size = 0;

    public NHashTable() {
        chainArray = new HashNode[M];
    }

    public NHashTable(int M) {
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()%M);
    }

    public void put(K key, V value) {
        size++;
        if(size > M*0.7){
            M = M*2;
            HashNode[] old = chainArray;
            chainArray = new HashNode[M];

            for (int i = 0; i < old.length; i++)
                chainArray[i] = old[i];
        }
        int hash = hash(key);
        if (chainArray[hash] == null) {
            chainArray[hash] = new HashNode<>(key, value);
        }
        else {
            HashNode _node = chainArray[hash];
            while (true){
                if(_node.next == null){
                    _node.next = new HashNode<>(key, value);
                    break;
                }
                _node = _node.next;
            }
        }

    }

    public V get(K key) {
        int hash = hash(key);
        HashNode _node = chainArray[hash];
        while (true){
            if(_node == null){
                return null;
            }
            if(_node.key.equals(key))
            {
                return (V) _node.value;
            }
            _node = _node.next;
        }
    }

    public V remove(K key) {
        int hash = hash(key);
        HashNode _node = chainArray[hash];
        HashNode _node_prev = chainArray[hash];
        while (true){
            if(_node == null){
                return null;
            }
            if(_node.key.equals(key))
            {
                Object val = _node.value;
                if(_node.equals(_node_prev)){
                    chainArray[hash] = _node.next;
                }
                else {
                    _node_prev.next = _node.next;
                }
                return (V) val;
            }
            _node_prev = _node;
            _node = _node.next;
        }
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++){
            if(chainArray[i] == null) continue;
            if(chainArray[i].next == null){
                if(chainArray[i].value.equals(value)) return true;
            }
            HashNode _node = chainArray[i];
            while (true){
                if (_node.value.equals(value)) return true;
                if (_node.next == null) break;
                _node = _node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++){
            if(chainArray[i] == null) continue;
            if(chainArray[i].next == null){
                if(chainArray[i].value.equals(value)) return chainArray[i].key;
            }
            HashNode _node = chainArray[i];
            while (true){
                if (_node.value.equals(value)) return (K) _node.key;
                if (_node.next == null) break;
                _node = _node.next;
            }
        }
        return null;
    }

    public void print(){
        for(int i = 0; i < M; i++){
            if(chainArray[i] == null) continue;
            HashNode _node = chainArray[i];
            while (true){
                System.out.print(_node.toString() + "~>");
                if(_node.next == null) break;
                _node = _node.next;
            }
            System.out.println();
        }
    }
}

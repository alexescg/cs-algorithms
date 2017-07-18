package ds;

/**
 * Binary Tree key-value data structure
 *
 * @author alex
 */
public class BinaryTree<K extends Comparable<K>, V> {

    private Node head = null;

    public BinaryTree() {
    }

    /**
     * Insert node into Binary Tree
     *
     * @param key to insert
     * @param val to insert
     */
    public void insert(K key, V val) {
        head = insert(key, val, head);
    }

    private Node insert(K key, V val, Node node) {

        if (node == null) {
            return new Node(key, val);
        }

        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = insert(key, val, node.right);

        } else if (compare < 0) {
            node.left = insert(key, val, node.left);

        } else {
            node.val = val;
        }

        return node;
    }

    /**
     * Get Value inside node
     *
     * @param key to match
     * @return value inside key
     */
    public V getValue(K key) {
        Node node = head;
        while (node != null) {
            int compare = key.compareTo(node.key);
            if (compare > 0) {
                node = node.right;

            } else if (compare < 0) {
                node = node.left;

            } else {
                return node.val;
            }
        }
        return null;
    }

    /**
     * Get node that matches key
     *
     * @param key to match
     * @return node
     */
    public Node getNode(K key) {
        Node node = head;
        while (node != null) {
            int compare = key.compareTo(node.key);
            if (compare > 0) {
                node = node.right;

            } else if (compare < 0) {
                node = node.left;

            } else {
                return node;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "BinaryTree{" +
                "head=" + head +
                '}';
    }

    class Node {
        Node left;
        Node right;
        Node parent;
        K key;
        V val;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", parent=" + parent +
                    ", key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
}

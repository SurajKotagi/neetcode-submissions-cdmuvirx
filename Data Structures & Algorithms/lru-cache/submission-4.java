
class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head, tail; // head = LRU, tail = MRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToTail(node); // mark as recently used
        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return;
        }

        // create new node
        Node node = new Node(key, value);

        if (map.size() == capacity) {
            // remove LRU (head)
            map.remove(head.key);
            removeNode(head);
        }

        // insert at tail
        addToTail(node);
        map.put(key, node);
    }

    // ================= HELPER METHODS =================

    private void removeNode(Node node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // removing head
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // removing tail
        }
    }

    private void addToTail(Node node) {

        if (tail == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    private void moveToTail(Node node) {

        if (node == tail) return;

        removeNode(node);
        addToTail(node);
    }
}
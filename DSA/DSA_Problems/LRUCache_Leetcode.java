class LRUCache {

    //initialising head node
    Node head = new Node(0, 0);
    //initialising tail node
    Node tail = new Node(0, 0);
    //the cache nodes will exist withing these two boundary nodes

    //hashmap to search the existence of a key in the cache
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        //if key already exists, we delete it from its place as it is now most recently used
        //and insert it again in the beginning
        if(map.containsKey(key)){
            Node temp = map.get(key);
            int val = temp.value;

            //removing node from the ll
            deleteNode(temp);

            //putting it again at the start
            put(key, val);

            return val;
        }

        //if key doesnt exist, return -1
        return -1;
    }

    public void put(int key, int value) {

        //if key already exists, first delete that node, and insert it again at the start
        if(map.containsKey(key)){
            Node temp = map.get(key);
            deleteNode(temp);
        }

        //if size is full, remove least recently used node, which is the node before tail
        if(map.size() == capacity){
            deleteNode(tail.prev);
        }

        //create a new node and add it to the front of the cache (after head)
        Node newnode = new Node(key, value);
        newnode.next = head.next;
        head.next.prev = newnode;
        head.next = newnode;
        newnode.prev = head;

        //add/update the map with new value
        map.put(key, newnode);

        return;

    }

    public void deleteNode(Node temp){

        //remove the key from the hashmap
        map.remove(temp.key);

        //updating connections to remove node from the ll
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return;
    }
}

//creating a node of a doubly linked list
class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }

}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
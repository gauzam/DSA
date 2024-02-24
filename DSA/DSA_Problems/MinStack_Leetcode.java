//a node that stores the data as well as the minimum till now
class Node{
    int data;
    int min;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}

class MinStack {

    Node head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {

        Node newnode = new Node(val);

        if(head == null){
            head = newnode;
            head.min = val;
            return;
        }


        newnode.min = Math.min(val, head.min);
        newnode.next = head;
        head = newnode;

    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
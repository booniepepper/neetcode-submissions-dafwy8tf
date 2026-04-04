class LinkedList {
    private class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public int get(int index) {
        var node = getNode(index);
        return node != null ? node.val : -1;
    }

    public void insertHead(int val) {
        head = new Node(val, head);
    }

    public void insertTail(int val) {
        var tail = new Node(val, null);
        if (head == null) {
            head = tail;
            return;
        }

        var curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tail;
    }

    public boolean remove(int index) {
        if (index == 0) {
            if (head == null) {
                return false;
            }
            head = head.next;
            return true;
        }

        var node = getNode(index - 1);
        if (node != null && node.next != null) {
            node.next = node.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        var list = new ArrayList<Integer>();
        var curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }

    public Node getNode(int index) {
        var curr = head;
        int i = 0;

        while (curr != null && i <= index) {
            if (index == i) {
                return curr;
            }
            
            curr = curr.next;
            i++;
        }

        return null;
    }
}

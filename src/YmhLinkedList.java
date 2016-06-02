public class YmhLinkedList {
    private Node first;
    private Node last;
    int size;

    public YmhLinkedList() {
    }


    //增
    public void add(Object obj) {
        if (first == null) {
            first = new Node(obj);
            last = first;
        } else {
            Node node = new Node(obj);
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    public void add(int index, Object obj) {
        rangecheck(index);
        Node node = new Node(obj);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp.prev != null && temp.next != null) {
            Node prevNode = temp.prev;
            prevNode.next = node;
            node.prev = prevNode;
            node.next = temp;
            temp.prev = node;
        } else if (temp.prev == null) {
            first = node;
            temp.prev = node;
            node.next = temp;
        } else if (temp.next == null) {
            temp.next = node;
            node.prev = temp;
            last = node;
        }
        size++;
    }


    //删
    public Object remove(int index) {
        rangecheck(index);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Object oldValue = temp.value;
        if (temp.prev != null && temp.next != null) {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp = null;
        } else if (temp.prev == null) {
            first = temp.next;
            temp.next.prev = null;
            temp = null;
        } else if (temp.next == null) {
            last = temp.prev;
            temp.prev.next = null;
            temp = null;
        }
        size--;
        return oldValue;
    }

    public boolean remove(Object obj) {
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (obj.equals(temp.value)) {
                remove(i);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //改
    public Object set(int index, Object obj) {
        rangecheck(index);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Object oldValue = temp.value;
        temp.value = obj;
        return oldValue;
    }

    //查
    public Object get(int index) {
        rangecheck(index);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    private void rangecheck(int index) {
        if (index < 0 || index > size) {
            try {
                throw new MyException();
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

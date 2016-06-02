/**
 * Created by ymh on 2016/6/2.
 */
public class Node {
    Node prev;
    Node next;
    Object value;

    public Node(Object obj) {
        prev = null;
        next = null;
        this.value = obj;
    }


    public Node(Node prev, Node next, Object value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}

/**
 * Created by ymh on 2016/6/2.
 */
public class YmhHashMap {
    private YmhLinkedList[] list = new YmhLinkedList[999];
    private int size;

    //增
    public void put(Object key, Object value) {
        int pos = key.hashCode() % 999;
        pos = pos > 0 ? pos : -pos;
        YmhLinkedList ymhLinkedList = null;
        Bean bean = new Bean(key, value);

        if (list[pos] == null) {
            ymhLinkedList = new YmhLinkedList();
        } else {
            ymhLinkedList = list[pos];
            for (int i = 0; i < ymhLinkedList.size; i++) {
                if (((Bean) ymhLinkedList.get(i)).key.equals(key)) {
                    ((Bean) ymhLinkedList.get(i)).value = value;
                    return;
                }
            }
        }
        size++;
        ymhLinkedList.add(bean);
        list[pos] = ymhLinkedList;
    }

    //删
    public Object remove(Object key) {
        int pos = key.hashCode() % 999;
        YmhLinkedList ymhLinkedList = null;
        ymhLinkedList = list[pos];
        if (ymhLinkedList == null) {
            return null;
        }
        for (int i = 0; i < ymhLinkedList.size; i++) {
            if (((Bean) ymhLinkedList.get(i)).key.equals(key)) {
                Object oldValue = ((Bean) ymhLinkedList.get(i)).value;
                ymhLinkedList.remove(i);
                size--;
                return oldValue;
            }
        }
        return null;
    }

    //改
    public Object set(Object key, Object value) {
        int pos = key.hashCode() % 999;
        YmhLinkedList ymhLinkedList = null;
        ymhLinkedList = list[pos];
        if (ymhLinkedList == null) {
            return null;
        }
        for (int i = 0; i < ymhLinkedList.size; i++) {
            if (((Bean) ymhLinkedList.get(i)).key.equals(key)) {
                Object oldValue = ((Bean) ymhLinkedList.get(i)).value;
                ((Bean) ymhLinkedList.get(i)).value = value;
                return oldValue;
            }
        }
        return null;
    }

    // 查
    public Object get(Object key) {
        int pos = key.hashCode() % 999;
        pos = pos > 0 ? pos : -pos;
        YmhLinkedList ymhLinkedList = null;
        ymhLinkedList = list[pos];
        if (ymhLinkedList == null) {
            return null;
        }
        for (int i = 0; i < ymhLinkedList.size; i++) {
            if (((Bean) ymhLinkedList.get(i)).key.equals(key)) {
                return ((Bean) ymhLinkedList.get(i)).value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

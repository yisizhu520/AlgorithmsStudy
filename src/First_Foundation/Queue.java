import java.util.Iterator;

/**
 * Created by WangJun on 2016/4/6.
 */
public class Queue<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new NormalQueueIterator();
    }

    private class NormalQueueIterator implements Iterator<T> {

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T t = node.item;
            node = node.next;
            return t;
        }
    }

    private class Node {
        T item;
        Node next;
    }

    private int N;
    private Node first;
    private Node last;

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(T item) {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (first == null) {
            first = last;
        } else {
            old.next = last;
        }
        N++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        }
        N--;
        return item;
    }

    public void enqueueHead(T item){
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        if (last == null) {
            last = first;
        }
        N++;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
        }
        Integer result = queue.deleteAtIndex(8);
        System.out.println(result);
        for (Integer i : queue){
            System.out.print(i+" ");
        }
    }

    /**
     * 1.3.20
     * 删除链表的第k个索引参数
     * @param k
     */
    public T deleteAtIndex(int k){
        if(k<0 || k>N-1){
            throw new IllegalStateException("索引越界");
        }
        Node _first = first;
        if(k == 0){
            return dequeue();
        }
        for (int i = 0; i < k-1; i++) {
            _first = _first.next;
        }
        T item = _first.next.item;
        _first.next = _first.next.next;
        return item;
    }


}

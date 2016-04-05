import java.util.Iterator;

/**
 * Created by WangJun on 2016/4/5.
 */
public class Stack<T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return new NormalStackIterator();
    }

    private class NormalStackIterator implements Iterator<T> {

        private Node index = first;

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public T next() {
            T item = index.item;
            index = index.next;
            return item;
        }
    }

    private class Node {
        T item;
        Node next;
    }

    private int N;
    private Node first;

    private boolean needPrintLog = false;

    public void setNeedPrintLog(boolean needPrintLog) {
        this.needPrintLog = needPrintLog;
    }

    public void push(T item){
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        N++;
        if(needPrintLog){
            System.out.println(item+"==入栈");
        }

    }

    public T pop(){
        T item = first.item;
        first = first.next;
        N--;
        if(needPrintLog){
            System.out.println(item+"==出栈");
        }

        return item;
    }

    /**
     *
     * @return 返回栈顶元素
     */
    public T top(){
        return first.item;
    }

    public boolean isEmpty(){
        return N == 0;
    }


}

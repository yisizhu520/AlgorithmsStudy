/**
 * 最大堆--实现优先队列的数据结构
 * Created by WangJun on 2016/4/17.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    /**
     * 元素从pq[1]开始
     */
    Key[] pq;
    int N;

    public MaxPQ(Key[] a) {
        pq = (Key[]) new Comparable[a.length+1];
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[N];
    }

    void insert(Key k) {
        //忽略动态调整数组大小
        pq[++N] = k;
        swim(N);
    }

    Key max() {
        return pq[1];
    }

    Key delMax() {
        //忽略动态调整数组大小
        Key max =max();
        pq[1] = pq[N];
        N--;
        sink(1);
        return max;
    }

    boolean isEmpty() {
        return N==0;
    }

    int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 上浮操作：如果该节点比其父节点要大，则需要交换该节点和父节点的位置
     * k节点的父节点是k/2
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉操作：如果该节点比其子节点节点要小，则需要交换该节点和更大的子节点的位置
     * k节点的子节点是2k，2k+1
     *
     * @param k
     */
    private void sink(int k) {
        //MARK 注意这里的边界判断，可能会出现子节点2k存在，但是子节点2k+1不存在的情况，所以这里要加“=”
        while (2 * k <= N) {
            int j = 2 * k;
            //MARK 这里要加上条件j<N，也是为了防止2k+1子节点不存在的情况
            if (j<N && less(j, j + 1)) j = j + 1;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }



}

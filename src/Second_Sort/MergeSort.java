import java.util.Arrays;
import java.util.Collections;

/**
 * 归并排序
 * Created by WangJun on 2016/4/14.
 */
public class MergeSort extends AbstractSortTemplate {

    /*
    分治思想，将数组拆分成左右两个子数组，分别排好序再合并，如此递归下去实现
    合并的时候，需要一个辅助数组实现
     */

    @Override
    protected void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int middle = (low + high) / 2;
        sort(a, low, middle);
        sort(a, middle + 1, high);
        //优化，如果a[middle]比a[middle+1]要小，则不需要merge了，已经是有序的了
        if (less(a[middle + 1], a[middle])) {
            merge(a, low, middle, high);
        }


    }

    /**
     * 自底而上的归并排序
     * //TODO 不太熟练，自己手写一遍
     */
    public void sortFromBottom(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int i = 1; i < a.length; i = i + i) {
            for (int j = 0; j < a.length - i; j = i + i) {
                merge(a, j, j + i - 1, Math.min(j + i + i - 1, a.length - 1));
            }

        }
    }

    //辅助数组
    static Comparable[] aux;

    private void merge(Comparable[] a, int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }
        int m = low;
        int n = middle + 1;
        for (int i = low; i <= high; i++) {
            if (m > middle) {
                aux[i] = a[n++];
            } else if (n > high) {
                aux[i] = a[m++];
            } else if (less(a[m], a[n])) {
                aux[i] = a[m++];
            } else {
                aux[i] = a[n++];
            }
        }
        for (int i = low; i <= high; i++) {
            a[i] = aux[i];
        }
    }


}

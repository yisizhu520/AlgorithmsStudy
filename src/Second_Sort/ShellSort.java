/**
 * Created by WangJun on 2016/4/13.
 */
public class ShellSort extends AbstractSortTemplate {


    /*
    希尔排序的特点：
    比插入排序快得多
    数组越大，优势越大
    原地排序，不另外占用内存

    无法准确描述它的性能，约为N^(3/2)这样的复杂度
     */

    @Override
    protected void sort(Comparable[] a) {
        /*
         *希尔排序的思路：
         * 算是插入排序的改良版本，在插入排序中，元素到它最后排序好的位置是一步一步挪动的
         * 而希尔排序是让元素们步子跨的更大，一次能挪动到很远.
         */
        //构造递增序列,使用3h+1的序列
        int h = 1;
        while (3 * h + 1 < a.length) {
            h = 3 * h + 1;
        }
        //对每个序列使用插入排序，构成h有序
        while (h != 0) {
            for (int i = 0; i < a.length; i = i + h) {
                Comparable curValue = a[i];
                int position = i;
                for (int j = i; j >= 0; j = j - h) {
                    if (less(a[i], a[j])) {
                        a[j] = a[i];
                        position = j;
//                        exch(a, i, j);
                    }
                }
                a[position] = curValue;
            }
            h = h / 3;

        }
    }


}

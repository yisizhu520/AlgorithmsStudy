/**
 * Created by ai on 2015-10-30.
 * 希尔排序
 */
public class ShellSort extends AbstractSortTemplate {


    /*
    希尔排序是对插入排序的一种优化
    使数组中任意间隔为h的元素都是有序的
    如果h很大，这样就可以将元素移动到很远的地方
    相比于插入排序，就可以减少元素交换的次数了
     */
    @Override
    protected void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //自定义增长序列序列
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h]))
                        exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}

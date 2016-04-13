/**
 * 选择排序
 * Created by ai on 2015-10-24.
 */
public class SelectionSort extends AbstractSortTemplate {
    @Override
    protected void sort(Comparable[] a) {
        /*
        选择排序是最容易理解的一种排序算法
        找到数组中最小的元素与第一个元素交换
        其次，在剩下的元素中找到最小的元素与第二个元素交换
        整个过程就是在不断的寻找剩余元素中最小的一个
         */

        for (int i = 0; i < a.length; i++) {
            //找到剩余元素中最小的
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }

        /*
        特点：
        运行时间与输入无关，也是缺点，无法利用输入的初始状态
        数据移动是最少的，只会交换N次
        比较次数是最多的
         */


    }


}

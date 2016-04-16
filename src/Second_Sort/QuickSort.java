import com.sun.xml.internal.bind.v2.TODO;

import java.util.Comparator;
import java.util.Random;

/**
 * 快速排序
 * Created by WangJun on 2016/4/15.
 */
public class QuickSort extends AbstractSortTemplate {

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int length = 100;
        Integer[] src = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
//            src[i] = random.nextInt(length);
            //src[i] = i;
            src[i] = length - i;
        }
        //src[99] = 100;
        QuickSort.show(src);
        qs.sort(src);
        QuickSort.show(src);
    }


    @Override
    protected void sort(Comparable[] a) {
        /*
        普通的快速排序
        类似于归并排序，也是使用递归来排序，不同之处在于：
        归并排序是在递归之后对数组进行处理：归并，而快速排序是在递归之前对数组进行处理：切分
         */

        quickSort(a, 0, a.length - 1);
    }

    /**
     * 三向切分的快速排序
     * 对于存在大量重复元素的数组，这种效率比标准的快速排序高很多
     * //TODO 自己动手写
     * MARK jdk源码里就是使用类似的快速排序作为基础类型数据的排序算法，Arrays.sort();
     * Mark 而为引用类型数据排序时，使用的是归并排序算法，Collections.sort();
     *
     * @param a
     * @param low
     * @param high
     */
    void Quick3WaySort(Comparable[] a, int low, int high) {
        //将数组分成三部分，[小于V的，等于V的，大于V的]
        Comparable V = a[low];
        int lt = low, gt = high, i = low + 1;
        while (i <= gt) {//MARK 这里要有=号，确保高位指针gt的那个元素也得被检查
            int result = a[i].compareTo(V);
            if (result < 0) {
                exch(a, i++, lt++);
            } else if (result > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        Quick3WaySort(a, low, lt - 1);
        Quick3WaySort(a, gt + 1, high);
    }

    void quickSort(Comparable[] a, int low, int high) {
        //递归结束条件
        if (low >= high) {
            return;
        }
        //找到切分点，并让切分点左小右大
        int j = partition2(a, low, high);
        //递归调用
        quickSort(a, low, j - 1);
        quickSort(a, j + 1, high);
    }

    /**
     * 在排序小数组的时候该用插入排序：
     * 对于小数组，快速排序比插入排序慢
     *
     * @param a
     * @param low
     * @param high
     */
    void quickSortWithInsert(Comparable[] a, int low, int high) {
        //递归结束条件
        int M = 7;
        if (low + M >= high) {
            new InsertionSort().sort(a, low, high);
            return;
        }
        //找到切分点，并让切分点左小右大
        int j = partition2(a, low, high);
        //递归调用
        quickSort(a, low, j - 1);
        quickSort(a, j + 1, high);
    }

    /**
     * 切分方法
     * 默认找的切分元素是第一个，即a[low]
     * 弄两个索引，分别从左右两边开始向中靠拢搜索
     * 从左边找到一个大于等于a[low]的元素，从右边找一个小于等于a[low]的元素，然后交换
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    int partition(Comparable[] a, int low, int high) {
        Comparable par = a[low];
        //TODO 不熟练，自己需要重新写一遍
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(a[++i], par)) {
                //MARK i++  居然把自加写到循环里了...;
                //不能省略，4,3,2,1,0的时候会越界,除非保证右侧为最大的哨兵;
                if (i == high) break;
            }
            while (less(par, a[--j])) {
                //j--;
                //if (j == low) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        //exch(a, low, i); MARK 一定要交换的是j，而不是i，现在的i是比a[low]要大的
        exch(a, low, j);
        return j;

    }

    /**
     * 2.3.17 Hoare的双向扫描
     * A[p]做哨兵元素减少了内层循环的一个if测试
     * 假如数组是[4,3,2,1,0]，这里的i初始值是low-1，所以在第一次exch的时候会将4和0交换，这样4就是右边界的哨兵了
     * http://blog.csdn.net/zuiaituantuan/article/details/5978009
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    int partition2(Comparable[] a, int low, int high) {
        Comparable par = a[low];
        int i = low - 1;
        int j = high + 1;
        for (; ; ) {
            do --j; while (less(par, a[j]));
            do ++i; while (less(a[i], par));
            if (i < j) exch(a, low, j);
            else return j;
        }
    }

    //TODO 快速排序后面的练习题


}

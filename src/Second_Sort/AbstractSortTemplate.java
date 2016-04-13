/**
 * 所有排序算法类的抽象父类，提供一些基本的方法
 * Created by ai on 2015-10-24.
 */
public abstract class AbstractSortTemplate {

    protected int exchCount;
    protected int compareCount;

    /**
     * 对数组a进行升序排列
     *
     * @param a
     */
    protected abstract void sort(Comparable[] a);


    /**
     * 判断v是否小于w
     *
     * @param v
     * @param w
     * @return
     */
    protected boolean less(Comparable v, Comparable w) {
        compareCount++;
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组a里的i与j索引里的值
     *
     * @param a
     * @param i
     * @param j
     */
    protected void exch(Comparable[] a, int i, int j) {
        exchCount++;
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 打印出数组a的内容
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        StringBuilder stringBuilder = new StringBuilder(a.length * 2);
        for (int i = 0; i < a.length; i++) {
            stringBuilder.append(a[i]);
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
    }

    public void printCount(){
        System.out.println("比较次数："+compareCount+",交换次数："+exchCount);
    }

    /**
     * 判断数组a是不是升序排列
     *
     * @param a
     * @return
     */
    protected boolean isSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }


}

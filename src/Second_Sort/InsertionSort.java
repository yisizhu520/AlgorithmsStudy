import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 * Created by ai on 2015-10-24.
 */
public class InsertionSort extends AbstractSortTemplate {

    public static void main(String[] args) {
        int length = 4000;
        Integer[] src = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            src[i] = random.nextInt(length);
            //src[i] = i;
        }


//        Integer[] c = Arrays.copyOf(src,length);
//        InsertionSort sort3 = new InsertionSort();
//        TimeWatch tw = new TimeWatch();
//        sort3.insertSort2(c);
//        tw.printInterval();
//        // sort2.show(c);
//        sort3.printCount();

//        Integer[] b = Arrays.copyOf(src,length);
//        InsertionSort sort2 = new InsertionSort();
//        TimeWatch tw = new TimeWatch();
//        sort2.mySort(b);
//        tw.printInterval();
//       // sort2.show(b);
//        sort2.printCount();

        InsertionSort.show(src);
        Integer[] a = Arrays.copyOf(src,length);
        InsertionSort sort = new InsertionSort();
        TimeWatch tw = new TimeWatch();
        sort.sort(a);
        tw.printInterval();
        //sort.show(a);
        sort.printCount();
    }



    @Override
    protected void sort(Comparable[] a) {
        /*
        插入排序就像是抽扑克牌，抽到一张牌就直接把它放到适合的位置  1245，3
         */
        for (int i = 1; i < a.length; i++) {//对抓到的第i张牌插入
            for (int j = i; j > 0; j--) {//找到合适插入的位置插入
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
        }


    }

    /**
     * 自己对插入排序的理解，感觉这才像真正的抓扑克牌
     * 与传统的排序算法相比，比较次数平均少了一半
     *
     * @param a
     */
    public void mySort(Comparable[] a) {
        //1245，3
        for (int i = 1; i < a.length; i++) {//对抓到的第i张牌插入
            int poi = i;
            for (int j = i - 1; j >= 0; j--) {//找到合适插入的位置插入
                if (less(a[i], a[j])) {
                    poi = j;
                } else {
                    break;
                }
            }
            for (int k = i; k > poi; k--) {
                exch(a, k, k - 1);
            }
        }
    }

    /**
     * 在网上找的插入排序算法的实现
     * 比较次数与自己实现的mysort相同，效率一样
     *
     */
    public  void insertSort2(Comparable[] array) {

        for (int i = 1; i < array.length; i++) {
            Comparable currentValue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (less(currentValue,array[j])) {
                    array[j + 1] = array[j];
                    position = j;
                } else {
                    break;
                }
            }

            array[position] = currentValue;
        }
    }
}

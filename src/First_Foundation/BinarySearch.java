import java.util.Arrays;
import java.util.Collections;

/**
 * Created by WangJun on 2016/3/25.
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] src = new int[]{1,1,2,2,3,3,3,4,5,8,8,8};
//        System.out.println(loopBinarySearch(src, 90));
//        System.out.println(recursionBinarySearch(src, 90));
        System.out.println(rank(3,src));
        System.out.println(findHigherCount(3,src));
        System.out.println(count(3, src));
//        System.out.println(jiechen(4));

        final String a = "a";
        String b = "b";
        String c = a+"b";
        String d = "ab";
        System.out.println(c==d);
    }

    /**
     * 使用循环实现二分查找
     *
     * @param array
     * @param value
     * @return 返回要查找的value在array数组中的索引，-1:未查找到
     */
    static int loopBinarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    static int recursionBinarySearch(int[] array, int value) {
        return recursionBinarySearchWithLevel(array, 0, array.length - 1, value,0);
    }

    /**
     * 使用递归实现二分查找
     * @param array
     * @param low
     * @param high
     * @param value
     * @return
     */
    private static int recursionBinarySearch(int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            return recursionBinarySearch(array, middle + 1, high, value);
        } else {
            return recursionBinarySearch(array, low, middle - 1, value);
        }

    }

    /**
     * 练习1.1.22  打印二分查找的调用层级
     * @param array
     * @param low
     * @param high
     * @param value
     * @param level
     * @return
     */
    private static int recursionBinarySearchWithLevel(int[] array, int low, int high, int value, int level) {
        if (low > high) {
            return -1;
        }
        printLog(level,low,high);
        int middle = low + (high - low) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            return recursionBinarySearchWithLevel(array, middle + 1, high, value, level+1);
        } else {
            return recursionBinarySearchWithLevel(array, low, middle - 1, value, level+1);
        }


    }

    static void printLog(int level,int low, int high){
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(String.format("level:%d,low:%d,high:%d",level,low,high));
    }

    static int jiechen(int N) {
        if (N == 1) return 1;
        return N * jiechen(N - 1);
    }

    /**
     * 1.1.29  等值键
     * @param key  键
     * @param array 有序数组，元素可重复
     * @return 返回数组中小于该键的元素数量
     */
    public static int rank(int key,int[] array){
        //1,1,2,2,3,3,3,4,5,8,8,8
        /*
        思路1：
        首先还是使用二分查找去查
        如果没查到，则返回low？还是high？（因为退出循环时low = high+1），所以都一样
        如果查到了,则向左开始遍历，找到不等于key的值的索引

        思路2：
        思路1的做法显然是没有理解到二分查找的真正原理，理解不到位。
        其实我们的目的就是要找到小于key的最大的值
        只需要修改一下二分查找的实现即可：二分查找，直到low>high退出循环，此时找到的比key小的最大值了。

         */
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (array[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }

    /**
     * 1.1.29  等值键
     * @param key  键
     * @param array 有序数组，元素可重复
     * @return 返回数组中大于该键的元素数量
     */
    public static int findHigherCount(int key,int[] array){
        //1,2,3,4,5
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (array[middle] <= key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return array.length-1-high;
    }

    /**
     * 1.1.29  等值键
     * @param key  键
     * @param array 有序数组，元素可重复
     * @return 返回数组中等于该键的元素数量
     */
    public static int count(int key, int[] array){
        return array.length-findHigherCount(key,array)-rank(key,array);
    }


}

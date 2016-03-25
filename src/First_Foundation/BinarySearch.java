import java.util.Arrays;
import java.util.Collections;

/**
 * Created by WangJun on 2016/3/25.
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] src = new int[]{2, 3, 4, 5, 7, 9, 12, 24, 45, 56, 67, 78, 89, 90};
//        System.out.println(loopBinarySearch(src, 90));
        System.out.println(recursionBinarySearch(src, 90));
    }

    /**
     * ʹ��ѭ��ʵ�ֶ��ֲ���
     *
     * @param array
     * @param value
     * @return ����Ҫ���ҵ�value��array�����е�������-1:δ���ҵ�
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
        return recursionBinarySearch(array, 0, array.length - 1, value);
    }

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


}

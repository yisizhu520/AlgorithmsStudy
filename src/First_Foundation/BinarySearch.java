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
        return recursionBinarySearchWithLevel(array, 0, array.length - 1, value,0);
    }

    /**
     * ʹ�õݹ�ʵ�ֶ��ֲ���
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
     * ��ϰ1.1.22  ��ӡ���ֲ��ҵĵ��ò㼶
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
     * 1.1.29  ��ֵ��
     * @param key  ��
     * @param array �������飬Ԫ�ؿ��ظ�
     * @return ����������С�ڸü���Ԫ������
     */
    public static int rank(int key,int[] array){
        //1,1,2,2,3,3,3,4,5,8,8,8
        /*
        ˼·1��
        ���Ȼ���ʹ�ö��ֲ���ȥ��
        ���û�鵽���򷵻�low������high������Ϊ�˳�ѭ��ʱlow = high+1�������Զ�һ��
        ����鵽��,������ʼ�������ҵ�������key��ֵ������

        ˼·2��
        ˼·1��������Ȼ��û����⵽���ֲ��ҵ�����ԭ����ⲻ��λ��
        ��ʵ���ǵ�Ŀ�ľ���Ҫ�ҵ�С��key������ֵ
        ֻ��Ҫ�޸�һ�¶��ֲ��ҵ�ʵ�ּ��ɣ����ֲ��ң�ֱ��low>high�˳�ѭ������ʱ�ҵ��ı�keyС�����ֵ�ˡ�

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
     * 1.1.29  ��ֵ��
     * @param key  ��
     * @param array �������飬Ԫ�ؿ��ظ�
     * @return ���������д��ڸü���Ԫ������
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
     * 1.1.29  ��ֵ��
     * @param key  ��
     * @param array �������飬Ԫ�ؿ��ظ�
     * @return ���������е��ڸü���Ԫ������
     */
    public static int count(int key, int[] array){
        return array.length-findHigherCount(key,array)-rank(key,array);
    }


}

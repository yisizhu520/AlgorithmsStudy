import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by WangJun on 2016/4/5.
 */
public class Exercise1_3 {

    public static void main(String[] args) {
        int[] array = {0,4,6,5,3,8,1,7,2,9};
        checkPopStackOrderPossible(array);
    }

    /**
     * 练习1.3.3扩展
     * 判断出栈操作是否合理
     *
     * @param array 出栈操作返回值数组[0-9]
     * @return 结果
     */
    static boolean checkPopStackOrderPossible(int[] array) {
        /*
        思路：
        遍历返回值数组
        将比返回值相等或小的所有数都入栈，再将该返回值出栈

         */
        Stack<Integer> stack = new Stack<>();
        stack.setNeedPrintLog(true);
        Stack<Integer> hasPushedStack = new Stack<>();
        List<Integer> hasPushedList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (hasPushedStack.isEmpty() || value > hasPushedStack.top()) {
                int minus = hasPushedStack.isEmpty() ? 0 : hasPushedStack.top()+1;
                for (int j = minus; j <= value; j++) {
                    stack.push(j);
                    hasPushedStack.push(j);
                }
            }
            if (value == stack.top()) {
                stack.pop();
            }else{
                System.out.println(value+"==出栈顺序错误!!");
                Iterator<Integer> iterator = stack.iterator();
                System.out.println("栈里剩余元素为：");
                while (iterator.hasNext()) {
                    Integer next =  iterator.next();
                    System.out.print(" " +next);
                }
                return false;
            }

        }
        System.out.println("出栈顺序正确");
        return true;
    }

}

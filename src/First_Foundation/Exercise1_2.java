/**
 * Created by WangJun on 2016/3/30.
 */
public class Exercise1_2 {

    public static void main(String[] args) {
        System.out.println(isCircularRotation2("ACTGACG", "TGACGAC"));
    }

    /**
     * 1.2.6
     * �ж������ַ����Ƿ�Ϊ���ػ���λ��
     * ����:ACTGACG��TGACGAC���ǻػ���λ
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isCircularRotation(String s, String t) {
        return s.length() == t.length() && (t + t).contains(s);
    }

    /**
     * 1.2.6
     * �ж������ַ����Ƿ�Ϊ���ػ���λ��
     * ����:ACTGACG��TGACGAC���ǻػ���λ
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isCircularRotation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, length);
            if ((right + left).equals(t)) {
                return true;
            }
        }
        return false;
    }


}

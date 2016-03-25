/**
 * µÝ¹éµ¹ÐòÊä³ö×Ö·û´®
 * Created by WangJun on 2016/3/25.
 */
public class ReverseString {

    public static void main(String[] args) {
       reverseString("abcdefgh");
    }

    static void reverseString(String string) {
        if (string.length() == 0) {
            return ;
        }
        reverseString(string.substring(1, string.length()));
        System.out.print(string.charAt(0));
    }


}

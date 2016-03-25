/**
 * Created by ai on 2015-10-30.
 * ϣ������
 */
public class ShellSort extends AbstractSortTemplate {


    /*
    ϣ�������ǶԲ��������һ���Ż�
    ʹ������������Ϊh��Ԫ�ض��������
    ���h�ܴ������Ϳ��Խ�Ԫ���ƶ�����Զ�ĵط�
    ����ڲ������򣬾Ϳ��Լ���Ԫ�ؽ����Ĵ�����
     */
    @Override
    protected void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //�Զ���������������
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h]))
                        exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}

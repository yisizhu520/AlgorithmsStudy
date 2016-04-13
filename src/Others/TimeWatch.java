/**
 * Created by WangJun on 2016/4/13.
 */
public class TimeWatch {

    private long nowTime;

    public TimeWatch(){
        nowTime = System.currentTimeMillis();
    }

    public void printInterval(){
        System.out.println("耗时："+(System.currentTimeMillis() - nowTime));
    }
}

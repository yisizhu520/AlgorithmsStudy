/**
 * Created by WangJun on 2016/3/30.
 */

abstract class Callback{
    Callback(String a,int b){
        System.out.println("callback init");
    }

    abstract void hehe();
}

public class Demo {

    int a;
    String b;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Demo demo = (Demo) o;

        if (a != demo.a) return false;
        return !(b != null ? !b.equals(demo.b) : demo.b != null);

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }

    class inner{
        private int a;
        String string = "dsds";
        int hash = string.hashCode();

    }

    Demo(Callback cb){
        inner i = new inner();
        int b = i.a;
        System.out.println("demo init");
        cb.hehe();
    }

    public static  void main(String[] args) {
        String string = "ab";
        int hash = string.hashCode();//31*92+93 = 3105
        System.out.println(hash);
        Demo d = new Demo(new Callback("2",4){

            int Callback(){
                return 666;
            }
            String c;

            @Override
            void hehe() {
                Callback();
                System.out.println("hehe");
            }
        });
    }

    /**
     * a和b不用final修饰也能运行啊
     * @param b
     */
    public void test( int b) {
        int a = 10;
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            }
        }.start();
    }


}

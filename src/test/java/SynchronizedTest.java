/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/02/11:06
 * @Description: 同步省略说明
 */
public class SynchronizedTest {

    /**
     * 代码中对 0 这个对象进行枷锁，但是 0 对象的生命周期只在 f() 中
     * 并不会被其他线程所访问到，所以在 JIT 编译阶段就会被又划掉
     */
    public void f(){
        Object o = new Object();
        synchronized (o){
            System.out.println(o);
        }
    }
}

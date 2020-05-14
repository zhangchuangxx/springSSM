/**
 * @author 张闯
 * @create 2020-04-27 10:16
 */
public class RunnableImpl implements Runnable {
    public void  run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程");
    }
}

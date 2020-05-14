package com.thread;

/**
 * @author 张闯
 * @create 2020-04-27 22:05
 */
public class GuKe extends Thread{
    private BaoZi baoZi;
    public GuKe(BaoZi baoZi){
        this.baoZi=baoZi;
    }
    @Override
    public void run() {
       while (true){
           synchronized (baoZi){
               if(baoZi.getFalg().equals(true)){

                   System.out.println("吃包子");
                   try {
                       System.out.println("正在吃"+baoZi.getPi()+baoZi.getXian());
                       Thread.sleep(5000);
                       baoZi.setFalg(false);
                       System.out.println("吃完了还要再来一个");
                       System.out.println();
                       baoZi.notify();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               try {
                   System.out.println("等待做包子");
                   Thread.sleep(5000);
                   baoZi.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }
}

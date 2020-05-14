package com.thread;

/**
 * @author 张闯
 * @create 2020-04-27 21:26
 */
public class BaoZiPu extends Thread{
    private BaoZi baoZi;
    public BaoZiPu(BaoZi baoZi){
        this.baoZi=baoZi;
    }
    //生产包子线程
    @Override
    public void run() {
        while (true){
            int count=0;
            synchronized (baoZi){
                if(baoZi.getFalg().equals(true)){
                    try {
                        System.out.println("已经有包子，该吃包子了");
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("正在生产包子");
                try {
                    Thread.sleep(5000);
                    baoZi.setFalg(true);
                    if(count%2==0){
                        baoZi.setPi("薄皮");
                        baoZi.setXian("三鲜馅");
                    }else{
                        baoZi.setPi("脆皮");
                        baoZi.setXian("牛肉馅");
                    }
                    baoZi.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }

        }
    }
}

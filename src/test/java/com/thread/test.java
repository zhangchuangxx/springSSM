package com.thread;

/**
 * @author 张闯
 * @create 2020-04-27 17:18
 */
public class test {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        baoZi.setFalg(false);
        new Thread(new BaoZiPu(baoZi)).start();
        new Thread(new GuKe(baoZi)).start();
    }
}

import java.util.ArrayList;
import java.util.List;


/**
 * @author 张闯
 * @create 2020-04-24 11:14
 */
public class Test {
    public static void main(String[] args) {

        new Thread(()->{ System.out.println(Thread.currentThread().getName());}).start();
    }



    //冒泡排序
    public static void test(int a[]){
        int i,j;
        for(i=0;i<a.length-1;i++){
            for(j=0;j<a.length-1-i;j++){
                int temp;
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        System.out.println(a.toString());
//        for(int b:a ){
//            System.out.println(b);
//        }

    }
}

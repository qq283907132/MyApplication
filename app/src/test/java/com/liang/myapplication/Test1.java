package com.liang.myapplication;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Test1 {
    private int a[] = {3, 2, 5, 7, 6, 8};

    @Test
    public void myTest() {
        Father fs = new Son();//向上转型,不需要强转
        fs.print();//方法相同 调用的是子类方法。因为子类重写了父类方法.如果想用父类方法，需要在子类使用super
        int a = fs.a;//调用的是父类的方法
        System.out.println("this a " + a);
        Father father = new Father();
        //Son son1=(Son)father;//编译无错，但是运行会出错 classCastException
        Son son = (Son) fs;//向下转型  因为fs是父类引用，指向子类对象
        int b = son.b;//转型后可以调用子类的的方法

        Son son2 = new Son();
        Father father1 = son2;//向上转型
        int c = ((Son) father1).b;//向上转型时 b会遗失除与父类对象共有的其他方法；可以用向下转型在重新转回，这个和向上转型的作用要结合理解。
        System.out.println(c);


    }

    /**
     * 冒泡 算法  升序
     */
    @Test
    public void myTest2() {
        //外层循环 确定的是比较的总次数
        for (int i = 1; i < a.length; i++) {
            //里层循环，比较一个数字需要比较多少次，比较第一次需要5次，第二次需要比较4次，递减的
            for (int j = 1; j < a.length - i; j++) {
                //把比较大的一位
                if (a[j - 1] > a[j]) {
                    //把大的一位赋值给临时变量
                    int temp = a[j - 1];
                    //把小的放在了前面一位
                    a[j - 1] = a[j];
                    //再把大的放在后面一位
                    a[j] = temp;

                }
            }
        }

        System.out.println("结果：" + Arrays.toString(a));
    }

    /**
     * 冒泡 算法  降序
     */

    @Test
    public void myTest3() {
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= a.length - i; j++) {
                //比较小的 元素值
                if (a[j - 1] < a[j]) {
                    //把小的元素值放在临时变量
                    int temp = a[j - 1];
                    //大的放在前面
                    a[j - 1] = a[j];
                    //小的往后面放
                    a[j] = temp;
                }
            }
        }
        System.out.println("结果：" + Arrays.toString(a));

    }

    /**
     * 快速排序算法
     */
    @Test
    public void myTest4() {
      //  quickSort1(a, 0, a.length - 1);
      //  System.out.println("结果：" + Arrays.toString(a));
        // Fibonaccisequence();
       // number();
      //  number2();
        sore();
    }


    public void quickSort1(int[] a, int low, int height) {
        int i, j, t, temp;
        i = low;
        j = height;
        if (low > height) {
            return;
        }

        //确定一个基准值
        temp = a[low];

        while (i < j) {
            while (temp <= a[j] && i < j) {
                j--;
            }
            while (temp >= a[i] && i < j) {
                i++;
            }
            //替换 大和小的元素值
            if (i < j) {
                t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }

        //退出循环后，证明两元素相等碰撞，这时确定了这一轮的基准值重新确定新基准值,用i元素 就是最左边，替换原来的基准值
        a[low] = a[i];
        a[i] = temp;
        //先从左边开始递归
        quickSort1(a, low, height - 1);
        //再从右边开始递归
        quickSort1(a, low + 1, height);
    }

    /**
     * 菲波拉契数列
     */
    public void Fibonaccisequence() {
        System.out.println("第一个月 1");
        System.out.println("第一个月 1");
        int f1 = 1;
        int f2 = 1;
        int f;
        int m = 24;
        for (int i = 3; i <= m; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println("第" + i + "个月生了..." + f2);
        }
    }

    /**
     * 输出101-200所有的素数
     */

    public void number() {
        int count=0;

       for(int i=101;i<200;i+=2){
           boolean bool=false;
           for(int j=2;j<i;j++){
               if(i%j==0){
                   bool=false;
                 break;
               }else{
                   bool=true;
               }
           }
           if(bool){
               count++;
           }
            System.out.println(i);
       }
       System.out.println(count);
    }

    /**
     * 水仙花数  是一个三位数，是各位数的三次方相加的结果，比如 153，1*1*1+5*5*5+3*3*3=1+125+8=153
     */

    public void number2(){
      int a,b,c;
      for(int i=101;i<1000;i++){
          //百位数
          a=i/100;
          //十位
          b=i%100/10;
          c=i%10;
          if(a*a*a+b*b*b+c*c*c==i){
              System.out.println("水仙花数："+i);
          }

      }
    }

    /**
     * 利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示
     */
  public void  sore(){
      double sore=89;
      char level;
      level=sore>=90?'a':sore>=60?'b':'c';
      System.out.println(level);
  }

    /**
     * 静态代理测试
     */

    @Test
    public void prx(){
      /*  ShopInteface interfacelmpl=new ShopInterfacelmpl();
        Object[] thing=interfacelmpl.shopping(200);
        System.out.println(Arrays.toString(thing));
        interfacelmpl=new ShoppingProxy(interfacelmpl);
        Object[] thing1= interfacelmpl.shopping(200);
        System.out.priObjectntln(Arrays.toString(thing1));*/

        // 原始的厂家
        ShopInteface women = new ShopInterfacelmpl();

        System.out.println(Arrays.toString(women.doShopping(100)));

        // 换成代购 静态代理
       /* women = new ShoppingProxy(women);

        System.out.println(Arrays.toString(women.doShopping(100)));*/

       //动态代理

        women= (ShopInteface) Proxy.newProxyInstance(ShopInteface.class.getClassLoader(),women.getClass().getInterfaces(),new ShoppingInvocaHandler(women));
        System.out.println(Arrays.toString(women.doShopping(100)));

    }

    @Test
    public void ObserverTest(){
        ObserverableImpl observerable=new ObserverableImpl();
        ObserverInterface girl=new ObserverImplgril("小萌");
        ObserverInterface  boy=new ObserverImplboy("小亮");

        observerable.add(girl);
        observerable.add(boy);
       observerable.remove(girl);
        observerable.mnotify("取快递");



    }
  public void mObserver(){

      Observable.create(new ObservableOnSubscribe<Object>() {

          @Override
          public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
              emitter.onNext("frist");
              emitter.onComplete();
          }
      }).subscribe(new Observer<Object>() {
          Disposable mDisposable;

          @Override
          public void onSubscribe(Disposable d) {
              mDisposable=d;
          }

          @Override
          public void onNext(Object o) {
              String msg=(String)o;
              System.out.println(msg);
          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onComplete() {

          }
      });
  }
}

package com.liang.myapplication;

public class SingletonTest {
    private volatile static  SingletonTest  mSingleton=null;

    public SingletonTest() {
    }

     public static  SingletonTest  getInstance(){
          if(mSingleton==null){
              synchronized (SingletonTest.class){
                  if(mSingleton==null){
                      mSingleton=new SingletonTest();
                  }
              }
          }


        return mSingleton;




     }
}

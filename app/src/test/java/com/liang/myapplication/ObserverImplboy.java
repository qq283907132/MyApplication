package com.liang.myapplication;

public class ObserverImplboy implements ObserverInterface {
 private String name;

    public ObserverImplboy(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
       System.out.println(name+"收到了信息自己去"+message);
    }


}
class ObserverImplgril implements ObserverInterface{

    private String name;

    public ObserverImplgril(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name+"收到了信息叫男朋友去"+message);
    }
}
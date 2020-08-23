package com.liang.myapplication;

public interface ObserverableInterface {
    /**
     * 订阅者 被观察者 可以添加 删除 更新 观察者
     */

    void  add(ObserverInterface o);
    void  remove(ObserverInterface o);
    void  mnotify(String message);
}

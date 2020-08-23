package com.liang.myapplication;

import java.util.ArrayList;
import java.util.List;

public class ObserverableImpl implements  ObserverableInterface{

    private List<ObserverInterface> observers=new ArrayList<>();

    @Override
    public void add(ObserverInterface o) {
       observers.add(o);
    }

    @Override
    public void remove(ObserverInterface o) {
     observers.remove(o);
    }

    @Override
    public void mnotify(String message) {
       for(ObserverInterface i: observers){
           i.update(message);
       }
    }
}

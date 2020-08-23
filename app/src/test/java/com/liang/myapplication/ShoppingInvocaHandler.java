package com.liang.myapplication;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ShoppingInvocaHandler implements InvocationHandler {
   ShopInteface  base;
    public ShoppingInvocaHandler(ShopInteface base) {
        this.base=base;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("doShopping".equals(method.getName())){
            double money=(double)args[0];
            double price=money*0.5+money;
            Object[] object=(Object[]) method.invoke(base,price);
            if(object!=null&& object.length>0){
                object[0]="动态代理来了黑了一双鞋子";
            }
              return  object;
        }

        return null;
    }
}

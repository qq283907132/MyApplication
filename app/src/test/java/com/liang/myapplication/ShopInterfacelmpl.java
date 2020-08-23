package com.liang.myapplication;

public class ShopInterfacelmpl implements ShopInteface {

    @Override
    public Object[] doShopping(double price) {
        System.out.println("自己花了"+price);
        String []thing=new String[]{"棒棒糖，鞋子，衣服"};
        return new Object[] { "鞋子", "衣服", "零食" };//
       /* System.out.println("逛淘宝 ,逛商场,买买买!!");
        System.out.println(String.format("花了%s块钱", price));
        return new Object[] { "鞋子", "衣服", "零食" };*/
    }
}

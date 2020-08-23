package com.liang.myapplication;

public class ShoppingProxy implements ShopInteface {
  ShopInteface shop;
    public ShoppingProxy(ShopInteface shopInteface) {
        this.shop=shopInteface;
    }

    @Override
    public Object[] doShopping(double price) {

        // 先黑点钱(修改输入参数)
        long readCost = (long) (price * 0.5);

        //System.out.println(String.format("花了%s块钱", readCost));

        // 帮忙买东西
        Object[] things = shop.doShopping(readCost);

        // 偷梁换柱(修改返回值)
        if (things != null && things.length > 1) {
            things[0] = "被掉包的东西!!";
        }
        return things;



/*        double price2=(double) (price*0.5);
            System.out.println("代理花了"+price2);
            Object[]thing=shop.shopping(price2);
            if(thing!=null &&thing.length>0){
                thing[0]="被调包的";
            }
        return thing;*/
    }
}

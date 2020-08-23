package com.liang.myapplication

import org.junit.Test

class TestKotiln (){

    @Test
    fun mytest(){
       var p=Test2()
        p.last="mimi"
        println("mimi:${p.last}")
        p.sore=50
        println("sore: ${p.sore}")
        p.sore=9
        println("sore:${p.sore}")

        val t=KotlinConstructorTest("fuck..",1000)
        println(t.name)
        println(t.url)
        val f= ExampleUnitTest.testfun()
        val t1= ExampleUnitTest.test3(f)

        val demo = KotlinConstructorTest("q",1).Inner().foo()
        println(demo) //   1
        val demo2 = KotlinConstructorTest("qaa",111).Inner().innerTest()
       // println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性
        mytest1()


    }
   fun   mytest1(){
       val  k= KotlinConstructorTest("lala")
       var sum=k.sum(1,2)
       println(sum)
       var sum2=k.sum1(3,4)
       println(sum2)
       /**
        * 采用对象表达式来创建接口对象，即匿名内部类的实例。
        */
       k.setInterFace(object :TestInterFace{
           override fun test() {
               print("对象表达式创建匿名内部类的实例")
           }
       })
   }

}
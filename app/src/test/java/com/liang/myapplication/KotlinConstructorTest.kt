package com.liang.myapplication

 class KotlinConstructorTest constructor(str:String){
    var url:String="www.baiduwawwa.com"
    var name=str
    var temp :String="yes"
     var v:String="no"
    /**
     * 主构造
     */
    init {
        println("本站地址是:${str}")
    }

    /**
     * 次构造
     */
    constructor(str1:String,num :Int):this(str1){
      println("本次得分：$num")
    }

     fun setInterFace(i:TestInterFace){
      i.test()
     }

       fun  sum (a:Int,b:Int)=a+b
      fun sum1 (a:Int,b:Int):Int=a+b

    /**
     * 内部类
     */

    /**嵌套内部类**/
    inner class Inner {
        fun foo() = temp  // 访问外部类成员
        fun innerTest() {
            var o = this@KotlinConstructorTest //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }



}
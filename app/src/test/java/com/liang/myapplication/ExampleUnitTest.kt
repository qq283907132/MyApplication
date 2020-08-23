package com.liang.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test1() {
        test2()
        test3(30, "test")
    }

    var a: Int = 1
    var b: String = "myFrist"
    var c: Double = a.toDouble()
    val str: String = "MYTAG"
    fun test2() {
        var d: Int = 1
        d += a
        println(d)
    }

    fun test3(a: Int, str: String): String {
        var e: String = "my"
        e += str
        print("${a}${e}")
        return e
    }

   open class testfun {

        private val a1: Int = 1
        protected open val b1: Int = 2
        val c1: Int = 3
        internal val d1: Int = 4;
    }
    protected class noter (){
        val e1 :Int=5
    }
    class test : testfun(){
       override val b1:Int=22
        fun b(){
            print(b1)
        }
    }

    class test3 constructor(test:testfun){
        init {
            val site=test
            val c=site.c1
            val d=site.d1
            print(c+d)
        }


        @Test
        fun mytest(){

        }

    }

}






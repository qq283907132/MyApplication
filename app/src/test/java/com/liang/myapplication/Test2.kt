package com.liang.myapplication

import org.junit.Test

class Test2 {
    var last:String="wanwan"
        get() = field.toUpperCase()
        set

    var sore:Int=1
        get() = field

        set(value) {
            if (value>10) {
                field=value
            }else{
                field=-1
            }

        }

    @Test
  fun test1(){
  }
}
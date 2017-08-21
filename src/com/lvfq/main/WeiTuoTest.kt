package com.lvfq.main

import org.omg.CORBA.portable.Delegate

/**
 * WeiTuoTest
 * @author lvfq
 * @date 2017/7/12 下午3:41
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    var a = BaseImpl1(20)
    var b = BaseImpl2("base2")
    var c = BaseImpl3(true)

    var array = mutableListOf<Base>()
    array.add(a)
    array.add(b)
    array.add(c)
    WeiTuoTest(array).map { it.print() }


}



class WeiTuoTest(b: MutableList<Base>) : List<Base> by b

interface Base {
    fun print()
}

class BaseImpl1(var value: Int) : Base {
    override fun print() {
        println("this is base impl 1 : " + value)
    }

}

class BaseImpl2(var value: String) : Base {
    override fun print() {
        value += " , BaseImpl2"
        println(value)
    }

}

class BaseImpl3(var value: Boolean) : Base {
    override fun print() {
        if (value)
            println("this is base impl 3 value : " + value)
        else
            println("this is 3 else ")

    }

}
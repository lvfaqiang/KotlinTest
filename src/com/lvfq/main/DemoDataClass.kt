package com.lvfq.main

/**
 * DemoDataClass
 * @author lvfq
 * @date 2017/6/4 上午1:34
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    var demo = DemoDataClass()
    demo.test()
}

class DemoDataClass {
    fun test() {
        var data = BaseData("param1", 2, true)
        println("data param : ${data.a}")
        println(data.component1())   // component1...n  这是系统根据参数个数生成的，
    }
}
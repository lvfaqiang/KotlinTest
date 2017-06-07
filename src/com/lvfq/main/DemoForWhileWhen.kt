package com.lvfq.main

/**
 * DemoForWhileWhen
 * @author lvfq
 * @date 2017/6/4 上午12:46
 * @mainFunction :
 *
 */

fun main(args: Array<String>) {
    var demo1 = DemoForWhileWhen()
//    demo1.testForIndex()
//    demo1.testWhen1(5)
    demo1.textWhen2()

}

class DemoForWhileWhen {
    /**
     * 测试for 循环
     */
    fun testForIndex() {
        var items = listOf("1", "2", 3, "4", 5)
//        for (i in items) {    // 等同于 for each
//            println(i)
//        }
        for (i in items.indices) {  // 等同于  for(int i =0;i< length;i++)
            println(items[i])
        }
    }

    /**
     * 测试 when 表达式
     * 带参数
     */
    fun testWhen1(obj: Any) {
        when (obj) {    // 等同于 switch case ，但是比 switch 更好用。遇到对的条件执行完之后，就直接退出了，不继续走了
            is String -> println(obj + " ," + obj.javaClass)
            is Int -> println(obj.toString() + "" + obj.javaClass)
            5 -> println("输入值为 5 ")
            true -> println(obj.toString() + obj.javaClass)
            else -> println("相当于 default")
        }
    }

    /**
     * 测试 when 表达式
     * 不带参
     */
    fun textWhen2() {
        var list = listOf("orange", "red", "white", "black", "yellow")
        when {
            "orange" in list -> {
                print("this is have orange ")
            }
            "red" in list -> {
                print("this is have red ")
            }

        }
    }


}
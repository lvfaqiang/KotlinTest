package com.lvfq.main

/**
 * DemoRange
 * @author lvfq
 * @date 2017/6/4 上午1:01
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    var demo = DemoRange()
    var b = demo.testRange(10)
    println(b)
//    demo.testList()
//    demo.testStep(3)

}

class DemoRange {
    fun testRange(obj: Any): Boolean {
        return obj in 0..10   //闭区间 包括 10
//        return obj in 0 until 10    // 半开区间，不包括 10
    }

    var list = listOf("a", "b", 4, "c")

    fun testList() {
        if ("a" in list) {
            println("a index of : " + list.indexOf("a"))
        }
        println(list.indices)   // list.indices 获取当前列表的下标区间，

        if (3 in list.indices) {
            println(list.size)
        }
    }

    fun testStep(step: Int) {
        // step 关键字 表示两个元素之间跳过了多少个元素，不够则抛弃。必须是配合区间使用。
//        for (x in list.indices step step) {
//            println(list[x])
//        }
        // downTo 表示倒序输出到几
        for (x in list.size downTo step) {
            println(x)
        }
    }
}
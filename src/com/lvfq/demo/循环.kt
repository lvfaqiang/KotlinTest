package com.lvfq.demo

/**
 * 循环
 * @author lvfq
 * @date 2018/7/31 下午11:23
 * @mainFunction :
 *
 */

fun main(args: Array<String>) {

    for (i in 1..10) {  // 输出 1 到 10
//        println(i)
    }

    for (i in 1 until 10) { // 输出 1 到 9 ，不包括 10
//        println(i)
    }

    for (i in 10 downTo 1) {    // 输出 10 到 1
//        println(i)
    }

    for (i in 1..10 step 2) {   // 每次增加 2    = for (i = i ;i<= 10 ; i+=2)
//        println(i)  // 输出 1，3，5，7，9
    }

    // 属于一个高阶函数 ，times 是当前闭包 循环执行的次数
    repeat(10) {
        // 输出 0 到 9
//        println(it)
    }
    println("-----------------")

    val items = listOf("1", "2", 3, "4", 5)
    for (i in items) {    // 等同于 for each
//        println(i)
    }

    for (i in items.indices) {  // 等同于  for(int i =0;i< item.size;i++)
//        println(items[i])
    }

    // List 也能通过 解构 进行获取 index， 以及对应数据
    for ((index, item) in items.withIndex()) {
        println("$index  ->  $item")
    }

}
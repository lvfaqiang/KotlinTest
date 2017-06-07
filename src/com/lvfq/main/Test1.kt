package com.lvfq.main

/**
 * Test1
 * @author lvfq
 * @date 2017/6/5 下午3:06
 * @mainFunction :
 *
 */

fun main(args: Array<String>) {
    println(lock("param1", "param2", ::getResult))
    var t = Test1()
    t.test1()
}

/**
 * @param str1 参数1
 * @param str2 参数2
 */
fun getResult(str1: String, str2: String): String = "result is {$str1 , $str2}"

/**
 * @param p1 参数1
 * @param p2 参数2
 * @param method 方法名称
 */
fun lock(p1: String, p2: String, method: (str1: String, str2: String) -> String): String {
    return method(p1, p2)
}

fun lock1(content: String, method: () -> String): String {
    return method()
}

fun isOdd(x: Int) = x % 2 != 0

class Test1 {


    fun test() {
        var list = listOf(1, 2, 3, 4, 5)
        println(list.filter(::isOdd))
    }

    fun test1() {
        var map = mutableMapOf<String, String>()
        map.put("1", "value1")
        map.put("2", "value2")
        map.put("3", "value3")
        map.put("4", "value4")
        map.map(::testMap)

    }
}

fun testMap(map: Map.Entry<String, String>) {
    println("key : ${map.key} , value : ${map.value}")
}

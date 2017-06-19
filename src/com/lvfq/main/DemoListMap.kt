package com.lvfq.main

/**
 * DemoListMap
 * @author lvfq
 * @date 2017/6/4 上午2:18
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    var demo = DemoListMap()
    demo.test()

    println(lock("param1", "param2", ::getResult))
    var t = Test1()
    t.test()
}

class DemoListMap {
    var list = mutableListOf<Any>()

    fun test() {
        val mutableMapOf = mutableMapOf<Any, Any>()
        var map = LinkedHashMap<Any, Any>()
        emptyMap<Any, Any>()
        var l = listOf<Any>()

        var s: String? = null
        s?.let {
            println(it + "test")
            println(it + "run")
        }
        s ?: println(s.toString())


//        println(s?.length)
        list.add("item")
        list.add("item")
        list.add("item")
        list.add("item")


//        println(list?.size)

    }
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
//        list.map {
//            println(it.toString() + " , 执行前")
//            if (it == 2) return@map
//            println(it)
//        }

        loop@ for (i in 1..100) {
            if (i == 3) break@loop
            println(i)
        }
        println(list.filter(::isOdd))
    }

    fun test1() {
        var map: MutableMap<String, String>? = null
        map ?: let {
            // map = null 执行
            println("----------------")
        }

        map?.let {
            // map != null 执行
        }
        // 如果map 不是null，返回 map.size , 如果map是null 接着进行后面执行，
        println("map size1 : " + (map?.size ?: throw RuntimeException("NullPointerException")))

//        map.put("1", "value1")
//        map.put("2", "value2")
//        map.put("3", "value3")
//        map.put("4", "value4")
//        map.map(::testMap)
//        for ((k, v) in map) {
//            println("$k  ->  $v")
//        }

        println("map size1 : " + map?.size)
    }

}


fun testMap(map: Map.Entry<String, String>) {
    println("key : ${map.key} , value : ${map.value}")
}

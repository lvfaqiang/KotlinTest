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
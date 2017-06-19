package com.lvfq.main

/**
 * TryCatch
 * @author lvfq
 * @date 2017/6/8 上午10:27
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    var tryCatch = TryCatch()
//    tryCatch.test()
    tryCatch.test1("", tryCatch, 2.0f, 1, true)
}

class TryCatch {
    fun test() {
        var result = try {
            arrayListOf<Any>()[0] as Int
        } catch (e: Exception) {
            throw e
        }
        println("result : " + result)
    }

    fun test1(vararg fruits: Any) {
        fruits.map { println(it.javaClass) }
    }
}
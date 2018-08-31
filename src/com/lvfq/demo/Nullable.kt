package com.lvfq.demo

/**
 * Nullable
 * @author lvfq
 * @date 2018/8/20 下午11:11
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    val a: String = ""

    println(getValue(a))

}

fun getValue(s: String): String {
    return "1" + s.length
}

fun getValue1(s: String?): String {

    // .let{} 是直接执行， ?.let{} 是如果不为空，则执行。
    s?.let {
        return "result: $it"
    }
    return ""
}
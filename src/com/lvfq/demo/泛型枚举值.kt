package com.lvfq.demo

/**
 * 泛型枚举值
 * @author lvfq
 * @date 2018/8/31 下午5:06
 * @mainFunction :
 *
 *  把泛型作用与枚举值上。
 */
enum class RGB {
    RED, GREEN, BLUE
}

inline fun <reified T : Enum<T>> printAllValues() {
    println(enumValues<T>().joinToString { it.name })
}


fun main(args: Array<String>) {
    printAllValues<RGB>()
}
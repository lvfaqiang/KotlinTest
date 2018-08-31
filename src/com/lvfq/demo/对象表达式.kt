package com.lvfq.demo

/**
 * 对象表达式
 * @author lvfq
 * @date 2018/8/31 上午10:52
 * @mainFunction :
 *
 *
 *  对象声明 和 对象表达式的区别是
 *
 *  1，对象表达式在我们使用的地方立即初始化，并执行。
 *  2，对象声明是懒加载的，是在我们第一次访问时初始化的。
 *  3，伴随对象是在对应的类加载时初始化的，和 Java 的静态初始是对应的
 */

// 对象声明
open class A(value: Int) {
    public open val y = value
}

interface B {
    fun getValue(): String
}

val ab: A = object : A(1), B {
    override fun getValue(): String {
        return y.toString()
    }

    override val y: Int = 14
}

// 对象表达式
val ab1: B = object : A(1), B {
    override fun getValue(): String {
        return y.toString()
    }

    override val y: Int = 14
}

fun main(args: Array<String>) {
    println(ab.y)

    println(ab1.getValue())
}
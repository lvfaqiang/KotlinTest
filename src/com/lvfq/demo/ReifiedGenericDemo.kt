package com.lvfq.demo

/**
 * ReifiedGenericDemo
 * @author lvfq
 * @date 2018/8/5 下午6:51
 * @mainFunction :
 *
 * Kotlin 中的真泛型，用 reified 修饰 并且 必须是 inline 函数，
 *  通俗来说，就是明确泛型的类型，
 */

class Presenter {
    override fun toString(): String {
        return "Presenter"
    }
}

/**
 *  这种写法更多的适用于 Android 用的 MVP 模式
 */
class View<T>(private val clazz: Class<T>) {
    val presenter by lazy { clazz.newInstance() }

    companion object {
        // operator 操作符的重定向
        inline operator fun <reified T> invoke() = View(T::class.java)
    }
}


fun main(args: Array<String>) {
    val a = View<Presenter>().presenter
    val b = View.Companion.invoke<Presenter>().presenter
    println(a.hashCode())
    println(b.hashCode())
}
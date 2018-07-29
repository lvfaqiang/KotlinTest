package com.lvfq.demo

import kotlin.math.abs

/**
 * Lambda
 * @author lvfq
 * @date 2018/7/29 下午4:48
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    /**
     * 关于 Kotlin 中的 Lambda 表达式
     *
     * 1， 如果 lambda 没有参数，可以省略箭头符号
     * 2, 如果 lambda 是函数的最后一个参数，可以将大括号放在小括号的外面去表示。
     * 3， 如果函数只有一个参数，并且这个参数是 Lambda 则可以省略小括号。
     *
     */

    val thread = Thread(Runnable { })
//    thread.start()

    /**
     * Kotlin 的 Lambda 参数系统声明的最多 22 个参数，这里如果想调用 23个或者更多需要新建 Function23(n)
     * 创建方式如 kotlin 包下的 Function23 ，以下是 23个参数的测试。运行正常
     */
    val method =
            { q: Int, w: Int, e: Int, r: Int, t: Int, y: Int, u: Int, i: Int,
              o: Int, p: Int, a: Int, s: Int, d: Int, f: Int, g: Int, h: Int,
              j: Int, k: Int, l: Int, z: Int, x: Int, c: Int, v: Int ->
                println("test lambda params")
            }

    method(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)


    /**
     *   高阶函数
     */


    val runnable = Runnable {
        println("Runnable::run")
    }

    val function: () -> Unit
    function = runnable::run    // 表示对 Runnable 的 run 函数的引用
    val nameMethod = { "Name" }

    onlyIf(nameMethod(), function, "")

    fun lambdaCenter(name: String, method: () -> Unit, param: String) {
        println(name)
        method()
    }
    /**
     * 如果参数中有 lambda 函数，调用方式如下 ， 如果有参数，则可以使用 {x:Any.. -> 执行代码块}
     */
    lambdaCenter("name", { println("this is method") }, "")

    fun lambdaEnd(name: String, method: (String) -> String) {
        println(method.invoke(name))
    }
    /**
     * 如果lambda 函数为最后一个参数，调用方式如下
     */
    lambdaEnd("发强") {
        it + "lambda Content"
    }


    // 声明一个 lambda 函数
    fun lambda1(method: (String) -> String) {
        println(method("--------"))
    }

    fun lambda2(method: (String) -> String): String {
        return method("--------")
    }
    // 如果参数只有一个 lambda 表达式，调用方式如下。x 为形参（也可以是 a,b,c 等任意字符)
    lambda1 { x -> x + " . " }
    println(lambda2 { it + "lambda2" } + "Add String")


    /**
     *  Kotlin 闭包
     *  类型 变量名 = { 赋值/闭包体}
     *  如果闭包没有参数，则直接写闭包体，可以省略 -> 箭头符号。
     *
     *
     *  关于  闭包 (https://blog.csdn.net/qibin0506/article/details/73395115)
     *
     */


    val func1 = { /*闭包参数*/ x: Int, y: Int ->
        println(x + y)/* 闭包体*/
    }
    func1(1, 9)


    /**
     * 柯里化（英语：Currying），
     * 是把接受多个参数的函数变换成接受一个单一参数（最初函数的第一个参数）的函数，并且返回接受余下的参数而且返回结果的新函数的技术。
     */

    val b = fun(x: Int): (Int) -> Int {
        println("------------1 ")
        return fun(y: Int): Int {
            println("------------2 ")
            return x + y
        }
    }
    val h = { x: Int ->
        { y: Int ->
            x + y
        }
    }
    // 以上这两种写法是一样的，

    val c = b(10)   // 这里会输出 -------1
    println(c(20))  // 输出 30    这里再输出 -------2
    val d = h(10)
    println(d(20))  // 输出 30

}

/**
 * inline 会减少不必要的对象创建，编程直接编译为代码块
 *
 * 一般情况 inline 只是用来修饰 高阶函数（有lambda 函数为参数的函数）

 * 也就是说 它会把 method() 方法中的执行代码，直接拿出来，放到 onlyIf 代码块中，
 *
 * 过度使用 inline 会导致代码过于庞大，造成编译器负担
 */
inline fun onlyIf(name: String, method: () -> Unit, param: String) {
    println(name)
    method()
}
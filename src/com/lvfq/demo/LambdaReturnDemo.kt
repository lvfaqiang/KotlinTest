package com.lvfq.demo

/**
 * LambdaReturnDemo
 * @author lvfq
 * @date 2018/8/5 下午5:55
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {

    /**
     * 在 Kotlin 中 内部 lambda 表达式是不允许中断外部函数执行。 eg: test1()
     *
     * 内联函数（inline 修饰）的 lambda 表达式中可以中断外部函数的执行。eg: test2()
     *
     * crossinline 不允许 inline 的 lambda 中断外部函数执行 eg: test3()
     */


    test1 {
        println("test1 hello")
        return@test1    // 这里的 return 只能返回 test1 函数执行
        println("after retrun ")
    }
    println("hello")

//    test2 {
//        println("test2 hello")
//        return      // 这里的 return 直接中断了 test2 方法之后的代码执行
//    }
//    println("hello2")

    test3 {
        println("test3 hello")
        return@test3    // 这里不允许类似 test2 中的 直接使用 return ,虽然 test3 也是 inline 函数，但是 lambda 有 crosinline 修饰，所以不能中断外部函数执行
        println("test3_ after")
    }
    println("hello3")


    test4({
        println("test4 hello")
    }, {
        println("noinline test4")
    })

}

fun test1(t: () -> Unit) {
    t.invoke()
    return
}

inline fun test2(t: () -> Unit) {
    t.invoke()
    println("in test2 method ")
    return
}

inline fun test3(crossinline t: () -> Unit) {
    t.invoke()
}

inline fun test4(m: () -> Unit, noinline t: () -> Unit): () -> Unit {   // 编译后，m 被内联到 main 函数中，但是 t 方法 编译后生成 new Function0() 方法，单独执行，
    m.invoke()
    t.invoke()
    return t
}

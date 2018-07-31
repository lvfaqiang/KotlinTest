package com.lvfq.demo

/**
 * 解构
 * @author lvfq
 * @date 2018/7/31 下午11:08
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    //
    // 在 Kotlin 中 允许将一个类拆解，分别赋值

    // 解构 它可以自动的帮我们将一个对象，拆解成若干个变量，分别赋值

    /**
     * 这里需要注意，如果 User 是数据（data class）类型，则不需要 写 component 函数，默认对应其构造函数(编译后自动生成 component 函数 对应其构造函数的顺序)，
     * 如果 User 是 普通（Class）类型，则需要手动实现 component 函数
     */
    val user = User(18, "发强", "man")
    val (a, n, s) = user
    println("$a , $n")

    // 解构常用于遍历 Map,
    val map = mapOf<String, String>("key1" to "value1", "key2" to "value2")
    for ((k, v) in map) {
        println("$k - $v")
    }

}

data class User(var age: Int, var name: String, var sex: String) {
    /**
     * 解构的写法是固定的，必须是 component1 , component2 .. componentN
     *
     * component1 ,component2 就表示 上面  val(a , n) = user 的第一个参数，第二个参数甚至更多。
     *
     */

//    operator fun component2() = name
//
//    operator fun component1() = age
}
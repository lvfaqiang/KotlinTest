package com.lvfq.demo

/**
 * 作用域函数
 * @author lvfq
 * @date 2018/8/1 下午10:08
 * @mainFunction :
 *
 */

/**
 * 作用域函数： Kotlin 内置的一系列可以对数据做一个变换的函数，
 * 他们与集合的操作符非常相似，但是，集合的操作符只适用于集合的数据变化，
 * 而作用域函数，适用于所有对象进行一系列的操作
 */

val dec = """
    常用的作用域函数有以下几种。
    run{}
    with(T){}
    let{}
    apply{}
    also{}

""".trimIndent()


data class Model(var name: String)

fun main(args: Array<String>) {
    val model = Model("Test")

    /**
     *  let 与 run 都会返回闭包的执行结果， 区别在于，let 有闭包参数， run 没有闭包参数
     *
     *  let闭包中的参数，就是当前调用 let 方法的对象，
     *  如果声明了参数，则通过参数进行数据变换操作，如果没有声明参数，则默认使用 it 表示当前对象,
     *  (这也是 Kotlin 中 lambda 的一个特性，如果只有一个参数，则可以省略，并使用 it 表示)
     *
     *  run 闭包没有参数，所以在 run 的闭包中， 通过 this 来表明当前调用 run 方法的对象，
     */

//    val letResult = model.let { model: Model -> "let::${model.name}" }
    val letResult = model.let { "let::${it.name}" }
    println(letResult)
    val runResult = model.run { "run::${this.name}" }
    println(runResult)

    // apply 和 also  都不返回闭包的执行结果, 返回的是调用者本身。
    // ，区别在于 also 有闭包参数，apply 没有闭包参数，其他基本雷同于 let 和 run

    model.apply {
        println("apply::${this.name}")
    }

    model.also { model: Model ->
        println("also::${model.name}")
    }
    model.also {
        println("also::${it.name}")
    }

    model.also {
        println("apply::${it.name}")
    }.apply {
        println("apply::${this.name}")
    }.name = "FaQiang"


    /**
     *  takeIf , takeUnless 是 1.1 版本之后新增的 两个作用域函数，
     *  takeif 的闭包返回的是一个判断结果，Boolean 类型，如果是 false ,则返回一个 Null
     *  tackUnless 则于 takeIf 完全相反
     */
    model.takeIf { it.name.isNotEmpty() }?.also { println("name: ${it.name}") } ?: println("name is Null")
    model.takeUnless { it.name.isEmpty() }?.also { println(" Name : ${it.name}") } ?: println("name is Null")

    // 重复执行当前闭包语句 times 次   源码借助于 for 循环执行。
    repeat(3) {
        // it 表示当前执行的第几次 （从 0 开始）
    }

    /**
     * with 比较特殊，不是以扩展函数的形式存在， 而是一个顶级函数
     *
     * 一下代码等同于 ：
     *
     * with 代码会被转换成 这种操作  model.apply{this.name="with"}
     *
     * 在 Android 中 作为一个工具类，进行统一设置多个 model 的相同属性。
     */

    with(model) {
        this.name = "with"
    }


}
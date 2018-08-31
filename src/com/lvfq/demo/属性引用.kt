package com.lvfq.demo

import kotlin.reflect.jvm.javaField

/**
 * 属性引用
 * @author lvfq
 * @date 2018/8/31 下午4:11
 * @mainFunction :
 *
 *
 *  双冒号 :: 表示引用当前属性、函数 本身，而不是引用它的执行结果。
 *
 *  eg:  val value = fun getResult(){ return "result"}
 *  ::value  这里的引用，表示直接引用了这个函数 ，他就表示一个 ()->String 类型的 参数。
 *
 */
class MyClass {

}

// 类引用
val c = MyClass::class  // 引用的是 KClass 类型


// 函数引用

fun isOdd(x: Int) = x % 2 != 0

val numbers = listOf(1, 2, 3)

// 函数组合
fun <A, B, C> compose(g: (A) -> B, f: (B) -> C): (A) -> C {
    return { x -> f(g(x)) }
}


// 属性引用
var x = 1

class P(val p: Int)


fun main(args: Array<String>) {
    // 这里是把 isOdd 函数作为一个属性值传递进来。 这个属性的值就是 （Int) -> Boolean
    println(numbers.filter(::isOdd))    // print  [1, 3]

    //    -------------

    fun length(s: String) = s.length
    val c = compose(::length, ::isOdd)

    val strings = listOf("a", "ab", "abc")
    println(strings.filter(c))  // print [a, abc]

    //    -------------
    属性引用()


    Java反射()
}

fun 属性引用() {
    println(::x.get())
    ::x.set(2)
    println(x)

    val pop = P::p
    println(pop.get(P(2)))  // print 2
}

//  与 Java 反射调用
fun Java反射() {
    class A(val p: Int)

    println(A::p.getter)
    println(A::p.javaField)

}


fun 构造函数引用() {
    class Foo {}

    fun function(foo: () -> Foo) {

    }

    function(::Foo) // 引用构造函数

}
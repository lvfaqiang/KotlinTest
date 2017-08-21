package com.lvfq.main

/**
 * MethodExtend
 * @author lvfq
 * @date 2017/7/11 下午1:33
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    var a = A()
    var b = B()
    // test 方法的形参是 A类型，那么传入B 类型时，依然调用的是 A 类型中的方法，
    test(b)

    MyClass.foo()
    MyClass.name
}

fun test(a: A) {
    a.f()
    println(a.age.toString())
}

open class A {
    var age: Int? = null

}

fun A.f() {
    println("this is A.f()")
}

class B : A() {
    // 针对 A 对象的扩展方法，方法中可以使用 A 对象中的所有属性，
    fun A.expandMethod() {

    }

    fun testExpand(a: A) {
        a.expandMethod()
    }
}

fun B.f() {
    println("this is B.f()")
}

fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}

class MyClass {
    companion object {  // 伴生对象，类似于内部类，但是可以直接通过 MyClass. 来直接调用参数和属性。
        var name: String = ""
    }
}

fun MyClass.Companion.foo() {
    println("this is MyClass Companion.foo method()")
}
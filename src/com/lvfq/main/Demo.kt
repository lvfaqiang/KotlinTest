package com.lvfq.main

/**
 * Demo
 * @author lvfq
 * @date 2017/5/26 下午4:12
 * @mainFunction :
 *
 */


class Demo {
    var name: String = ""
    val a: Int = 12

    fun setNam(name: String): Unit {
        this.name = name
    }

    fun main(args: Array<String>) {
//        println(name)
//    println(max(10, 9))
//    if (args.size <= 0) {
//        print("args no parameter")
//        return
//    }
//    var x = parInt(args.get(0))
//    var y = parInt(args.get(1))
//    println(parInt(args.get(0)))

//    if (x == null) {
//        print("Wrong number format in '${args[0]}' ")
//        return
//    }
//
//    if (y == null) {
//        print("Wrong numver format in '${args[1]}'")
//        return
//    }
//    println(x + y)
    }

    /**
     * if条件语句
     */
    fun max(a: Int, b: Int) = if (a > b) a else b


    fun parInt(str: String): Int? {
        println("this is parInt method")
        if (str.equals("1")) {
            return 1
        }
        return null
    }


    fun getStringLength(obj: Any): Int? {
        if (obj is String)
            return obj.length
        println(obj.javaClass)
        return null
    }

    /**
     * 测试for循环的两种实现方式。
     */
    fun testFor(args: Array<String>) {

        for (arg in args) {
            println(arg)
        }

        for (i in args.indices) {
            println(args.get(i))
        }
    }

    fun testWhile(args: Array<String>) {
        var i = 0
        while (i < args.size) {
            print(args.get(i++))
        }
    }


    /**
     * 测试 when 表达式 相当于 switch
     */
    fun testWhen(obj: Any) {
        when (obj) {
            is String -> println("this obj is String")
            is Int -> println("this obj is Int")
            0 -> println("this obj  == 0")
        }
    }

    /**
     * 测试区间值，
     */
    fun testRange() {
        var x = 10
        var y = 9
        println(x in 1..y)

        for (z in 1..5) {
            println(z)
        }
        val list = listOf("one", "二", "12", "四", "five")
//    for (i in list) {
//        println(i)
//    }
//
//    for (i in list.indices) {
//        println(i)
//    }

        var p = list.filter { it.length == 4 }  // 等价于 list.filter{ it.length ==4}
        println("list filter : " + p)

//        list.filter { "o" in it }
//                .sortedBy { it }
//                .map { it.toUpperCase() }
//                .forEach { println(it) }

        for (i in 1..10 step 4) {
            // step 表示从起始值开始，下一个值相差多少。
            println(i)
        }
        // in 用在 for 循环中，表示迭代， 用在 if 中，表示判断当前集合是否包含这个值。
        println(x !in 1..13)

    }

    fun testBool() {
        var b: Boolean? = if (1 > 2) true else null

        if (b == null) {

        }
    }

}


fun main(args: Array<String>) {
//    var per: Person = Person()
    var de = Demo()
//    de.main(args)

//    testFor(args)
//    testWhile(args)
//    testWhen(0)
    var sun = Sun("", 20)
    var sun1 = sun.copy(age = 10)
    println(sun1.toString())
    de.testRange()
//    getStringLength(1)

    var text = """fun testBool() {
        var b: Boolean? = if (1 > 2) true else null
if (b == null) {

        }
    }
"""
    var str:String? = null

    var list = mutableListOf<Any>()

    list.add("")
    list?.let { }
    var data: BaseData? = null
    println(text)

}

class Bar<T>(t: T) {
    var value = t
}

interface Test<in T, out R> {
    fun map(t: T)
    // 参数类型为 T , 返回类型为 R  用Java 的写法就是 R result(T t);
    fun result(t: T): R
}

data class Sun(var name: String, var age: Int)

class C{
    private fun t() = object {
        var name = "123"
    }

    fun f() = object {
        var name = "456"
    }

    fun b(){
        var a = t().name
        println()
    }


}
package com.lvfq.main

/**
 * IntLong
 * @author lvfq
 * @date 2017/7/9 下午11:12
 * @mainFunction :
 *
 */
class IntLongText {
    fun test() {
        val text = """
        >Tell me and I forget.
Teach me and I remember.
        >Involve me and I learn.
        (Benjamin Franklin) """.trimMargin(">")
        println(text)
    }

    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '5'.toInt() // 显式转换为数字
    }

    fun testArray() {
        var a: IntArray = intArrayOf(0, 1, 2)
        a[0] = a[1] + a[2]
        println(a.map { it })
    }

    fun textObj(){
        var data: BaseData = BaseData("1", 2, false)
//        println(data.name)
    }
}


fun main(args: Array<String>) {
    var test: IntLongText = IntLongText();
    test.test()
    println(test.decimalDigitValue('2'))
    test.testArray()
    test.textObj()
}

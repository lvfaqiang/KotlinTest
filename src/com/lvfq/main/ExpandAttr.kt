package com.lvfq.main

/**
 * ExpandAttr
 * @author lvfq
 * @date 2017/7/11 下午2:57
 * @mainFunction : 扩展属性。
 *
 */
fun main(args: Array<String>) {
    var attr: ExpandAttr = ExpandAttr()
    var attr1: ExpandAttr1 = ExpandAttr1()
    attr.name = "before change"

    println(attr.name)
    attr1.execute(attr)
    println(attr.name)
}

open class ExpandAttr {
    var name: String = ""
}

open class ExpandAttr1 {
    // 当前扩展属性只能在 当前作用域中使用。
    open fun ExpandAttr.method() {
        name = "after change"
        println("this is in expandattr1 expand method , param name :" + name)
    }

    fun execute(attr: ExpandAttr) {
        attr.method()
    }
}
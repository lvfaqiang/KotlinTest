package com.lvfq.demo.代理

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 属性代理
 * @author lvfq
 * @date 2018/8/31 下午2:01
 * @mainFunction :
 *
 */


//  代理属性

class Example {
    var p: String by Delegate()

//    val p: String by Delegates.notNull()  //  Delegates  是 Kotlin 提供的 代理工厂。
}

class Delegate {
    operator fun getValue(thisSelf: Any?, property: KProperty<*>): String {
        return "$thisSelf , Thank you for detegating '${property.name}'"
    }

    operator fun setValue(thisSelf: Any?, property: KProperty<*>, value: String) {
        println("$value  has been assigned to '${property.name} in $thisSelf.'")
    }
}


fun main(args: Array<String>) {
    val e = Example()
    println(e.p)
    e.p = "String"


    observableName = "first"
    observableName = "second"

    observableName1 = "three"
    observableName1 = "four"


    notNull = "notNull String"
    println(notNull)


}

//   Kotlin 标准库中的 Delegates

//  ------    观察者

var observableName: String by Delegates.observable("") { _, old, new ->
    println("$old -- > $new")   // 这里监听的是 改变之后
}

var observableName1: String by Delegates.vetoable("") { _, old, new ->
    println("$old -- > $new")   // 这里监听的是 改变之前
    false
}

// 当 notNull 属性未赋值时，直接获取会抛出异常。 正常操作必须是 先赋值后获取
var notNull: String by Delegates.notNull()


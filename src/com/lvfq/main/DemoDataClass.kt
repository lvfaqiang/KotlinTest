package com.lvfq.main

import com.sun.tools.corba.se.idl.StringGen
import java.util.*
import kotlin.collections.HashMap

/**
 * DemoDataClass
 * @author lvfq
 * @date 2017/6/4 上午1:34
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    var demo = DemoDataClass()
    demo.test()
    demo.name = "1";

    var data = BaseData(22, "男")
    var (age , sex) = data
    
}

class DemoDataClass {
    var name: String = ""
        get() = name
        set(value) {
            field = value
        }

    //    幕后属性
//    如果你的需求不符合这套“隐式的幕后字段”方案，那么总可以使用 幕后属性 。
//   幕后属性可以直白的理解为，我要访问 当前对象的 map 对象，必然是隐式调用了 get 方法，那么这里就利用另一个私有的参数或者属性来进行自定义 get 方法，
    private var _map: Map<String, Object>? = null
    val map: Map<String, Object>
        get() {
            if (_map == null) {
                _map = HashMap<String, Object>()

            }
            return _map ?: throw RuntimeException("")
        }

    fun test() {
        var data = BaseData("param1", 2, true)
        var date1 = BaseData(1, "女")
        println("data param : ${data.a}")
        println(data.component1())   // component1...n  这是系统根据参数个数生成的，
    }
}
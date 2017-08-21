package com.lvfq.main

import javafx.scene.Parent
import java.io.Serializable

/**
 * BaseData
 * @author lvfq
 * @date 2017/6/2 上午9:14
 * @mainFunction :
 *
 */
data class BaseData(var a: String, var b: Int, var c: Boolean) : Serializable {

    constructor(age: Int, sex: String) : this(a = "", b = 0, c = false) {
        var name = a + b + c
    }

    constructor() : this("", 0, false) {

    }

}
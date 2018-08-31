package com.lvfq

import sun.misc.FloatingDecimal
import java.text.NumberFormat


/**
 * MainTest
 * @author lvfq
 * @date 2018/7/28 上午11:01
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    val result = FloatingDecimal.parseFloat("-0.00048")
    println(formatChange(-0.00048f))

    var pages = 17 / 8F
    var size = pages.toInt()
    if (size < pages) {
        size += 1
    }
    println(size)

    println(1.sum(1))
}

val sum = fun Int.(other: Int): Int = this + other


// field 为属性的缓存字段
var name: String = ""
    get() = ""
    set(value) {
        if (!value.isEmpty())
            field = value
        else
            field = "empty"
    }

fun isNumEmpty(value: String): Boolean {
    return value.isEmpty() || (value.toDouble() <= 0.0)
}

fun generatePhone(phone: String): String {
    return phone.replace(Regex("(\\d{3})\\d{4}(\\d{4})"), "$1****$2")
}

fun formatChange(changeRatio: Float): String {
    val formatter = NumberFormat.getPercentInstance()
    formatter.minimumFractionDigits = 2
    formatter.maximumFractionDigits = 2
    // FIXME: config leading sign `+` instead of appending it
    return if (changeRatio >= 0.000f) {
        if (formatter.format(changeRatio.toDouble()).indexOf("-") == -1) {
            "+" + formatter.format(changeRatio.toDouble())
        } else {
            formatter.format(changeRatio.toDouble()).replace("-", "+")
        }

    } else
        formatter.format(changeRatio.toDouble())
}

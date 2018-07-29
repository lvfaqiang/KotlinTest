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

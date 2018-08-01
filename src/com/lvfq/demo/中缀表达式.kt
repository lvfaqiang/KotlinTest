package com.lvfq.demo

import com.lvfq.demo.Compare.LESS

/**
 * 中缀表达式
 * @author lvfq
 * @date 2018/8/2 上午12:30
 * @mainFunction :
 *
 */

sealed class Compare {
    object LESS : Compare() {
        override fun toString(): String {
            return "小于"
        }
    }

    object MORE : Compare() {
        override fun toString(): String {
            return "大于"
        }
    }

    object EQUAL : Compare() {
        override fun toString(): String {
            return "等于"
        }
    }
}

infix fun Int.vs(num: Int): Compare =
        if (this - num < 0) {
            Compare.LESS
        } else if (this - num > 0) {
            Compare.MORE
        } else {
            Compare.EQUAL
        }


/**
 * 一个函数只有用于两个角色类似的对象时，才将其声明为中缀函数，
 * 推荐示例 ： and 、to 、zip
 *
 * 反例 add
 *
 * 如果一个方法会改动其接收者的时候，那么就不要将其声明为中缀表达式。
 */

fun main(args: Array<String>) {
    // 中缀表达式 调用方式
    println(5 vs 6)
    println(5.vs(4))
}
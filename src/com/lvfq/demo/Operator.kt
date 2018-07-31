package com.lvfq.demo

/**
 * Operator
 * @author lvfq
 * @date 2018/8/1 上午12:01
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    val a = arrayOf<String>("4", "0", "7", "i", "f", "w", "0", "9")
    val index = arrayOf(5, 3, 9, 4, 8, 3, 1, 9, 2, 1, 7)

    index
            .filter {
                it < a.size
            }
            .map {
                a[it]
            }
            .reduce { s, s1 ->
                println("$s , $s1")
                "$s$s1"
            }
            .also {
                println("result :$it")
            }

    /**
     * 执行结果：
     *
     *
    w , i
    wi , f
    wif , i
    wifi , 0
    wifi0 , 7
    wifi07 , 0
    wifi070 , 9
    result :wifi0709
     */


    println("----------------")
    myOperator()
}


fun myOperator() {
    val list = arrayListOf<Int>(1, 2, 3, 4, 5)
    list.convert {
        it + 5
    }.forEach {
        println(it)
    }
}

// 自定义操作符
inline fun <T, E> Iterable<T>.convert(action: (T) -> E): Iterable<E> {
    val list = mutableListOf<E>()
    for (item in this) list.add(action(item))
    return list
}
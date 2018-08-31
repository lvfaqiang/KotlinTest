package com.lvfq.demo

/**
 * ReturnBreak
 * @author lvfq
 * @date 2018/8/31 上午8:18
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    foos()
    println("end-------")
}

fun foos() {
    val ints = arrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8)
//    ints.forEach {
//        if (it == 0) return   // 这里 return 是直接退出了 foos 方法，[return 等同于 return@foos]
//        print("$it ")
//    }
    // 执行结果  1 2 3 4 end-------


    ints.forEach {
        if (it == 0) return@forEach // 这里的 return 等同于 continue ,跳过当前循环，进行下一次循环
        print("$it ")
    }
    println("foos end----")
    /**
     * 执行结果
     * 1 2 3 4 5 6 7 8 foos end----
     *  end-------
     */

}
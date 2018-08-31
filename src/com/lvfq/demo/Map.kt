package com.lvfq.demo

/**
 * Map
 * @author lvfq
 * @date 2018/8/31 下午6:00
 * @mainFunction :
 *
 */


/**
 *  Map
 */

val map = mutableMapOf("key1" to 1, "key2" to 2, "key3" to 3)

// 复制一个 Map

fun copyMap(): MutableMap<String, Int> {
    val mapCopy = map.toMap() as MutableMap
    // mapCopy 生成一个新的 Map .
    return mapCopy
}

// 删除 Map 中部分 Key,如果 key 不存在则跳过 ，然后返回一个新的 Map
fun deleteKeys(): Map<String, Int> {
    val newMap = copyMap() - arrayListOf("key", "key2")
    return newMap
}


fun main(args: Array<String>) {
    val copyMap = copyMap()
    copyMap["key1"] = 11

    val mins = minOf(map, copyMap, compareBy { it.size })

    for ((k, v) in mins) {
        println("key:$k , value:$v")
    }


    println("map:key1=${map["key1"]} copyMap :key1=${copyMap["key1"]}")

}

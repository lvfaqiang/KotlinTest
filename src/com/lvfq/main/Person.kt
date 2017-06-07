package com.lvfq.main

/**
 * Person
 * @author lvfq
 * @date 2017/5/26 下午4:24
 * @mainFunction :
 *
 */
class Person {
    private var name: String = ""
    private var age: Int = 0;


    override fun toString(): String = "Person(name='$name', age=$age)"

    fun getName(): String = name

}
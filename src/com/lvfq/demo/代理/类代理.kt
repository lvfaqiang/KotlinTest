package com.lvfq.demo.代理

import kotlin.reflect.KProperty

/**
 * 代理
 * @author lvfq
 * @date 2018/8/31 上午11:27
 * @mainFunction :
 *
 */

//  类代理

interface Base {
    fun print()
    fun getV(): String
}

class BaseImpl(val value: String) : Base {
    override fun getV(): String {
        return value
    }

    override fun print() {
        print(value)
    }
}

/**
 *  Kotlin 中的动态代理
 *
 *  编译后生成的类是
public final class Derived implements Base {
    // $FF: synthetic field
    private final Base $$delegate_0;

    public Derived(@NotNull Base b) {
        Intrinsics.checkParameterIsNotNull(b, "b");
        super();
        this.$$delegate_0 = b;
    }

    @NotNull
    public String getV() {
        return this.$$delegate_0.getV();
    }

    public void print() {
        this.$$delegate_0.print();
    }
}
 **/

class Derived(b: Base) : Base by b


fun main(args: Array<String>) {
    val b = BaseImpl("this is Value")
    val d = Derived(b)
    d.print()
    d.getV()

}

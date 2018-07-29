package com.lvfq.project_1

/**
 * Main
 * @author lvfq
 * @date 2018/7/29 下午12:05
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    val user = User(1, "name", PlayerViewType.Vip("VIP", "MESSAGE"))
    PlayerUI.get().showPlayer(user)
}
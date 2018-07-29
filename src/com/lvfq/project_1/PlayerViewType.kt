package com.lvfq.project_1

/**
 * PlayerViewType
 * @author lvfq
 * @date 2018/7/29 上午11:07
 * @mainFunction :
 *
 */
sealed class PlayerViewType {
    object BLUE : PlayerViewType()
    object GREEN : PlayerViewType()
    class Vip(val title: String? = null, val message: String? = null) : PlayerViewType()
}

fun getPlayerViewType(type: PlayerViewType) = when (type) {
    PlayerViewType.BLUE -> BluePlayerView()
    PlayerViewType.GREEN -> GreenPlayerView()
    is PlayerViewType.Vip -> VipPlayerView(type.message, type.title)
}
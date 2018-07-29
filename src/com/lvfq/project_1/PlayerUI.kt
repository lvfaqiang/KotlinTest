package com.lvfq.project_1

/**
 * PlayerUI
 * @author lvfq
 * @date 2018/7/29 上午11:20
 * @mainFunction :
 *
 */
class PlayerUI {
    companion object {
        fun get(): PlayerUI {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = PlayerUI()
    }

    fun showPlayer(user: User) {
        MediaPlayerView(getPlayerViewType(user.type)).showView()
    }

}
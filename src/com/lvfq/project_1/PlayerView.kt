package com.lvfq.project_1

import javax.swing.JOptionPane

/**
 * PlayerView
 * @author lvfq
 * @date 2018/7/29 上午11:14
 * @mainFunction :
 *
 */
interface PlayerView {
    fun getPlayButton()

    fun showView()
}


class BluePlayerView : PlayerView {
    override fun getPlayButton() {
        println("显示蓝色的 Button")
    }

    override fun showView() {
        JOptionPane.showConfirmDialog(null, "显示蓝色播放器", "蓝色播放器", JOptionPane.DEFAULT_OPTION)
    }
}

class GreenPlayerView : PlayerView {
    override fun getPlayButton() {
        println("显示绿色的 Button")
    }

    override fun showView() {
        JOptionPane.showConfirmDialog(null, "显示绿色播放器", "绿色播放器", JOptionPane.DEFAULT_OPTION)
    }
}

val TITLE = "播放器标题"
val MESSAGE = "播放器消息"

class VipPlayerView(
        var message: String?,
        var title: String?
) : PlayerView {
    init {
        title = title ?: TITLE
        message = message ?: MESSAGE
    }

    override fun getPlayButton() {
        println("VIP Button")
    }

    override fun showView() {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION)
    }
}

class MediaPlayerView(playerView: PlayerView) : PlayerView by playerView
package com.gabrieal4real.solitaire.activities

import android.content.Context
import android.view.ViewManager
import com.gabrieal4real.solitaire.basic.GameModel
import com.gabrieal4real.solitaire.basic.GamePresenter
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

class WastePileView(context: Context) : androidx.appcompat.widget.AppCompatImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onWasteTap()
        }
    }

    fun update() {
        val cards = GameModel.wastePile
        imageResource =
            if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable

    }
}

fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {}) = ankoView({
    WastePileView(it)
}, 0, init)
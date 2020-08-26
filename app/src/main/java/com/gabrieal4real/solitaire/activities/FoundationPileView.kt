package com.gabrieal4real.solitaire.activities

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewManager
import com.gabrieal4real.solitaire.basic.GameModel
import com.gabrieal4real.solitaire.basic.GamePresenter
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick


@SuppressLint("ViewConstructor")
class FoundationPileView(context: Context, val index: Int) :
    androidx.appcompat.widget.AppCompatImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onFoundationTap(index)
        }
    }

    fun update() {
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {}) =
    ankoView({
        FoundationPileView(
            it,
            index
        )
    }, 0, init)
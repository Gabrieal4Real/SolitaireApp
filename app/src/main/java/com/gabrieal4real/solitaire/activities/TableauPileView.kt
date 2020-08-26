package com.gabrieal4real.solitaire.activities

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewManager
import com.gabrieal4real.solitaire.basic.GameModel
import com.gabrieal4real.solitaire.basic.GamePresenter
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

@SuppressLint("ViewConstructor")
class TableauPileView(context: Context, private val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }

    fun update() {
        removeAllViews()
        addViews()
    }

    private fun addViews() {
        val cards = GameModel.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView {
                y =
                    (i * dip(25)).toFloat()//y property is the vertical position of view in the parent
                imageResource = if (card.faceUp) getResIdForCard(card) else cardBackDrawable
                onClick {
                    GamePresenter.onTableauTap(
                        index,
                        i
                    )
                }
            }.lparams(context.cardWidth, context.cardHeight)
        }
    }
}

fun ViewManager.tableauPileViews(index: Int, init: TableauPileView.() -> Unit = {}) = ankoView({
    TableauPileView(
        it,
        index
    )
}, 0, init)

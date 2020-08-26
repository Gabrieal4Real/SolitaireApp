package com.gabrieal4real.solitaire.activities

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gabrieal4real.solitaire.R
import com.gabrieal4real.solitaire.basic.*
import org.jetbrains.anko.*
import java.util.*


const val cardBackDrawable = R.drawable.cardback_red
const val emptyPileDrawable = R.drawable.cardback_blue
fun View.getResIdForCard(card: Card): Int {
    val resourceName = "card${card.suit}${cardMap[card.value]}".toLowerCase(Locale.ROOT)
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

val Context.cardWidth: Int
    get() = (displayMetrics.widthPixels - dip(8)) / 7
val Context.cardHeight: Int
    get() = cardWidth * 190 / 140

class MainActivity : AppCompatActivity(), GameView {
    private var deckView: DeckView? = null
    private var wastePileView: WastePileView? = null
    private val foundationPileViews: Array<FoundationPileView?> = arrayOfNulls(4)
    private val tableauPileViews: Array<TableauPileView?> = arrayOfNulls(7)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.setGameView(this)
        GameModel.resetGame()

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(4)
            linearLayout {

                deckView = deckView().lparams(cardWidth, cardHeight)
                wastePileView = wastePileView().lparams(cardWidth, cardHeight)
                view().lparams(cardWidth, 0)
                for (i in 0..3) {
                    foundationPileViews[i] = foundationPileView(i).lparams(cardWidth, cardHeight)
                }
            }
            linearLayout {
                for (i in 0..6) {
                    tableauPileViews[i] = tableauPileViews(i).lparams(cardWidth, matchParent)
                }
            }.lparams(height = matchParent) {
                topMargin = cardHeight / 2
            }
        }
    }

    override fun update(gameModel: GameModel) {
        deckView!!.update()

        wastePileView!!.update()
        foundationPileViews.forEach {
            it!!.update()

        }
        tableauPileViews.forEach {
            it!!.update()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add("New Game")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        GameModel.resetGame()
        update()
        return true
    }
}

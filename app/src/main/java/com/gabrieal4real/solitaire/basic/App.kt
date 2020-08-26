package com.gabrieal4real.solitaire.basic

fun main(args: Array<String>) {
    GameModel.resetGame()
    GamePresenter.onDeckTap()
    GameModel.debugPrint()
}
package com.gabrieal4real.solitaire.basic

val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"
val redSuits = arrayOf(diamonds, hearts)
val blackSuits = arrayOf(spades, clubs)
val cardMap = mapOf(
    0 to "a",
    1 to "2",
    2 to "3",
    3 to "4",
    4 to "5",
    5 to "6",
    6 to "7",
    7 to "8",
    8 to "9",
    9 to "10",
    10 to "j",
    11 to "q",
    12 to "k"
)

data class Card(val value: Int, val suit: String, var faceUp: Boolean = false) {

    override fun toString(): String =
        if (faceUp) "${cardMap[value]}".padEnd(2) + getSuitChar(suit) else "xxx"

    private fun getSuitChar(suit: String): String = when (suit) {
        diamonds -> "\u2666"
        clubs -> "\u2663"
        hearts -> "\u2665"
        spades -> "\u2660"
        else -> "incorrect suit"
    }
}

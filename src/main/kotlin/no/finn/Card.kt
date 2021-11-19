package no.finn

enum class CardSuit {
    CLUB, DIAMOND, HEART, SPADE
}

enum class CardValue(val pointValue: Int) {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11)
}

data class Card(val suit: CardSuit, val value: CardValue) {
    override fun toString(): String {
        val value = when (value.pointValue) {
            in 2..9 -> value.pointValue.toString()
            else -> when (value) {
                CardValue.TEN -> "10"
                CardValue.JACK -> "J"
                CardValue.QUEEN -> "Q"
                CardValue.KING -> "K"
                else -> "A"
            }
        }
        return "${suit.name[0]}$value"
    }
}

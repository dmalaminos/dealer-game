package no.finn

enum class CardSuit {
    CLUB, DIAMOND, HEART, SPADE;

    override fun toString() = name[0].toString()
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
    ACE(11);

    override fun toString() =
        when (pointValue) {
            in 2..9 -> pointValue.toString()
            else -> when (this) {
                TEN -> "10"
                else -> name[0].toString()
            }
        }
}

data class Card(val suit: CardSuit, val value: CardValue) {
    override fun toString() = "$suit$value"
}

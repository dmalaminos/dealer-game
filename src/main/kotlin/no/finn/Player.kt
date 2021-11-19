package no.finn

class Player(val name: String) {
    private val _hand: MutableList<Card> = mutableListOf()

    val hand: List<Card>
        get() = _hand.toList()

    val handScore: Int
        get() = _hand.sumOf { it.value.pointValue }

    fun takeCard(card: Card) {
        _hand.add(card)
    }
}

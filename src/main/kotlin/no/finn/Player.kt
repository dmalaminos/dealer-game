package no.finn

class Player(private val name: String) {
    private val hand: MutableList<Card> = ArrayList()

    val handScore: Int
        get() = hand.sumOf { it.value.pointValue }

    fun takeCard(card: Card) {
        hand.add(card)
    }
}

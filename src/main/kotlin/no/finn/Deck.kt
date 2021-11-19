package no.finn

class Deck(cards: List<Card>) {
    private val cards: ArrayDeque<Card>

    init {
        this.cards = ArrayDeque(cards)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (cards != (other as Deck).cards) return false

        return true
    }

    override fun hashCode(): Int {
        return cards.hashCode()
    }
}

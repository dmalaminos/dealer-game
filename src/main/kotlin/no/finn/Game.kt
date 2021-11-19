package no.finn

class Game(
    private val deck: Deck,
    private val player: Player,
    private val dealer: Player
) {
    var winner: Player? = null
        private set

    fun play() {
        dealInitialHands()
        winner = calculateWinner()
    }

    private fun dealInitialHands() {
        repeat(INITIAL_HAND_SIZE) {
            player.takeCard(deck.draw())
            dealer.takeCard(deck.draw())
        }
    }

    private fun calculateWinner(): Player {
        if (hasBlackjack(player)) return player
        if (hasBlackjack(dealer) || bothPlayersHaveDoubleAce()) return dealer

        while (player.handScore <= MAX_DRAWING_SCORE) {
            player.takeCard(deck.draw())
        }
        if (player.handScore > MAX_HAND_SCORE) {
            return dealer
        }

        while (dealer.handScore <= player.handScore) {
            dealer.takeCard(deck.draw())
        }
        if (dealer.handScore > MAX_HAND_SCORE) {
            return player
        }

        return if (player.handScore > dealer.handScore) player else dealer
    }

    private fun hasBlackjack(player: Player) = player.handScore == INITIAL_BLACKJACK_SCORE

    private fun bothPlayersHaveDoubleAce() =
        player.handScore == INITIAL_DOUBLE_ACE_SCORE && dealer.handScore == INITIAL_DOUBLE_ACE_SCORE

    override fun toString(): String {
        return """
            ${winner?.name ?: "No winner yet"}
            $player
            $dealer
            """.trimIndent()
    }

    companion object {
        private const val INITIAL_HAND_SIZE = 2
        private const val MAX_DRAWING_SCORE = 16
        private const val MAX_HAND_SCORE = 21
        private const val INITIAL_BLACKJACK_SCORE = 21
        private const val INITIAL_DOUBLE_ACE_SCORE = 22
    }
}

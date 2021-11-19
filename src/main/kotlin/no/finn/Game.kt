package no.finn

class Game(
    private val deck: Deck,
    private val player: Player,
    private val dealer: Player
) {
    fun run(): Player {
        dealInitialHands()

        if (hasBlackjack(player)) return player
        if (hasBlackjack(dealer)) return dealer
        if (bothPlayersHaveDoubleAce()) return dealer

        while (player.handScore < MAX_DRAWING_SCORE) {
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

    private fun dealInitialHands() {
        repeat(INITIAL_HAND_SIZE) {
            player.takeCard(deck.draw())
            dealer.takeCard(deck.draw())
        }
    }

    private fun hasBlackjack(player: Player): Boolean {
        return player.handScore == INITIAL_BLACKJACK_SCORE
    }

    private fun bothPlayersHaveDoubleAce(): Boolean {
        return player.handScore == INITIAL_DOUBLE_ACE_SCORE && dealer.handScore == INITIAL_DOUBLE_ACE_SCORE
    }

    companion object {
        private const val INITIAL_HAND_SIZE = 2
        private const val MAX_DRAWING_SCORE = 16
        private const val MAX_HAND_SCORE = 21
        private const val INITIAL_BLACKJACK_SCORE = 21
        private const val INITIAL_DOUBLE_ACE_SCORE = 22
    }
}

package no.finn

import no.finn.deck.Deck
import no.finn.deck.DeckFileReader
import no.finn.deck.DeckParser
import no.finn.deck.RandomDeckGenerator

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val deck = getDeck(args)

        val sam = Player("sam")
        val dealer = Player("dealer")
        val game = Game(deck, sam, dealer)

        game.play()

        println(game)
    }

    private fun getDeck(args: Array<String>): Deck {
        return if (args.size == 1) {
            val deckString = DeckFileReader().read(args[0])
            return DeckParser().parseFromString(deckString)
        } else {
            RandomDeckGenerator().generate()
        }
    }
}

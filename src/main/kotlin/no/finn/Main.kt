package no.finn

import no.finn.deck.DeckFileReader
import no.finn.deck.DeckParser
import no.finn.deck.RandomDeckGenerator

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val deck = getDeck(args)
        val game = Game(deck, Player("sam"), Player("dealer"))

        game.play()

        println(game)
    }

    private fun getDeck(args: Array<String>) =
        if (args.size == 1) {
            val deckString = DeckFileReader().read(args[0])
            DeckParser().parseFromString(deckString)
        } else {
            RandomDeckGenerator().generate()
        }
}

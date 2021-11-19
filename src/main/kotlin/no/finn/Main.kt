package no.finn

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
        val deckSupplier = DeckSupplier(DeckFileReader(), DeckParser(), RandomDeckGenerator())
        return if (args.size == 1) {
            deckSupplier.fromFile(args[0])
        } else {
            deckSupplier.random()
        }
    }
}

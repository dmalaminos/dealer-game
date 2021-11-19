package no.finn

fun main(args: Array<String>) {
    val deckSupplier = DeckSupplier(DeckFileReader(), DeckParser(), RandomDeckGenerator())
    val deck = if (args.size == 1) {
        deckSupplier.fromFile(args[0])
    } else {
        deckSupplier.random()
    }

    val sam = Player("sam")
    val dealer = Player("dealer")
    val game = Game(deck, sam, dealer)

    game.play()

    println(game)
}

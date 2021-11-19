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

    val winner = Game(deck, sam, dealer).run()

    println(winner.name)
    println("${sam.name}: ${sam.hand.joinToString(", ")}")
    println("${dealer.name}: ${dealer.hand.joinToString(", ")}")
}

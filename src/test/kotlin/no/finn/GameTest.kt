package no.finn

import no.finn.CardSuit.*
import no.finn.CardValue.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotEquals

class GameTest {
    private val sammy = Player("Sammy")
    private val dealer = Player("Dealer")

    @Test
    fun playerShouldWinWhenInitialHandHasBlackjack() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, FIVE),
                Card(HEART, KING),
                Card(HEART, QUEEN)
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(sammy, winner)
        assertEquals(21, sammy.handScore)
    }

    @Test
    fun dealerShouldWinWhenInitialHandHasBlackjackAndPlayerDoesNot() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, TEN),
                Card(HEART, NINE),
                Card(HEART, ACE)
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(dealer, winner)
        assertEquals(21, dealer.handScore)
        assertNotEquals(21, sammy.handScore)
    }

    @Test
    fun playerShouldWinWhenInitialHandHasBlackjackAndDealerToo() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, TEN),
                Card(HEART, KING),
                Card(HEART, ACE)
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(sammy, winner)
        assertEquals(21, sammy.handScore)
        assertEquals(21, dealer.handScore)
    }

    @Test
    fun dealerShouldWinWhenInitialHandIsDoubleAceAndPlayerToo() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, ACE),
                Card(HEART, ACE),
                Card(SPADE, ACE)
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(dealer, winner)
        assertEquals(22, sammy.handScore)
        assertEquals(22, dealer.handScore)
    }

    @Test
    fun dealerShouldWinWhenPlayerHandScoreGreaterThan21() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, FIVE),
                Card(HEART, TWO),
                Card(HEART, QUEEN),
                Card(SPADE, ACE)
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(dealer, winner)
        assertEquals(24, sammy.handScore)
        assertEquals(15, dealer.handScore)
    }

    @Test
    fun playerShouldWinWhenDealerHandScoreGreaterThan21() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, FIVE),
                Card(HEART, NINE),
                Card(HEART, QUEEN),
                Card(SPADE, SEVEN)
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(sammy, winner)
        assertEquals(20, sammy.handScore)
        assertEquals(22, dealer.handScore)
    }

    @Test
    fun playerShouldWinWhenHandScoredHigher() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, FIVE),
                Card(HEART, FOUR),
                Card(HEART, QUEEN),
                Card(SPADE, SIX), //player: 21, dealer: 15
                Card(CLUB, TWO),
                Card(DIAMOND, TWO),
                Card(HEART, TWO), //player: 21, dealer: 21
                Card(CLUB, THREE) //player: 21, dealer: 24
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(sammy, winner)
        assertEquals(21, sammy.handScore)
        assertEquals(24, dealer.handScore)
    }

    @Test
    fun dealerShouldWinWhenHandScoredHigher() {
        val deck = Deck(
            listOf(
                Card(CLUB, ACE),
                Card(DIAMOND, TEN),
                Card(HEART, SIX),
                Card(HEART, SIX), //player: 17, dealer: 16
                Card(CLUB, TWO) //player: 17, dealer: 18
            )
        )
        val game = Game(deck, sammy, dealer)

        val winner = game.run()

        assertEquals(dealer, winner)
        assertEquals(17, sammy.handScore)
        assertEquals(18, dealer.handScore)
    }
}
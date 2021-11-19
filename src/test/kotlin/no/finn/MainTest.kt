package no.finn

import no.finn.Main.main
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.text.RegexOption.MULTILINE

class MainTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun shouldReadDeckFileAndPlayGameAndPrintResults() {
        main(arrayOf("src/test/resources/valid-deck.txt"))

        val expectedOutput = """
            sam
            sam: CA, H9
            dealer: D5, HQ, S8
        """.trimIndent()
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim())
    }

    @Test
    fun shouldGenerateShuffledDeckAndPlayGameAndPrintResults() {
        main(arrayOf())

        val outputLines = outputStreamCaptor.toString().trim().lines()

        val suitMatcher = "[CDHS]"
        val valueMatcher = "([2-9]|10|[JQKA])"
        val cardMatcher = "($suitMatcher$valueMatcher)"
        val separatorMatcher = ",\\s"
        val handMatcher = "$cardMatcher($separatorMatcher$cardMatcher)+"
        assertLineMatches(outputLines[0], "^sam|dealer\$")
        assertLineMatches(outputLines[1], "^sam: $handMatcher\$")
        assertLineMatches(outputLines[2], "^dealer: $handMatcher\$")
    }

    private fun assertLineMatches(line: String, pattern: String) {
        assertTrue { line.matches(Regex(pattern, MULTILINE)) }
    }
}
package no.finn

import java.io.File
import java.io.IOException

class DeckFileReader {
    fun read(filePath: String): String {
        val deckString = try {
            File(filePath).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            throw IllegalArgumentException("Deck file is not available at the specified path")
        }

        return deckString
    }
}

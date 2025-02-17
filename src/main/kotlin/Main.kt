package kuruekmek

import kuruekmek.apps.*
import kuruekmek.tools.checkETC

fun main() {
    checkETC()
    hello()
}

fun hello() {
    println("""Select what you want to download
        1. Youtube Music
        2. Intellij Clion
        3. Intellij Idea
        S. Source Code
        I. For Tips 😉
    """.trimMargin())
    val getInput = readlnOrNull().toString()
    when (getInput) {
            //Yt Music
        "1" -> { ytMusic() ; runHelloAgain() }
        "1w" -> { ytMusicWayland() ; runHelloAgain() }
        "1r", "1wr", "1rw" -> { ytMusicUninstall() ; runHelloAgain() }

            //Clion
        "2" -> { clion() ; runHelloAgain() }
        "2w" -> { clionWayland() ; runHelloAgain() }
        "2r", "2wr", "2rw" -> { clionUninstall() ; runHelloAgain() }

            //Idea
        "3" -> { idea()  ; runHelloAgain() }
        "3w" -> { ideaWayland()  ; runHelloAgain() }
        "3r", "3wr", "3rw" -> { ideaUninstall()  ; runHelloAgain() }
            //Misc
        "I", "i" -> { showTips() ; runHelloAgain() }
        "S", "s" -> { openUrl() ; runHelloAgain() }
        else -> println("invalid output, leaving 😈")
    }
}

fun runHelloAgain() {
    repeat(2) {println("")}
    hello()
}

fun showTips() {
    println("")
    println("""You can append e to end of the app to download eap for jetbrains tools. ie:
        To install eap versions, append e
        To enable Wayland Support, append w (ide must be installed already)
        To uninstall, append r
    """.trimMargin())
    repeat(2) {println("")}
    repeat(40) {
        print("--")
    }
    repeat(2) {println("")}

}
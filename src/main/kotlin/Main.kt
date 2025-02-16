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
        S. Source Code
        I. For Tips 😉
    """.trimMargin())
    val getInput = readlnOrNull().toString()
    when (getInput) {
        "1" -> { ytMusic() ; runHelloAgain() }
        "2w", "w2" -> { ytMusicWayland() ; runHelloAgain() }
        "2r", "2wr", "2rw" -> { ytMusicUninstall() ; runHelloAgain() }
        "I", "i" -> { showTips() ; runHelloAgain() }
        "S", "s" -> { openUrl() ; runHelloAgain() }
        else -> print("invalid output")
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
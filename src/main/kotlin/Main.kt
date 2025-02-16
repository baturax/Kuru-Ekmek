package kuruekmek

import kuruekmek.apps.*
import kuruekmek.tools.checkETC

fun main() {
    checkETC()
    println("""Select what you want to download
        1. Youtube Music
        2. Intellij Clion
        S. Source Code
        I. For Tips 😉
    """.trimMargin())
    val getInput = readlnOrNull().toString()
    when (getInput) {
        "1" -> {ytMusic(); main()}
        "2w", "w2" -> {ytMusicWayland() ; main()}
        "2r", "2wr", "2rw" -> { ytMusicUninstall() }
        "I", "i" -> showTips()
        "S", "s" -> openUrl()
        else -> print("invalid output")
    }
}

fun showTips() {
    println("""You can append e to end of the app to download eap for jetbrains tools. ie:
        To install eap versions, append e
        To enable Wayland Support, append w (ide must be installed already)
        To uninstall, append r
    """.trimMargin())
}
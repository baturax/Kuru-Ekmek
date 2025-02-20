package kuruekmek

import kuruekmek.apps.*
import kuruekmek.tools.cacheDirectory
import kuruekmek.tools.checkETC
import java.io.File

fun main() {
    checkETC()
    hello()
}

fun hello() {
    println("""Select what you want to download
        1. Youtube Music
        2. Intellij Clion
        3. Intellij Idea
        4. Ferdium
        5. VsCodium
        6. Android Studio
        C. to clean cache
        S. Source Code
        I. For Tips 😉
    """.trimMargin())
    val getInput = readlnOrNull().toString()
    when (getInput) {
            //Yt Music
        "1" -> { ytMusic() ; runHelloAgain() }
        "1w", "1W" -> { ytMusicWayland() ; runHelloAgain() }
        "1r", "1R" -> { ytMusicUninstall() ; runHelloAgain() }

            //Clion
        "2" -> { clion() ; runHelloAgain() }
        "2w", "2W" -> { clionWayland() ; runHelloAgain() }
        "2r", "2R" -> { clionUninstall() ; runHelloAgain() }

            //Idea
        "3" -> { idea()  ; runHelloAgain() }
        "3w", "3W" -> { ideaWayland()  ; runHelloAgain() }
        "3r", "3R" -> { ideaUninstall()  ; runHelloAgain() }

            //Ferdium
        "4" -> { ferdium() ; runHelloAgain()}
        "4w", "4W" -> { ferdiumWayland() ; runHelloAgain()}
        "4r", "4R" -> { ferdiumUninstall() ; runHelloAgain() }

            //VsCode
        "5" -> { vsCode()  ; runHelloAgain() }
        "5w", "5W" -> { vsCodeWayland()  ; runHelloAgain() }
        "5r", "5R" -> { vsCodeUninstall()  ; runHelloAgain() }

            // Android Studio
        "6" -> { androidStudio()  ; runHelloAgain() }
        "6w", "6W" -> { androidStudioWayland()  ; runHelloAgain() }
        "6r", "6R" -> { androidStudioUninstall()  ; runHelloAgain() }

        //Misc
        "C", "c" -> { cleanCache() ; runHelloAgain() }
        "I", "i" -> { showTips() ; runHelloAgain() }
        "S", "s" -> { openUrl() ; runHelloAgain() }
        else -> println("invalid output, leaving 😈")
    }
}

fun cleanCache() {
    val cacheDirectory = File("$cacheDirectory")
    val cacheFiles = cacheDirectory.listFiles()

    if (cacheFiles != null) {
        for (file in cacheFiles) {
            file.delete() // Delete each file
        }
    }
}

fun runHelloAgain() {
    repeat(2) {println("")}
    hello()
}


fun showTips() {
    println("")
    println("""ie:
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
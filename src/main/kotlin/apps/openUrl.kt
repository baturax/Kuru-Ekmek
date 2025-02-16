package kuruekmek.apps

import com.lordcodes.turtle.shellRun

fun openUrl() {
    val url = "https://github.com/baturax/"
    try {
        shellRun("xdg-open", listOf(url))
    } catch (_: com.lordcodes.turtle.ShellCommandNotFoundException) {
        println("xdg-open not found, install xdg-utils, thanks")
    }
}
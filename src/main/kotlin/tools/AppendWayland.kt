package kuruekmek.tools

import java.io.File

fun electronWayland(desktopFileDirectory: File) {
    ProcessBuilder("sed", "-i", WAYLANDELECTRON, desktopFileDirectory.toString())
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor()
}

fun jetbrainsWayland(desktopFileDirectory: File) {
    ProcessBuilder("sed", "-i", WAYLANDJETBRAINS, desktopFileDirectory.toString())
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor()
}

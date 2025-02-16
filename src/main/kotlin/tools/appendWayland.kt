package kuruekmek.tools

import java.io.File

fun electronWayland(desktopFileDirectory: File) {
    ProcessBuilder("sed", "-i", waylandElectron, desktopFileDirectory.toString())
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor()
}

fun ideaWayland(desktopFileDirectory: File) {
    ProcessBuilder("sed", "-i", waylandJetbrains, desktopFileDirectory.toString())
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor()
}


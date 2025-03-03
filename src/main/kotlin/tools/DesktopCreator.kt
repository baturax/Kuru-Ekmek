package kuruekmek.tools

import java.io.File
import kotlin.system.exitProcess

fun desktopCreator(
    desktopFileDirectory: File,
    appName: String,
    runExec: String,
    categories: String,
    terminal: String,
    comment: String,
    icon: File,
) {
    checkIfDesktopBeExtractedExists(desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)
}

fun checkIfDesktopBeExtractedExists(
    desktopFileDirectory: File,
    appName: String,
    runExec: String,
    categories: String,
    terminal: String,
    comment: String,
    icon: File,
) {
    if (desktopFileDirectory.exists()) {
        println("Desktop File exists, skipping")
        exitProcess(0)
    } else if (!desktopFileDirectory.exists()) {
        println("Creating file")
        desktopFileDirectory.createNewFile()
        creating(desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)
    }
}

fun creating(
    desktopFileDirectory: File,
    appName: String,
    runExec: String,
    categories: String,
    terminal: String,
    comment: String,
    icon: File,
) {
    desktopFileDirectory.writeText(
        "$MAINENTRY\n" +
            "Type=$APPLICATIONTYPE\n" +
            "Name=$appName\n" +
            "Exec=$runExec\n" +
            "Categories=$categories\n" +
            "Terminal=$terminal\n" +
            "Comment= $comment\n" +
            "Icon= $icon",
        charset = Charsets.UTF_8,
    )
}

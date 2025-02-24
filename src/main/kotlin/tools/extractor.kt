package kuruekmek.tools

import com.lordcodes.turtle.shellRun
import java.io.File

fun extractor(extractFileDirectory: File, downloadfileDirectory: File, desktopFileDirectory: File, appName: String, runExec: String, categories: String, terminal: String, comment: String, icon: File, extractWithWhat: String) {
    checkIfFileBeExtractedExists(extractFileDirectory, downloadfileDirectory, desktopFileDirectory, appName, runExec, categories, terminal, comment, icon, extractWithWhat)
}

fun checkIfFileBeExtractedExists(extractFileDirectory: File, downloadfileDirectory: File, desktopFileDirectory: File, appName: String, runExec: String, categories: String, terminal: String, comment: String, icon: File, extractWithWhat: String) {
    if (extractFileDirectory.exists()) {
        println("The folder, that was supposed to be extracted, already exists, skipping ")
        desktopCreator(desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)

    } else if (!extractFileDirectory.exists()) {
        println("Extracting")
        extracting(downloadfileDirectory, extractFileDirectory, desktopFileDirectory, appName, runExec, categories, terminal, comment, icon, extractWithWhat)
    }
}

fun extracting(downloadfileDirectory: File, extractFileDirectory: File, desktopFileDirectory: File, appName: String, runExec: String, categories: String, terminal: String, comment: String, icon: File, extractWithWhat: String) {
    shellRun {
        extractFileDirectory.mkdir()
        commandSequence("tar", listOf("xvf", downloadfileDirectory.toString(), "-C", extractFileDirectory.toString(), extractWithWhat)).forEach { line ->
            println(line)
        }.toString()
    }
    desktopCreator(desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)
}
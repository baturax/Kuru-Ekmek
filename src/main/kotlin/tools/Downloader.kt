package kuruekmek.tools

import com.lordcodes.turtle.shellRun
import java.io.File

fun downloader(
    downloadFileDirectory: File,
    url: String,
    extractFileDirectory: File,
    desktopFileDirectory: File,
    appName: String,
    runExec: String,
    categories: String,
    terminal: String,
    comment: String,
    icon: File,
    extractWithWhat: String,
) {
    checkIfDownloadedFileExists(
        downloadFileDirectory,
        url,
        extractFileDirectory,
        desktopFileDirectory,
        appName,
        runExec,
        categories,
        terminal,
        comment,
        icon,
        extractWithWhat,
    )
}

fun checkIfDownloadedFileExists(
    downloadFileDirectory: File,
    url: String,
    extractFileDirectory: File,
    desktopFileDirectory: File,
    appName: String,
    runExec: String,
    categories: String,
    terminal: String,
    comment: String,
    icon: File,
    extractWithWhat: String,
) {
    if (downloadFileDirectory.exists()) {
        println("The file that was supposed to be downloaded already exists, skipping")
        extractor(
            extractFileDirectory,
            downloadFileDirectory,
            desktopFileDirectory,
            appName,
            runExec,
            categories,
            terminal,
            comment,
            icon,
            extractWithWhat,
        )
    } else if (!downloadFileDirectory.exists()) {
        downloading(
            url,
            downloadFileDirectory,
            extractFileDirectory,
            desktopFileDirectory,
            appName,
            runExec,
            categories,
            terminal,
            comment,
            icon,
            extractWithWhat,
        )
    }
}

fun downloading(
    url: String,
    downloadFileDirectory: File,
    extractFileDirectory: File,
    desktopFileDirectory: File,
    appName: String,
    runExec: String,
    categories: String,
    terminal: String,
    comment: String,
    icon: File,
    extractWithWhat: String,
) {
    println("Downloading")
    repeat(100) {
        print("-")
    }
    println("")
    shellRun {
        commandSequence("wget", listOf("-O", downloadFileDirectory.toString(), url))
            .forEach { line ->
                println(line)
            }.toString()
    }
    extractor(
        extractFileDirectory,
        downloadFileDirectory,
        desktopFileDirectory,
        appName,
        runExec,
        categories,
        terminal,
        comment,
        icon,
        extractWithWhat,
    )
    println("Downloaded successfully")
}

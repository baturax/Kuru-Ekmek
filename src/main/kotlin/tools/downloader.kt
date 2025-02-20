package kuruekmek.tools

import java.io.File
import com.lordcodes.turtle.shellRun

fun downloader(downloadFileDirectory: File, url: String, extractFileDirectory: File, desktopFileDirectory: File, appName: String, runExec: String, categories: String, terminal: String, comment: String, icon: File) {
    checkIfDownloadedFileExists(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)

}

fun checkIfDownloadedFileExists(downloadFileDirectory: File, url: String, extractFileDirectory: File, desktopFileDirectory: File, appName: String, runExec: String, categories: String, terminal: String, comment: String, icon: File) {
    if (downloadFileDirectory.exists()) {
        println("The file that was supposed to be downloaded already exists, skipping")
        extractor(extractFileDirectory, downloadFileDirectory, desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)
    } else if (!downloadFileDirectory.exists()) {
        downloading(url, downloadFileDirectory,  extractFileDirectory, desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)
    }
}

fun downloading(url: String, downloadFileDirectory: File, extractFileDirectory: File, desktopFileDirectory: File, appName: String, runExec: String, categories: String, terminal: String, comment: String, icon: File) {
    println("Downloading")
    repeat(100) {
        print("-")
    }
    println("")
    shellRun {
        commandSequence("wget", listOf("-O", downloadFileDirectory.toString(), url)).forEach { line ->
            println(line)
        }.toString()
    }
    extractor(extractFileDirectory, downloadFileDirectory, desktopFileDirectory, appName, runExec, categories, terminal, comment, icon)
    println("Downloaded successfully")
}
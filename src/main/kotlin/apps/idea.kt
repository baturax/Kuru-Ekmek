package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File

open class Idea {
    private val version = "2024.3.3"
    private val url = "https://download-cdn.jetbrains.com/idea/ideaIU-$version.tar.gz"
    private val fileName = "idea"
    private val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    private val appName = "Idea"
    private val comment = "The IDE for Professional Development"
    private val runExec = File("$binDirectory/$fileName/bin/idea")
    private val icon = File("$binDirectory/$fileName/bin/idea.png")
    private val categories = "Development"
    private val terminal = "false"

    fun idea() {
        downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon)
    }

    fun ideaWayland() {

        val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
        ideaWayland(desktopFileDirectory)
    }

    fun ideaUninstall() {
        //TODO
    }
    }

fun idea() {
    Idea().idea()
}

fun ideaWayland() {
    Idea().ideaWayland()
}

fun ideaUninstall() {
    Idea().ideaUninstall()
}

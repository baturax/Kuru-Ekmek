package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class Ferdium {
    private val version = "7.0.1"
    private val url = "https://github.com/ferdium/ferdium-app/releases/download/v$version/Ferdium-linux-$version.tar.gz"
    private val fileName = "ferdium"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    private val appName = "Ferdium"
    private val comment = " All your services in one place, built by the community "
    private val runExec = File("$binDirectory/$fileName/ferdium")
    private val icon = File("$binDirectory/$fileName/resources/")
    private val categories = "Social"
    private val terminal = "false"

    fun ferdium() {
        downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon, extractTarWithOneFolderUp)
    }

    fun ferdiumWayland() {
        val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
        electronWayland(desktopFileDirectory)
    }

    @OptIn(ExperimentalPathApi::class)
    fun ferdiumUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
        Path("$configDirectory/$appName").deleteRecursively()
        Path("$autoStartDirectory/$fileName$desktopext").deleteRecursively()
    }
}

fun ferdium() {
    Ferdium().ferdium()
}

fun ferdiumWayland() {
    Ferdium().ferdiumWayland()
}

fun ferdiumUninstall() {
    Ferdium().ferdiumUninstall()
}
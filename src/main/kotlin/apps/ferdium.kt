package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

fun ferdium() {
        //For files
    val version = "7.0.0"
    val url = "https://github.com/ferdium/ferdium-app/releases/download/v$version/Ferdium-linux-$version.tar.gz"
    val fileName = "ferdium"
    val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    val extractFileDirectory = File("$binDirectory/$fileName")
    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")


        //For desktop
    val appName = "Ferdium"
    val comment = " All your services in one place, built by the community "
    val runExec = File("$binDirectory/$fileName/ferdium")
    val icon = File("$binDirectory/$fileName/resources/")
    val categories = "Social"
    val terminal = "false"

    downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon)
}

fun ferdiumWayland() {
    val fileName = "ferdium"

    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
    electronWayland(desktopFileDirectory)
}

@OptIn(ExperimentalPathApi::class)
fun ferdiumUninstall() {
    val fileName = "ferdium"
    File("$cacheDirectory/$fileName$targzext").delete()
    Path("$configDirectory/Ferdium").deleteRecursively()
    Path("$binDirectory/$fileName").deleteRecursively()
    File("$desktopsDirectory/$fileName$desktopext").delete()
}
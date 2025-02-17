package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

fun clion() {
    //For files
    val version = "2024.3.3"
    val url = "https://download-cdn.jetbrains.com/cpp/CLion-$version.tar.gz"
    val fileName = "clion"
    val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    val extractFileDirectory = File("$binDirectory/$fileName")
    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    val appName = "Clion"
    val comment = "A cross-platform IDE for C and C++"
    val runExec = File("$binDirectory/$fileName/bin/clion")
    val icon = File("$binDirectory/$fileName/bin/clion.png")
    val categories = "Development"
    val terminal = "false"

    downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon)
}

fun clionWayland() {
    val fileName = "clion"

    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
    ideaWayland(desktopFileDirectory)
}

@OptIn(ExperimentalPathApi::class)
fun clionUninstall() {
    val cacheNames = "CLion2024.3"
    val fileName = "clion"
    File("$cacheDirectory/$fileName$targzext").delete()
    Path("$cacheDirectory/JetBrains/$cacheNames").deleteRecursively()
    Path("$configDirectory/JetBrains/$cacheNames").deleteRecursively()
    Path("$binDirectory/$fileName").deleteRecursively()
    File("$desktopsDirectory/$fileName$desktopext").delete()

}
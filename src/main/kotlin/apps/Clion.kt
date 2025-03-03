package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class Clion {
    private val version = "2024.3.4"
    private val fileVersion = "2024.3"
    private val url = "https://download-cdn.jetbrains.com/cpp/CLion-$version.tar.gz"
    private val fileName = "clion"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$TARGZEXT")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$DESKTOPEXT")

    // For desktop
    private val appName = "Clion"
    private val comment = "A cross-platform IDE for C and C++"
    private val runExec = File("$binDirectory/$fileName/bin/clion")
    private val icon = File("$binDirectory/$fileName/bin/clion.png")
    private val categories = "Development"
    private val terminal = "false"

    fun clion() {
        downloader(
            downloadFileDirectory,
            url,
            extractFileDirectory,
            desktopFileDirectory,
            appName,
            runExec.toString(),
            categories,
            terminal,
            comment,
            icon,
            EXTRACTTARWITHONEFOLDERUP,
        )
    }

    fun clionWayland() {
        val desktopFileDirectory = File("$desktopsDirectory/$fileName$DESKTOPEXT")
        jetbrainsWayland(desktopFileDirectory)
    }

    @OptIn(ExperimentalPathApi::class)
    fun clionUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
        Path("$configDirectory/$JETBRAINS/CLion$fileVersion").deleteRecursively()
        Path("$realCacheDirectory/$JETBRAINS/CLion$fileVersion").deleteRecursively()
    }
}

fun clion() {
    Clion().clion()
}

fun clionWayland() {
    Clion().clionWayland()
}

fun clionUninstall() {
    Clion().clionUninstall()
}

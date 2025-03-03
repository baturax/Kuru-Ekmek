@file:Suppress("ktlint:standard:no-wildcard-imports")

package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class PrismLauncher {
    private val version = "9.2"
    private val url =
        "https://github.com/PrismLauncher/PrismLauncher/releases/download/$version/PrismLauncher-Linux-Qt6-Portable-$version.tar.gz"
    private val fileName = "prismlauncher"
    // private val fileVersion = "2024.3"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$TARGZEXT")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$DESKTOPEXT")

    // For desktop
    private val appName = "Prism Launcher"
    private val comment =
        " A custom launcher for Minecraft that allows you to easily manage multiple installations of Minecraft at once (Fork of MultiMC) "
    private val runExec = File("$binDirectory/$fileName/PrismLauncher")
    private val icon =
        File("$binDirectory/$fileName/share/icons/hicolor/scalable/apps/org.prismlauncher.PrismLauncher.svg")
    private val categories = "Game"
    private val terminal = "false"

    fun prismLauncher() {
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
            JUSTEXTRACT,
        )
    }

    fun prismLauncherWayland() {
        println("No need wayland for this")
    }

    @OptIn(ExperimentalPathApi::class)
    fun prismLauncherUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
    }
}

fun prismLauncher() {
    PrismLauncher().prismLauncher()
}

fun prismLauncherWayland() {
    PrismLauncher().prismLauncherWayland()
}

fun prismLauncherUninstall() {
    PrismLauncher().prismLauncherUninstall()
}

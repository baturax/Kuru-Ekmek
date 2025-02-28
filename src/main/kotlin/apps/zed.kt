package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class Zed {
    private val version = "0.175.6"
    private val url = "https://github.com/zed-industries/zed/releases/download/v$version/zed-linux-x86_64.tar.gz"
    private val fileName = "zed"
    // private val fileVersion = "2024.3"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    private val appName = "Zed"
    private val comment = ""
    private val runExec = File("$binDirectory/$fileName/bin/zed")
    private val icon = File("$binDirectory/$fileName/share/icons/hicolor/1024x1024/apps/zed.png")
    private val categories = ""
    private val terminal = "false"

    fun zedEditor() {
        downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon, extractTarWithOneFolderUp)
    }

    fun zedEditorWayland() {
        println("No need wayland for this app")
    }

    @OptIn(ExperimentalPathApi::class)
    fun zedEditorUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
        Path("$configDirectory/zed").deleteRecursively()
        Path("$shareDirectory/zed").deleteRecursively()
        Path("$realCacheDirectory/zed").deleteRecursively()

    }
}

fun zedEditor() {
    Zed().zedEditor()
}

fun zedEditorWayland() {
    Zed().zedEditorWayland()
}

fun zedEditorUninstall() {
    Zed().zedEditorUninstall()
}

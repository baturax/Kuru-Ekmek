package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class LocalSend {
    private val version = "1.17.0"
    private val url = "https://github.com/localsend/localsend/releases/download/v$version/LocalSend-$version-linux-x86-64.tar.gz"
    private val fileName = "localsend"
    // private val fileVersion = "2024.3"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    private val appName = "Local Send"
    private val comment = " An open-source cross-platform alternative to AirDrop"
    private val runExec = File("$binDirectory/$fileName/localsend_app")
    private val icon = File("$binDirectory/$fileName/data/flutter_assets/assets/img/logo.ico")
    private val categories = "Image"
    private val terminal = "false"

    fun localSend() {
        downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon, justExtract)
    }

//    fun localSendWayland() {
//        val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
//        electronWayland(desktopFileDirectory)
//    }

    @OptIn(ExperimentalPathApi::class)
    fun localSendUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
        Path("$shareDirectory/org.localsend.localsend_app").deleteRecursively()

    }
}

fun localSend() {
    LocalSend().localSend()
    println("Make Sure libayatana-appindicator is installed, otherwise app won't work.")
}

fun localSendWayland() {
    println("No need wayland support for this app")
}

fun localSendUninstall() {
    LocalSend().localSendUninstall()
}
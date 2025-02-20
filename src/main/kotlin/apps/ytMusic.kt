package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class YtMusic {
    private val version = "3.7.2"
    private val url = "https://github.com/th-ch/youtube-music/releases/download/v${version}/youtube-music-$version.tar.gz"
    private val fileName = "youtube-music"
    private val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    private val appName = "Youtube Music"
    private val comment = "YouTube Music Desktop App bundled with custom plugins (and built-in ad blocker / downloader"
    private val runExec = File("$binDirectory/$fileName/$fileName")
    private val icon = File("$binDirectory/$fileName/resources/app.asar.unpacked/assets/$fileName$pngExt")
    private val categories = "Music"
    private val terminal = "false"

    fun ytMusic() {
        downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon)
    }

    fun ytMusicWayland() {
        val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
        electronWayland(desktopFileDirectory)
    }

    @OptIn(ExperimentalPathApi::class)
    fun ytMusicUninstall() {
        Path("$configDirectory/YouTube Music").deleteRecursively()
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
    }
}

fun ytMusic() {
    YtMusic().ytMusic()
}

fun ytMusicWayland() {
    YtMusic().ytMusicWayland()
}

fun ytMusicUninstall() {
    YtMusic().ytMusicUninstall()
}
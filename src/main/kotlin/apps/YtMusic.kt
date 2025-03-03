package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class YtMusic {
    private val version = "3.7.5"
    private val url =
        "https://github.com/th-ch/youtube-music/releases/download/v$version/youtube-music-$version.tar.gz"
    private val fileName = "youtube-music"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$TARGZEXT")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$DESKTOPEXT")

    // For desktop
    private val appName = "Youtube Music"
    private val comment = "YouTube Music Desktop App bundled with custom plugins (and built-in ad blocker / downloader"
    private val runExec = File("$binDirectory/$fileName/$fileName")
    private val icon = File("$binDirectory/$fileName/resources/app.asar.unpacked/assets/$fileName$PNGEXT")
    private val categories = "Music"
    private val terminal = "false"

    fun ytMusic() {
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

    fun ytMusicWayland() {
        val desktopFileDirectory = File("$desktopsDirectory/$fileName$DESKTOPEXT")
        electronWayland(desktopFileDirectory)
    }

    @OptIn(ExperimentalPathApi::class)
    fun ytMusicUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
        Path("$configDirectory/YouTube Music").deleteRecursively()
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

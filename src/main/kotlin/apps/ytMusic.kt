package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

fun ytMusic() {
        //For files
    val version = "3.7.2"
    val url = "https://github.com/th-ch/youtube-music/releases/download/v${version}/youtube-music-$version.tar.gz"
    val fileName = "youtube-music"
    val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    val extractFileDirectory = File("$binDirectory/$fileName")
    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")


        //For desktop
    val appName = "Youtube Music"
    val comment = "YouTube Music Desktop App bundled with custom plugins (and built-in ad blocker / downloader"
    val icon = File("$binDirectory/$fileName/resources/app.asar.unpacked/assets/$fileName$pngExt")
    val runExec = File("$binDirectory/$fileName/$fileName")
    val categories = "Music"
    val terminal = "false"

    downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon)
}

fun ytMusicWayland() {
    val fileName = "youtube-music"

    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
    electronWayland(desktopFileDirectory)
}

@OptIn(ExperimentalPathApi::class)
fun ytMusicUninstall() {
    val fileName = "youtube-music"
    File("$cacheDirectory/$fileName$targzext").delete()
    Path("$configDirectory/YouTube Music").deleteRecursively()
    Path("$binDirectory/$fileName").deleteRecursively()
    File("$desktopsDirectory/$fileName$desktopext").delete()

}
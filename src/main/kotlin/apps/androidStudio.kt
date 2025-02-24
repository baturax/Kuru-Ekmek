package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class AndroidStudio {
    private val version = "2024.2.2.14"
    private val fileVersion = "2024.2"
    private val url = "https://dl.google.com/dl/android/studio/ide-zips/$version/android-studio-$version-linux.tar.gz"
    private val fileName = "android-studio"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    private val appName = "Android Studio"
    private val comment = "The official IDE for Android app development now accelerates your productivity with Gemini in Android Studio, your AI-powered coding companion."
    private val runExec = File("$binDirectory/$fileName/bin/studio")
    private val icon = File("$binDirectory/$fileName/bin/studio.png")
    private val categories = "Development"
    private val terminal = "false"

    fun androidStudio() {
        downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon, extractTarWithOneFolderUp)
    }

    fun androidStudioWayland() {
        val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
        jetbrainsWayland(desktopFileDirectory)
    }

    @OptIn(ExperimentalPathApi::class)
    fun androidStudioUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
        Path("$whereIsMyHome/.android").deleteRecursively()
        Path("$whereIsMyHome/Android").deleteRecursively()
        Path("$configDirectory/Google").deleteRecursively()
        Path("$whereIsMyHome/.android").deleteRecursively()
        Path("$realCacheDirectory/Google/AndroidStudio$fileVersion").deleteRecursively()
    }
}

fun androidStudio() {
    AndroidStudio().androidStudio()
}

fun androidStudioWayland() {
    AndroidStudio().androidStudioWayland()
}

fun androidStudioUninstall() {
    AndroidStudio().androidStudioUninstall()
}

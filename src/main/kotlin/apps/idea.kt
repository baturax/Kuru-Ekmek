package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

fun idea() {
        //For files
    val version = "2024.3.3"
    val url = "https://download-cdn.jetbrains.com/idea/ideaIU-$version.tar.gz"
    val fileName = "idea"
    val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    val extractFileDirectory = File("$binDirectory/$fileName")
    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

        //For desktop
    val appName = "Idea"
    val comment = "The IDE for Professional Development"
    val runExec = File("$binDirectory/$fileName/bin/idea")
    val icon = File("$binDirectory/$fileName/bin/idea.png")
    val categories = "Development"
    val terminal = "false"

    downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon)
}

fun ideaWayland() {
    val fileName = "idea"

    val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
    ideaWayland(desktopFileDirectory)
}

@OptIn(ExperimentalPathApi::class)
fun ideaUninstall() {
    val cacheNames = "IntelliJIdea2024.3"
    val fileName = "Idea"
    File("$cacheDirectory/$fileName$targzext").delete()
    Path("$cacheDirectory/JetBrains/$cacheNames").deleteRecursively()
    Path("$configDirectory/JetBrains/$cacheNames").deleteRecursively()
    Path("$binDirectory/$fileName").deleteRecursively()
    File("$desktopsDirectory/$fileName$desktopext").delete()
}

package kuruekmek.apps

import kuruekmek.tools.*
import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

open class VsCode {
    private val version = "1.97.2.25045"
    private val url = "https://github.com/VSCodium/vscodium/releases/download/$version/VSCodium-linux-x64-$version.tar.gz"
    private val fileName = "vscodium"

    private val downloadFileDirectory = File("$cacheDirectory/$fileName$targzext")
    private val extractFileDirectory = File("$binDirectory/$fileName")
    private val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")

    //For desktop
    private val appName = "VsCodium"
    private val comment = " binary releases of VS Code without MS branding/telemetry/licensing"
    private val runExec = File("$binDirectory/$fileName/codium")
    private val icon = File("$binDirectory/$fileName/resources/app/resources/linux/code.png")
    private val categories = "Development"
    private val terminal = "false"

    fun vsCode() {
        downloader(downloadFileDirectory, url, extractFileDirectory, desktopFileDirectory, appName, runExec.toString(), categories, terminal, comment, icon, extractTarWithOneFolderUp)
    }

    fun vsCodeWayland() {
        val desktopFileDirectory = File("$desktopsDirectory/$fileName$desktopext")
        electronWayland(desktopFileDirectory)
    }

    @OptIn(ExperimentalPathApi::class)
    fun vsCodeUninstall() {
        Path("$extractFileDirectory").deleteRecursively()
        Path("$desktopFileDirectory").deleteRecursively()
        Path("$downloadFileDirectory").deleteRecursively()
        Path("$whereIsMyHome/.vscode-oss").deleteRecursively()
        Path("$configDirectory/VSCodium").deleteRecursively()

    }
}

fun vsCode() {
    VsCode().vsCode()
}

fun vsCodeWayland() {
    VsCode().vsCodeWayland()
}

fun vsCodeUninstall() {
    VsCode().vsCodeUninstall()
}

package kuruekmek.tools

import java.io.File

val whereIsMyHome: String? = System.getProperty("user.home")
val cacheDirectory: File = File("$whereIsMyHome/.cache/downloaders")
val binDirectory: File = File("$whereIsMyHome/.local/bin")
val shareDirectory: File = File("$whereIsMyHome/.local/share")
val configDirectory: File = File("$whereIsMyHome/.config")
val desktopsDirectory: File = File("$shareDirectory/applications")
val fontsDirectory: File = File("$shareDirectory/fonts")
val autoStartDirectory: File = File("$configDirectory/autostart")
val realCacheDirectory: File = File("$whereIsMyHome/.cache")

const val jetbrains = "JetBrains"
const val mainEntry = "[Desktop Entry]"
const val applicationType = "Application"
const val waylandElectron = " 4s/$/ --ozone-platform=wayland/"
const val waylandJetbrains = " 4s/$/ -Dawt.toolkit.name=WLToolkit/"
const val targzext = ".tar.gz"
//const val zipext = ".zip"
const val desktopext = ".desktop"
const val extractTarWithOneFolderUp = "--strip-components=1"
const val pngExt = ".png"
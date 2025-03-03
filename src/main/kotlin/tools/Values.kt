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

const val JETBRAINS = "JetBrains"
const val MAINENTRY = "[Desktop Entry]"
const val APPLICATIONTYPE = "Application"
const val WAYLANDELECTRON = " 4s/$/ --ozone-platform=wayland/"
const val WAYLANDJETBRAINS = " 4s/$/ -Dawt.toolkit.name=WLToolkit/"
const val TARGZEXT = ".tar.gz"

// const val zipext = ".zip"
const val DESKTOPEXT = ".desktop"
const val EXTRACTTARWITHONEFOLDERUP = "--strip-components=1"
const val JUSTEXTRACT = ""
const val PNGEXT = ".png"

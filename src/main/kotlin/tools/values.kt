package kuruekmek.tools

import java.io.File

val whereIsMyHome: String? = System.getProperty("user.home")
val cacheDirectory: File = File("$whereIsMyHome/.cache/downloaders")
val binDirectory: File = File("$whereIsMyHome/.local/bin")
val configDirectory: File = File("$whereIsMyHome/.config")
val desktopsDirectory: File = File("$whereIsMyHome/.local/share/applications")

const val mainEntry = "[Desktop Entry]"
const val applicationType = "Application"
const val waylandElectron = " 4s/$/ --ozone-platform=wayland/"
const val waylandJetbrains = " 4s/$/ -Dawt.toolkit.name=WLToolkit/"
const val targzext = ".tar.gz"
const val zipext = ".zip"
const val desktopext = ".desktop"
const val extractTarWithOneFolderUp = "--strip-components=1"
const val pngExt = ".png"
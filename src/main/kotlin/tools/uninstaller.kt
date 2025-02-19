package kuruekmek.tools

import java.io.File
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.deleteRecursively

@OptIn(ExperimentalPathApi::class)
fun uninstaller(fileName: String, cacheDirectoryOfFile: String?, cacheNames: String?) {
    File("$cacheDirectory/$fileName$targzext").delete()

    Path("$cacheDirectory/$cacheDirectoryOfFile/$cacheNames").deleteRecursively()

    Path("$configDirectory/$cacheDirectoryOfFile/$cacheNames").deleteRecursively()

    Path("$configDirectory/$fileName").deleteRecursively()

    Path("$binDirectory/$fileName").deleteRecursively()

    File("$desktopsDirectory/$fileName$desktopext").delete()

}
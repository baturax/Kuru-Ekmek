package kuruekmek.tools

import java.io.IOException
import kotlin.system.exitProcess

fun checkETC() {
    checkWget()
    checkCacheDirectory()
    checkbinDirectory()
    checkConfigDirectory()
    checkDesktopsDirectory()
    finished()
}

fun finished() {
    ProcessBuilder("bash", "-c", "sleep 1").start().waitFor()
    ProcessBuilder("bash", "-c", "clear").redirectOutput(ProcessBuilder.Redirect.INHERIT).start().waitFor()
}

fun checkCacheDirectory() {
    if (cacheDirectory.exists()) {
        println("Cache directory exists, skipping")
    } else if (!cacheDirectory.exists()) {
        println("Creating cache directory for you")
        cacheDirectory.mkdir()
    } else {
        println("IDK what the problem is, open pr on github. 😉")
    }
}

fun checkbinDirectory() {
    if (binDirectory.exists()) {
        println("Bin directory exists, skipping.")
    } else if (!binDirectory.exists()) {
        println("Bin directory doesn't exist, creating for you.")
        binDirectory.mkdirs()
    } else {
        println("IDK what the problem is, open pr on github. 😉")
    }
}

fun checkConfigDirectory() {
    if (configDirectory.exists()) {
        println("Config directory exists, skipping.")
    } else if (!configDirectory.exists()) {
        println("Config directory doesn't exist, creating for you.")
        configDirectory.mkdir()
    } else {
        println("IDK what the problem is, open pr on github. 😉")
    }
}

fun checkDesktopsDirectory() {
    if (desktopsDirectory.exists()) {
        println("Directory for applications exists, skipping.")
    } else if (!desktopsDirectory.exists()) {
        println("Directory for applications doesn't exist, creating for you.")
        desktopsDirectory.mkdir()
    } else {
        println("IDK what the problem is, open pr on github. 😉")
    }
}

fun checkWget() {
    try {
        ProcessBuilder("wget").start().waitFor()
    } catch (_: IOException) {
        println("Wget  isn't either installed or in PATH. Fix n come back")
        exitProcess(0)
    }
}
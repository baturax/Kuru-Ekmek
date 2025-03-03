plugins {
    kotlin("jvm") version "2.1.10"
}

group = "KuruEkmek"
version = "kuruekmek"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.lordcodes.turtle:turtle:0.10.0")
}

kotlin {
    jvmToolchain(23)
}

tasks.jar.configure {
    manifest {
        attributes(mapOf("Main-Class" to "kuruekmek.MainKt"))
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

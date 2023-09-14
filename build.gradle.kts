plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.10"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "ua.mani123"
version = findProperty("version")!!
val projectName = findProperty("projectName")!!

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://jitpack.io/")
    maven("https://maven.arbjerg.dev/snapshots")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://maven.topi.wtf/snapshots/")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.6.0")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    compileOnly("com.github.topi314.lavasrc:lavasrc:4458182")
    compileOnly("dev.arbjerg:lavaplayer:78733ec")
    implementation("org.bstats:bstats-base:3.0.2")
    implementation("ch.qos.logback", "logback-classic", "1.4.11")
    compileOnly("com.github.discord-jda:JDA:master-SNAPSHOT")

    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    relocate("org.bstats", "ua.mani123.libs.bstats")
    manifest {
        attributes(
            mapOf(
                "Specification-Title" to projectName,
                "Specification-Version" to version,
                "Specification-Vendor" to "WorldMandia",
                "Implementation-Title" to projectName,
                "Implementation-Version" to version,
                "Implementation-Vendor" to "WorldMandia",
                "Main-Class" to "ua.mani123.init.MainKt"
            )
        )
    }
    archiveFileName.set("$projectName-$version-all.jar")
}

kotlin {
    jvmToolchain(17)
}

tasks {
    processResources {
        filesMatching(listOf("**plugin.yml")) {
            expand(
                mapOf(
                    "projectVersion" to project.version,
                    "projectName" to projectName
                )
            )
        }
    }
    javadoc {
        options.encoding = Charsets.UTF_8.toString()
    }
    compileJava {
        options.encoding = Charsets.UTF_8.toString()
    }
    compileTestJava {
        options.encoding = Charsets.UTF_8.toString()
    }
}
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
    maven("https://maven.topi.wtf/releases")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://jitpack.io/")
    maven("https://maven.arbjerg.dev/snapshots")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://nexuslite.gcnt.net/repos/other/")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.6.0-RC")
    //implementation("org.mongodb:mongodb-driver-kotlin-coroutine:4.10.2")
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    implementation("com.github.discord-jda:JDA:master-SNAPSHOT")
    implementation("dev.arbjerg:lavaplayer:9c92cf39faedd5218b7e086e8ece13a21bff2f0a-SNAPSHOT") {
        exclude("commons-codec")
    }
    implementation("com.github.topi314.lavasrc:lavasrc:3f26e2e")
    // https://mvnrepository.com/artifact/org.bstats/bstats-base
    implementation("org.bstats:bstats-base:3.0.2")
    implementation("commons-codec:commons-codec:1.16.0")
    implementation("com.jcabi:jcabi-manifests:2.1.0")
    //implementation("dev.arbjerg:lavaplayer:2.0.0")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation("com.tcoded:FoliaLib:0.2.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    relocate("com.tcoded.folialib", "ua.mani123.libs.folialib")
    relocate("com.jcabi", "ua.mani123.libs.jcabi-manifests")
    relocate("com.charleskorn.kaml", "ua.mani123.libs.kaml")
    relocate("dev.arbjerg", "ua.mani123.libs.lavaplayer")
    relocate("com.github.discord-jda", "ua.mani123.libs.JDA")
    relocate("commons-codec", "ua.mani123.libs.commons-codec")
    relocate("org.bstats", "ua.mani123.libs.bstats-base")

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
            expand(mapOf(
                "projectVersion" to project.version,
                "projectName" to projectName
            ))
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
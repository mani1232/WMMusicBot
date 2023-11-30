plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "ua.mani123"
version = findProperty("version")!!

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://jitpack.io/")
        maven("https://maven.arbjerg.dev/snapshots")
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://maven.topi.wtf/snapshots/")
        maven("https://nexuslite.gcnt.net/repos/other/")
        maven("https://repo.hypera.dev/snapshots/")
    }

    tasks.test {
        useJUnitPlatform()
    }

    kotlin {
        jvmToolchain(17)
    }

    tasks {
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

}
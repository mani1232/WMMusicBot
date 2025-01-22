plugins {
    kotlin("jvm") version "2.1.20-Beta1"
    id("com.gradleup.shadow") version "9.0.0-beta5"
}

group = "ua.mani123"
version = findProperty("version")!!

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "com.gradleup.shadow")

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
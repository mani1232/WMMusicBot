val projectName = findProperty("LoaderName")!!

dependencies {
    implementation("dev.hypera:Dragonfly:0.3.1-SNAPSHOT")
    implementation("com.github.technicallycoded:FoliaLib:main-SNAPSHOT")
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
}

tasks.shadowJar {
    relocate("com.tcoded.folialib", "ua.mani123.libs.folialib")

    manifest {
        attributes(
            mapOf(
                "Specification-Title" to projectName,
                "Specification-Version" to version,
                "Specification-Vendor" to "WorldMandia",
                "Implementation-Title" to projectName,
                "Implementation-Version" to version,
                "Implementation-Vendor" to "WorldMandia",
                "Main-Class" to "ua.mani123.LoaderMainKt"
            )
        )
    }
    archiveFileName.set("$projectName-$version-all.jar")
}
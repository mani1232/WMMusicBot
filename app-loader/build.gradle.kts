val projectName = findProperty("LoaderName")!!

dependencies {
    implementation("dev.hypera:Dragonfly:0.3.1-SNAPSHOT")
    implementation("com.tcoded:FoliaLib:0.2.5")
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")

    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
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
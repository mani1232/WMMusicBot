val projectName = findProperty("LoaderName")!!

dependencies {
    implementation("dev.hypera:Dragonfly:0.3.0-SNAPSHOT")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.tcoded:FoliaLib:0.2.5")
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
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
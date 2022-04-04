plugins {
    id("fabric-loom")
    val kotlinVersion: String by System.getProperties()
    kotlin("jvm").version(kotlinVersion)
}
base {
    val archivesBaseName: String by project
    archivesName.set(archivesBaseName)
}

val modVersion: String by project
version = modVersion
val mavenGroup: String by project
group = mavenGroup

repositories {
    maven {
        url = uri("https://storage.googleapis.com/devan-maven/")
    }
    maven {
        name = "Ladysnake Mods"
        url = uri("https://ladysnake.jfrog.io/artifactory/mods")
    }
}

dependencies {
    val minecraftVersion: String by project
    minecraft("com.mojang:minecraft:$minecraftVersion")
    val yarnMappings: String by project
    mappings("net.fabricmc:yarn:$yarnMappings:v2")
    val loaderVersion: String by project
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
    val fabricVersion: String by project
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricVersion")
    val fabricKotlinVersion: String by project
    modImplementation("net.fabricmc:fabric-language-kotlin:$fabricKotlinVersion")
    modImplementation("dev.onyxstudios.cardinal-components-api:cardinal-components-base:4.1.4")
    modImplementation("dev.onyxstudios.cardinal-components-api:cardinal-components-chunk:4.1.4")
    modImplementation("net.devtech:arrp:0.5.7")
}
tasks {
    val javaVersion = JavaVersion.VERSION_17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions { jvmTarget = javaVersion.toString() }
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
    }
    jar { from("LICENSE") { rename { "${it}_${base.archivesName}" } } }
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.version)) }
    }
    java {
        toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion.toString())) }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
}

loom {
    runs {
        create("datagenClient") {
            this.client()
            this.name("Data Generation")
            this.vmArgs.add("-Dfabric-api.datagen")
            this.vmArgs.add("-Dfabric-api.datagen.output-dir=${file("src/generated/resources")}")
            this.ideConfigGenerated(true)
            this.runDir("build/datagen")
            this.source("main")
        }
    }
}

sourceSets {
    main {
        java {
            srcDir("src/main")
        }
        resources {
            srcDir("src/generated/resources")
        }
    }
}
plugins {
    kotlin("jvm") version "1.8.0"
    id("jacoco")
}

group = "ru.netology"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //implementation 'org.jetbrains.kotlin:kotlin-stdlib'
    testImplementation 'org.jetbrains.kotlin:kotlin-test'
}




kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
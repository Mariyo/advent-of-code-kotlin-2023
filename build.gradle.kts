plugins {
    kotlin("jvm") version "1.9.20"
}

group = "eu.mariyo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    wrapper {
        gradleVersion = "8.5"
    }
    test {
        useJUnitPlatform()
    }
}
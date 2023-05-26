plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "org.accmoment"
version = "1.0.0"

repositories {
    mavenCentral()

}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
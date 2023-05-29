
plugins {
    kotlin("jvm") version "1.8.21"
    application
//    `java-library`
//    `maven-publish`
}

group = "org.accmoment"
version = "1.0.0"

repositories {
    mavenCentral()
}

//publishing {
//    publications{
//        create<MavenPublication>("osu-data-reader"){
//            from(components["java"])
//        }
//    }
//
//    repositories{
//        maven{
//            name="osu-data-reader"
//            url= URI("https://github.com/AccMoment/osu-data-reader")
//        }
//    }
//}



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
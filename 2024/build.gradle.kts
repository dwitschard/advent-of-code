plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test"))
}

sourceSets.main {
    resources.srcDirs("src/main/resources")
}



tasks.test {
    useJUnitPlatform()
}
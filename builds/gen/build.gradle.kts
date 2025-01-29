plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinxSerializationJson)
    testImplementation(kotlin("test"))
}

tasks {
    test {
        useJUnitPlatform()
    }
}

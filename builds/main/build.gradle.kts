plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(":gen")
    implementation(libs.kotlinxSerializationJson)
    testImplementation(kotlin("test"))
}

application {
    mainClass = "MainKt"
}

tasks {
    test {
        useJUnitPlatform()
    }
}

plugins {
    kotlin("jvm") version "2.0.0"
    id( "java")
    id( "groovy")
    id("org.openrewrite.rewrite") version "6.20.0"
}

group = "com.sample"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

rewrite {
    activeRecipe(
        "org.openrewrite.java.OrderImports"
    )
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
    testImplementation(kotlin("test"))
    testImplementation("org.spockframework:spock-core:2.3-groovy-3.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
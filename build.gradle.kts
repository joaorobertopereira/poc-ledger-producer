import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.vaadin") version "24.3.1"
    id("org.jetbrains.kotlin.plugin.allopen") version ("1.4.30")
    id("org.jetbrains.kotlin.plugin.serialization") version ("1.4.30")
    id("maven-publish")
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
    kotlin("kapt") version "1.9.20"
}

group = "br.com.itau"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.04")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.2.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.1")
    implementation("org.springframework.kafka:spring-kafka:3.0.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("software.amazon.msk:aws-msk-iam-auth:1.1.9")
    implementation("aws.sdk.kotlin:aws-core-jvm:1.0.19")
    implementation("aws.sdk.kotlin:aws-endpoint-jvm:1.0.19")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
    testImplementation("io.projectreactor:reactor-test:3.5.4")
    testImplementation("org.springframework.kafka:spring-kafka-test:3.0.4")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

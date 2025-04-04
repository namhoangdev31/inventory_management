plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    kotlin("plugin.serialization") version "2.1.10"
    application
}

group = "org.example.inventory_management"
version = "1.0.0"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

repositories {
    mavenCentral()
    maven { url = uri("https://packages.confluent.io/maven/") }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
    implementation(libs.ktor.ktor.server.core)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.apache)
    implementation(libs.ktor.server.csrf)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.sessions)
    implementation(libs.ktor.server.double.receive)
    implementation(libs.ktor.line.webhook.plugin)
    implementation(libs.ktor.server.request.validation)
    implementation(libs.ktor.server.resources)
    implementation(libs.ktor.server.sse)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.webjars)
    implementation(libs.jquery)
    implementation(libs.ktor.server.caching.headers)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.http.redirect)
    implementation(libs.ktor.server.openapi)
    implementation(libs.ktor.simple.cache)
    implementation(libs.ktor.simple.memory.cache)
    implementation(libs.ktor.server.swagger)
    implementation(libs.ktor.simple.redis.cache)
    implementation(libs.ktor.ktor.server.call.logging)
    implementation(libs.ktor.server.thymeleaf)
    implementation(libs.postgresql)
    implementation(libs.h2)
//    implementation(libs.flaxoos.ktor.server.kafka)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)
    implementation(libs.ktor.server.websockets)
    implementation(libs.ktor.server.rate.limiting)
    implementation(libs.flaxoos.ktor.server.task.scheduling.core)
    implementation(libs.flaxoos.ktor.server.task.scheduling.redis)
    implementation(libs.ktor.server.task.scheduling.mongodb)
    implementation(libs.flaxoos.ktor.server.task.scheduling.jdbc)
    implementation(libs.ktor.server.freemarker)
    implementation(libs.ktor.server.call.id)
    implementation(libs.logback)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.jetbrains.kotlin.test.junit)
    implementation(libs.jbcrypt)
    implementation(libs.ktor.server.compression)
    implementation(libs.exposed.dao)
    implementation(libs.kotlinx.serialization.json)
}
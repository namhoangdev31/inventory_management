import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    val kotlinVersion: String by System.getProperties()
    kotlin("plugin.serialization") version kotlinVersion
    kotlin("multiplatform") version kotlinVersion
    val kvisionVersion: String by System.getProperties()
    id("io.kvision") version kvisionVersion
}

version = "1.0.0-SNAPSHOT"
group = "com.example"

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { url = uri("https://kotlin.bintray.com/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    maven { url = uri("https://dl.bintray.com/rjaros/kotlin") }
}

// Versions
val kotlinVersion: String by System.getProperties()
val kvisionVersion: String by System.getProperties()
val ktorVersion: String by project
val exposedVersion: String by project
val hikariVersion: String by project
val h2Version: String by project
val pgsqlVersion: String by project
val kweryVersion: String by project
val logbackVersion: String by project
val commonsCodecVersion: String by project
val jdbcNamedParametersVersion: String by project
val koinVersion: String by project
val bcryptVersion: String by project
val coroutinesVersion: String by project

val mainClassName = "io.ktor.server.netty.EngineMain"

kotlin {
    jvmToolchain(21)
    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        mainRun {
            mainClass.set(mainClassName)
        }
    }
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "main.bundle.js"
                sourceMaps = false
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.kvision:kvision-server-ktor-koin:$kvisionVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(kotlin("reflect"))
                implementation("io.ktor:ktor-server-core:$ktorVersion")
                implementation("io.ktor:ktor-server-auth:$ktorVersion")
                implementation("io.ktor:ktor-server-auth-jwt:$ktorVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-apache:$ktorVersion")
                implementation("io.ktor:ktor-server-csrf:$ktorVersion")
                implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-server-sessions:$ktorVersion")
                implementation("io.ktor:ktor-server-double-receive:$ktorVersion")
                implementation("io.github.cotrin8672:ktor-line-webhook-plugin:1.5.0")
                implementation("io.ktor:ktor-server-request-validation:$ktorVersion")
                implementation("io.ktor:ktor-server-resources:$ktorVersion")
                implementation("io.ktor:ktor-server-sse:$ktorVersion")
                implementation("io.ktor:ktor-server-host-common:$ktorVersion")
                implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
                implementation("io.ktor:ktor-server-webjars:$ktorVersion")
                implementation("org.webjars:jquery:3.5.0")
                implementation("io.ktor:ktor-server-caching-headers:$ktorVersion")
                implementation("io.ktor:ktor-server-cors:$ktorVersion")
                implementation("io.ktor:ktor-server-http-redirect:$ktorVersion")
                implementation("io.ktor:ktor-server-openapi:$ktorVersion")
                implementation("com.ucasoft.ktor:ktor-simple-cache:0.53.4")
                implementation("com.ucasoft.ktor:ktor-simple-memory-cache:0.53.4")
                implementation("io.ktor:ktor-server-swagger:$ktorVersion")
                implementation("com.ucasoft.ktor:ktor-simple-redis-cache:0.53.4")
                implementation("io.ktor:ktor-server-call-logging:$ktorVersion")
                implementation("io.ktor:ktor-server-thymeleaf:$ktorVersion")
                implementation("io.ktor:ktor-server-websockets:$ktorVersion")
                implementation("io.insert-koin:koin-ktor:$koinVersion")
                implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
                implementation("io.github.flaxoos:ktor-server-rate-limiting:2.1.2")
                implementation("io.github.flaxoos:ktor-server-task-scheduling-core:2.1.2")
                implementation("io.github.flaxoos:ktor-server-task-scheduling-redis:2.1.2")
                implementation("io.github.flaxoos:ktor-server-task-scheduling-mongodb:2.1.2")
                implementation("io.github.flaxoos:ktor-server-task-scheduling-jdbc:2.1.2")
                implementation("io.ktor:ktor-server-freemarker:$ktorVersion")
                implementation("io.ktor:ktor-server-call-id:$ktorVersion")
                implementation("io.ktor:ktor-server-netty:$ktorVersion")
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
                implementation("io.ktor:ktor-server-config-yaml:$ktorVersion")
                implementation("org.mindrot:jbcrypt:$bcryptVersion")
                implementation("io.ktor:ktor-server-compression:$ktorVersion")
                implementation("org.postgresql:postgresql:$pgsqlVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-html:0.12.0")

            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(npm("marked", "^0.6.3"))
                implementation("io.kvision:kvision:$kvisionVersion")
                implementation("io.kvision:kvision-bootstrap:$kvisionVersion")
                implementation("io.kvision:kvision-datetime:$kvisionVersion")
                implementation("io.kvision:kvision-richtext:$kvisionVersion")
                implementation("io.kvision:kvision-tom-select:$kvisionVersion")
                implementation("io.kvision:kvision-imask:$kvisionVersion")
                implementation("io.kvision:kvision-toastify:$kvisionVersion")
                implementation("io.kvision:kvision-fontawesome:$kvisionVersion")
                implementation("io.kvision:kvision-bootstrap-icons:$kvisionVersion")
                implementation("io.kvision:kvision-i18n:$kvisionVersion")
                implementation("io.kvision:kvision-pace:$kvisionVersion")
                implementation("io.kvision:kvision-print:$kvisionVersion")
                implementation("io.kvision:kvision-handlebars:$kvisionVersion")
                implementation("io.kvision:kvision-chart:$kvisionVersion")
                implementation("io.kvision:kvision-tabulator:$kvisionVersion")
                implementation("io.kvision:kvision-maps:$kvisionVersion")
                implementation("io.kvision:kvision-rest:$kvisionVersion")
                implementation("io.kvision:kvision-jquery:$kvisionVersion")
                implementation("io.kvision:kvision-routing-navigo-ng:$kvisionVersion")
                implementation("io.kvision:kvision-state:$kvisionVersion")
                implementation("io.kvision:kvision-redux-kotlin:$kvisionVersion")
                implementation("io.kvision:kvision-select-remote:$kvisionVersion")
                implementation("io.kvision:kvision-tom-select-remote:$kvisionVersion")
                implementation("io.kvision:kvision-tabulator-remote:$kvisionVersion")
                implementation("io.kvision:kvision-onsenui:$kvisionVersion")
                implementation("io.insert-koin:koin-core:$koinVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
                implementation("io.kvision:kvision-testutils:$kvisionVersion")
            }
        }
    }
}

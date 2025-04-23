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
val flaxoosVersion: String by project
val kvisionTailwindCssVersion: String by project
val ballastVersion: String by project

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
				devServer = devServer?.copy(
					port = 8080,
					open = true,
				)
				configDirectory = file("webpack.config.d")
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
//                implementation("io.kvision:kvision-common-remote:$kvisionVersion")
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
//                implementation("io.ktor:ktor-client-core:$ktorVersion")
//                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
//                implementation("io.ktor:ktor-client-auth:$ktorVersion")
//                implementation("io.insert-koin:koin-core:$koinVersion")
//                implementation("io.arrow-kt:arrow-core:2.0.1")
//                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
//                implementation("io.ktor:ktor-client-core:3.1.2")
//                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
//                implementation("io.ktor:ktor-client-auth:$ktorVersion")
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
				implementation("io.ktor:ktor-server-html-builder:$ktorVersion")
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
				implementation("io.github.flaxoos:ktor-server-rate-limiting:$flaxoosVersion")
				implementation("io.github.flaxoos:ktor-server-task-scheduling-core:$flaxoosVersion")
				implementation("io.github.flaxoos:ktor-server-task-scheduling-redis:$flaxoosVersion")
				implementation("io.github.flaxoos:ktor-server-task-scheduling-mongodb:$flaxoosVersion")
				implementation("io.github.flaxoos:ktor-server-task-scheduling-jdbc:$flaxoosVersion")
				implementation("io.ktor:ktor-server-freemarker:$ktorVersion")
				implementation("io.ktor:ktor-server-call-id:$ktorVersion")
				implementation("io.ktor:ktor-server-netty:$ktorVersion")
				implementation("ch.qos.logback:logback-classic:$logbackVersion")
				implementation("io.ktor:ktor-server-config-yaml:$ktorVersion")
				implementation("org.mindrot:jbcrypt:$bcryptVersion")
				implementation("io.ktor:ktor-server-compression:$ktorVersion")
				implementation("org.postgresql:postgresql:$pgsqlVersion")
				implementation("org.jetbrains.kotlinx:kotlinx-html:0.12.0")
				implementation("com.auth0:auth0:2.19.0")
				implementation("com.auth0:java-jwt:4.5.0")
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
				implementation("io.kvision:kvision-material-js:${kvisionVersion}")
				implementation("io.kvision:kvision-tabulator:$kvisionVersion")
				implementation("io.kvision:kvision-maps:$kvisionVersion")
				implementation("io.kvision:kvision-rest:$kvisionVersion")
				implementation("io.kvision:kvision-jquery:$kvisionVersion")
				implementation("io.kvision:kvision-state:$kvisionVersion")
				implementation("io.kvision:kvision-state-flow:$kvisionVersion")
				implementation("io.kvision:kvision-ballast:$kvisionVersion")
				implementation("io.kvision:kvision-routing-ballast-js:$kvisionVersion")
				implementation("io.kvision:kvision-ballast-js:$kvisionVersion")
				implementation("io.kvision:kvision-routing-ballast:$kvisionVersion")
				implementation("io.kvision:kvision-redux-kotlin:$kvisionVersion")
				implementation("io.kvision:kvision-select-remote:$kvisionVersion")
				implementation("io.kvision:kvision-tom-select-remote:$kvisionVersion")
				implementation("io.kvision:kvision-tabulator-remote:$kvisionVersion")
				implementation("io.kvision:kvision-onsenui:$kvisionVersion")
				implementation("io.insert-koin:koin-core:${koinVersion}")
				implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${coroutinesVersion}")
				implementation("io.ktor:ktor-client-js:${ktorVersion}")
				implementation("io.ktor:ktor-client-content-negotiation:${ktorVersion}")
				implementation("io.kvision:kvision-bootstrap-css:5.18.2")
				implementation("io.kvision:snabbdom-kotlin:1.0.0")
//				implementation("io.github.copper-leaf:ballast-core:$ballastVersion")
//              implementation("io.github.copper-leaf:ballast-navigation:$ballastVersion")
//              implementation("io.kvision:kvision-tailwindcss:$kvisionTailwindCssVersion")
//              implementation("io.kvision:kvision-tailwindcss-js:$kvisionTailwindCssVersion")
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

//afterEvaluate {
//    tasks {
//        create("frontendArchive", Jar::class).apply {
//            dependsOn("frontendBrowserProductionWebpack")
//            group = "package"
//            archiveAppendix.set("frontend")
//            val distribution =
//                project.tasks.getByName("frontendBrowserProductionWebpack", KotlinWebpack::class).destinationDirectory
//            from(distribution) {
//                include("*.*")
//            }
//            from(webDir)
//            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//            into("/assets")
//            inputs.files(distribution, webDir)
//            outputs.file(archiveFile)
//            manifest {
//                attributes(
//                    mapOf(
//                        "Implementation-Title" to rootProject.name,
//                        "Implementation-Group" to rootProject.group,
//                        "Implementation-Version" to rootProject.version,
//                        "Timestamp" to System.currentTimeMillis()
//                    )
//                )
//            }
//        }
//        getByName("backendProcessResources", Copy::class) {
//            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//        }
//        getByName("backendJar").group = "package"
//        create("jar", Jar::class).apply {
//            dependsOn("frontendArchive", "backendJar")
//            group = "package"
//            manifest {
//                attributes(
//                    mapOf(
//                        "Implementation-Title" to rootProject.name,
//                        "Implementation-Group" to rootProject.group,
//                        "Implementation-Version" to rootProject.version,
//                        "Timestamp" to System.currentTimeMillis(),
//                        "Main-Class" to mainClassName
//                    )
//                )
//            }
//            val dependencies = configurations["backendRuntimeClasspath"].filter { it.name.endsWith(".jar") } +
//                    project.tasks["backendJar"].outputs.files +
//                    project.tasks["frontendArchive"].outputs.files
//            dependencies.forEach {
//                if (it.isDirectory) from(it) else from(zipTree(it))
//            }
//            exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
//            inputs.files(dependencies)
//            outputs.file(archiveFile)
//            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//        }
//        create("backendRun", JavaExec::class) {
//            dependsOn("compileKotlinBackend")
//            group = "run"
//            mainClass.set(mainClassName)
//            classpath =
//                configurations["backendRuntimeClasspath"] + project.tasks["compileKotlinBackend"].outputs.files +
//                        project.tasks["backendProcessResources"].outputs.files
//            workingDir = buildDir
//        }
//    }
//}
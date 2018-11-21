plugins {
    application
    kotlin("jvm") version "1.3.0"
}

application {
    mainClassName = "server.ServerKt"
}

dependencies {
    compile(kotlin("stdlib"))

    compile("io.ktor:ktor-server-core:1.0.0")
    compile("io.ktor:ktor-server-netty:1.0.0")
    compile("io.ktor:ktor-gson:1.0.0")
}

repositories {
    mavenCentral()
    jcenter()
}


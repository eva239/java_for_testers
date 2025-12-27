plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val agent by configurations.creating {
    isCanBeResolved = true
    isCanBeConsumed = false
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.37.0")
    testImplementation("junit:junit:4.13.1")
    implementation("org.jcommander:jcommander:3.0")
    implementation("tools.jackson.core:jackson-databind:3.0.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.0")
    implementation("com.mysql:mysql-connector-j:9.5.0")
    implementation("org.hibernate.orm:hibernate-core:6.6.37.Final")

    agent("org.aspectj:aspectjweaver:1.9.22")

    testImplementation(platform("io.qameta.allure:allure-bom:2.29.0"))
    testImplementation("io.qameta.allure:allure-junit5")
}

tasks.test {
    useJUnitPlatform()

    if (project.hasProperty("browser")) {
        systemProperty("browser", project.property("browser"))
    }

    jvmArgs = listOf("-javaagent:${project.configurations["agent"].singleFile.absolutePath}")
}
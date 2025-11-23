plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.37.0")
    testImplementation("junit:junit:4.13.1")
    implementation("org.jcommander:jcommander:3.0")
    implementation("tools.jackson.core:jackson-databind:3.0.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:3.0.0")
}

tasks.test {
    useJUnitPlatform()
    if (project.hasProperty("browser")) {
        systemProperty("browser", project.property("browser"))
    }
}


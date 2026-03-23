plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.12"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.phiilani"
version = "0.0.1-SNAPSHOT"
description = "LearningApp"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.session:spring-session-data-mongodb")

    // Jakarta Validation API
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")

    // Hibernate Validator implementation (optional but needed to actually validate)
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")

    // If using Jakarta Expression Language (EL) for some constraints
    implementation("org.glassfish:jakarta.el:4.0.2")

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

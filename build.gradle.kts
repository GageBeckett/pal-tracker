import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.flywaydb.gradle.task.FlywayMigrateTask

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.flywaydb.flyway") version "7.3.0"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
}

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
val testDbUrl = "jdbc:mysql://localhost:3306/tracker_test?user=tracker&useSSL=false&useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false"
tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
    environment("WELCOME_MESSAGE", "Hello from test")
    environment("SPRING_DATASOURCE_URL", testDbUrl)
}

val developmentDbUrl = "jdbc:mysql://localhost:3306/tracker_dev?user=tracker&useSSL=false&useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false"

tasks {
    "bootRun"(JavaExec::class) {
        environment("WELCOME_MESSAGE", "howdy")
        environment("SPRING_DATASOURCE_URL","developmentDbUrl")
    }
}

flyway {
    url = testDbUrl
    user = "tracker"
    password = ""
    locations = arrayOf("filesystem:databases/tracker/migrations")
}


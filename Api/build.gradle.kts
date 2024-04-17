tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    runtimeOnly(project(":infra:mysql-db"))
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}


dependencies {
    implementation("io.quarkus:quarkus-flyway")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    testImplementation("io.rest-assured:rest-assured")
}

tasks.register("prepareKotlinBuildScriptModel") {}

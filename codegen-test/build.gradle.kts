extra["displayName"] = "Smithy :: Codegen :: Test"
extra["moduleName"] = "mx.sugus.codegen.test"

tasks["jar"].enabled = false

val smithyVersion: String by project

buildscript {
    val smithyVersion: String by project

    repositories {
        mavenCentral()
    }
    dependencies {
        "classpath"("software.amazon.smithy:smithy-cli:$smithyVersion")
        "classpath"("software.amazon.smithy:smithy-aws-traits:$smithyVersion")
    }
}

plugins {
    val smithyGradleVersion: String by project

    id("software.amazon.smithy").version(smithyGradleVersion)
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":codegen"))
    implementation("software.amazon.smithy:smithy-waiters:$smithyVersion")
    implementation("software.amazon.smithy:smithy-protocol-test-traits:$smithyVersion")
    implementation("software.amazon.smithy:smithy-aws-traits:$smithyVersion")
}
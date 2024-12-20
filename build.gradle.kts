plugins {
    kotlin("jvm")
    id("io.freefair.lombok")
    id("org.openjfx.javafxplugin")
    application
}

repositories {
    mavenCentral()
}

javafx {
    modules("javafx.controls", "javafx.fxml")
}

dependencies {
    // AssertJ Swing
    testImplementation(libs.assertj.swing.junit)

    // TestFX support
    testImplementation(libs.testfx.core)
    testImplementation(libs.testfx.junit)
    testImplementation(libs.testfx.junit5)
    // Enable TestFX headless mode
    testImplementation(libs.openjfx.monocle)

    // General JUnit 5 support
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)

    // Lombok support
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

tasks.test {
    useJUnitPlatform()
    // Set the TestFX headless property to true
    jvmArgs = listOf(
        "-Dtestfx.robot=glass",
        "-Dtestfx.headless=true",
        "-Dprism.order=sw",
        "-Dprism.text=t2k"
    )
}

tasks.withType<JavaCompile> {
    options.annotationProcessorPath = configurations.annotationProcessor.get()
}

application {
    mainClass.set("com.joevno.javafx.SimpleJavaFxUI")
}
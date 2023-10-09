import dependencies.addTimberDependencies

plugins {
    plugins.`android-core-library`
}
android {
    namespace = "com.siva.di"
}
dependencies {
    addTimberDependencies(configurationName = "api")
}

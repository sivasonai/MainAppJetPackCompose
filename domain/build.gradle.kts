import dependencies.addEntityModule

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.siva.domain"
}

dependencies {
    addEntityModule(configurationName = "api")
}
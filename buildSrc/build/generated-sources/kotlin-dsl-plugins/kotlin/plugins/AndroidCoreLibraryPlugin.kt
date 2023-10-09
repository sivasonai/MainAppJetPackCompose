package plugins


/**
 * Precompiled [android-core-library.gradle.kts][plugins.Android_core_library_gradle] script plugin.
 *
 * @see plugins.Android_core_library_gradle
 */
class AndroidCoreLibraryPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("plugins.Android_core_library_gradle")
                .getDeclaredConstructor(
                    org.gradle.api.Project::class.java,
                    org.gradle.api.Project::class.java
                )
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}

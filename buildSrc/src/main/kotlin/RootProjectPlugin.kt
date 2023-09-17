import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

class RootProjectPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.create<WorkplacesExtension>("workplaces")
    }

}

open class WorkplacesExtension @Inject constructor(objects: ObjectFactory) {
    val minSdk: Property<Int> = objects.property()
    val targetSdk: Property<Int> = objects.property()
    val compileSdk: Property<Int> = objects.property()

    init {
        compileSdk.convention(targetSdk)
    }
}
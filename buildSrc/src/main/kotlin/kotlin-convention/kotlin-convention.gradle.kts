import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    (this as ExtensionAware).configure<KotlinJvmOptions> {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

fun android(configure: BaseExtension.() -> Unit): Unit =
    extensions.configure("android", configure)
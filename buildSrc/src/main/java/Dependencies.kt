object Versions {
    /** Kotlin */
    const val kotlin = "1.3.61"

    /** Android versions */
    const val compile_sdk_version = 28
    const val min_sdk_version = 23
    const val target_sdk_version = 28
    const val android_gradle_plugin = "3.5.3"

    /** AndroidX */
    const val androidx = "1.0.2"
    const val constraint_layout = "1.1.3"
    const val activity = "1.1.0"
    const val fragment = "1.2.1"
    const val lifecycle = "2.2.0"

    /** Unit tests */
    const val junit = "4.12"

    /** Instrumentation tests */
    const val androidx_junit = "1.1.1"
    const val androidx_espresso = "3.2.0"

    /** RxJava2 */
    const val rxJava2 = "2.2.10"
    const val rxJava2Android = "2.1.1"
    const val rxBinding = "2.1.1"

    /** Dagger */
    const val dagger = "2.26"

    /** Retrofit && Gson */
    const val retrofit = "2.7.1"
    const val gson = "2.8.6"
}

object Dependencies {
    /** Project dependencies */
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    /** App dependencies */
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    const val androidx_core_ktx = "androidx.core:core-ktx:${Versions.androidx}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    /** Unit tests dependencies */
    const val junit = "junit:junit:${Versions.junit}"

    /** Instrumentation tests dependencies */
    const val androidx_junit = "androidx.test.ext:junit:${Versions.androidx_junit}"
    const val androidx_espresso = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"

    /** RxJava2 */
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava2}"
    const val rxJava2Android = "io.reactivex.rxjava2:rxandroid:${Versions.rxJava2Android}"
    const val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Versions.rxBinding}"

    /** Dagger */
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    /** Retrofit && Gson */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val rxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}
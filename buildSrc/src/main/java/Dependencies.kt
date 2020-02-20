object Versions {
    /** Kotlin */
    const val kotlin = "1.3.61"

    /** Android versions */
    const val compileSdkVersion = 28
    const val minSdkVersion = 23
    const val targetSdkVersion = 28
    const val androidGradlePlugin = "3.5.3"

    /** AndroidX */
    const val androidx = "1.0.2"
    const val constraintLayout = "1.1.3"
    const val activity = "1.1.0"
    const val fragment = "1.2.1"
    const val lifecycle = "2.2.0"
    const val material = "1.1.0"

    /** Unit tests */
    const val junit = "4.12"
    const val mockito = "2.2.0"

    /** Instrumentation tests */
    const val androidxJunit = "1.1.1"
    const val androidxEspresso = "3.2.0"

    /** RxJava2 */
    const val rxJava2 = "2.2.10"
    const val rxJava2Android = "2.1.1"
    const val rxBinding = "2.1.1"

    /** Dagger */
    const val dagger = "2.26"

    /** Retrofit, OkHttp && Gson */
    const val retrofit = "2.7.1"
    const val gson = "2.8.6"
    const val okHttp = "4.3.1"

    /** Glide */
    const val glide = "4.11.0"
}

object Dependencies {
    /** Project dependencies */
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    /** App dependencies */
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.androidx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"

    /** Unit tests dependencies */
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"

    /** Instrumentation tests dependencies */
    const val androidxEspresso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"

    /** RxJava2 */
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava2}"
    const val rxJava2Android = "io.reactivex.rxjava2:rxandroid:${Versions.rxJava2Android}"
    const val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Versions.rxBinding}"

    /** Dagger */
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    /** Retrofit, OkHttp && Gson */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val rxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    /** Glide */

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}
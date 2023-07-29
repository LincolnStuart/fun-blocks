object AndroidBuild{
    private const val nameSpaceBase = "me.lincolnstuart.funblocks."
    const val minSdk = 24
    const val compileSdk = 34
    const val buildToolsVersion = "34.0.0"
    const val packagesResourcesExcludes = "/META-INF/{AL2.0,LGPL2.1}"
    const val jvmTarget = "11"
    const val versionCode = 1
    const val versionName = "0.0.1"
    fun nameSpace(moduleName: String) = "$nameSpaceBase$moduleName"
}
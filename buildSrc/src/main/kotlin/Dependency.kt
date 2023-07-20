object AndroidBuild{
    private const val nameSpaceBase = "me.lincolnstuart.funblocks."
    const val minSdk = 24
    const val compileSdk = 34
    const val packagesResourcesExcludes = "/META-INF/{AL2.0,LGPL2.1}"
    const val jvmTarget = "11"
    fun nameSpace(moduleName: String) = "$nameSpaceBase$moduleName"
}
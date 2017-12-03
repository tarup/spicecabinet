# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/tpel/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-useuniqueclassmembernames
-keepattributes SourceFile,LineNumberTable
-allowaccessmodification

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep GSON stuff
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** { *; }
-dontnote sun.misc.Unsafe
-dontnote com.google.gson.**

# Ignore warnings: Viewpageindicator
-keep class com.viewpagerindicator.**
-dontwarn com.viewpagerindicator.**
-dontnote com.viewpagerindicator.**

# Kotlin stuff
-keep class kotlin.** { *; }
-dontwarn kotlin.**
-dontnote kotlin.**

# Keep these for GSON
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes EnclosingMethod

-dontnote android.net.http.*
-dontnote org.apache.http.**

-keep class fi.tarup.spicecabinet.DTO.** { *; }
-keepclassmembers class * {
    @fi.tarup.spicecabinet.DTO.** *;
}

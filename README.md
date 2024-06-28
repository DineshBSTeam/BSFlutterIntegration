### Check Your SDK integration Credentials with [ClientTesting.apk](https://bitbucket.org/banksaathi/android-native-sdk-integration/src/master/sample/ClientTesting.apk)


# BankSathi SDK Integration to Android Project

This document serves as the integration doc for the BankSathi SDK into Android native application.

## Steps to integrate

1. Get latest banksathi.aar file by contacting Banksathi Team
   or
 Get the **banksathi.aar** file from sample project's [app/libs](https://bitbucket.org/banksaathi/android-native-sdk-integration/src/master/app/libs/) folder

```
Add **banksathi.aar** file in your Project's **app/libs** folder
``` 

2. Open app level build.gradle file and add .aar file:

```
dependencies {
    implementation files('libs/banksathi.aar')
}

``` 

> Also note that if you are importing a .aar file that has dependencies you'll need to include them in your build.gradle, too.


3. Add all required Dependencies of banksathi.aar in **app/build.gradle** and add **Sync** project 

For required dependencies check [build.gradle](https://bitbucket.org/banksaathi/android-native-sdk-integration/src/master/app/build.gradle) or in below mentioned
> if already added anyone please ignore them

```
dependencies {
>   //other than core { ktx/appcompat/material/constraintlayout } required are below with suitable versions -
    
    implementation 'androidx.compose.runtime:runtime-livedata:1.6.7'
    implementation 'androidx.activity:activity-compose:1.9.0'
    implementation 'androidx.compose.foundation:foundation:1.6.7'
    implementation 'androidx.compose.material:material:1.6.7'
    implementation 'io.coil-kt:coil-compose:1.3.2'

    implementation 'com.squareup.retrofit2:converter-scalars:2.1.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
    implementation 'com.google.android.flexbox:flexbox:3.0.0'
    implementation 'com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0'
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01'
    implementation 'com.github.bumptech.glide:glide:4.16.0'

    implementation 'io.coil-kt:coil:0.12.0'
    implementation 'io.coil-kt:coil-svg:0.12.0'
}

```

4. Enable viewBinding in app **build.gradle**

```
   android {

    buildFeatures {
      viewBinding true
    }
   }

```

5. Launch Banksathi in your app by adding below intent code for example on [Button click](https://bitbucket.org/banksaathi/android-native-sdk-integration/src/master/app/src/main/java/com/banksathi/integration/MainActivity.kt)

```  
    binding.banksathiBtn.setOnClickListener { view ->
         val intent = Intent(this, BankSathiLauncher::class.java)
            intent.putExtra(AdvisorInfo.advisorCode, BS_PROVIDED_CODE)    //Required string format
            intent.putExtra(AdvisorInfo.advisorSecret, BS_PROVIDED_SECRET_KEY)   //Required string format
            intent.putExtra(AdvisorInfo.advisorMobile, BS_REGISTERED_MOBILE)     //Required string format
            intent.putExtra(AdvisorInfo.advisorName, YOUR_NAME)
            intent.putExtra(AdvisorInfo.advisorEmail, YOUR_EMAIL)
         startActivity(intent)
   }
```

Get more knowledge by following above [Example Project](https://bitbucket.org/banksaathi/android-native-sdk-integration/src/master/app/)

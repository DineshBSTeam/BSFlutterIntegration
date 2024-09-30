
# BankSathi SDK Integration into Flutter Project

This document serves as the integration doc for the BankSathi SDK into Android native application.

## Steps to integrate

1. Get latest banksathi.aar file by contacting Banksathi Team
   or
 Get the **banksathi.aar** file from sample project's [app/libs](https://github.com/DineshBSTeam/BSFlutterIntegration/tree/master/android/app/libs) folder

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

```
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.20"
    implementation 'androidx.work:work-runtime-ktx:2.8.1'

    implementation 'androidx.core:core-ktx:1.13.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.12.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

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

5. Launch Banksathi in your app by adding below intent code in your mainActivity and use Method channel to call intent method

add in MainActivity

```  
    MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call,
                result ->
            if (call.method == METHOD) {
                val code = "your code" //required
                val mob = "your mobile" //required
                val name = "your name"
                val email = "your email"

                val intent = Intent(this, BankSathiLauncher::class.java)
                intent.putExtra(SdkRequiredInfo.advisorCode, code) // Required
                intent.putExtra(SdkRequiredInfo.advisorMobile, mob) // Required
                intent.putExtra(SdkRequiredInfo.advisorName, name)
                intent.putExtra(SdkRequiredInfo.advisorEmail, email)
                startActivity(intent)

                result.success("json.toString()")
            } else {
                result.notImplemented()
            }
        }
```
6. Call above method from Flutter Side
```
MethodChannel channel = const MethodChannel('banksathi_advisor_sdk');
                  await channel.invokeMethod('sendDataToSDK');
``` 
Get more knowledge by following above [Example Project](https://github.com/DineshBSTeam/BSFlutterIntegration/tree/master)

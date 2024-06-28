package com.advisar.bank_sathi

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.NonNull
import com.banksathi.advisors.BankSathiLauncher
import com.banksathi.advisors.internal.helper.AdvisorInfo
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import java.sql.DriverManager.println

class MainActivity : FlutterFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val CHANNEL = "banksathi_advisor_sdk"
    private val METHOD = "sendDataToSDK"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        //        GeneratedPluginRegistrant.registerWith(flutterEngine)
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call,
                result ->
            if (call.method == METHOD) {

                println("SDK 00000")
                Log.e("7777", "7777")

                val code = "your code" //required
                val mob = "your mobile" //required
                val name = "your name"
                val email = "your email"

                val intent = Intent(this, BankSathiLauncher::class.java)
                intent.putExtra(AdvisorInfo.advisorCode, code) // Required
                intent.putExtra(AdvisorInfo.advisorMobile, mob) // Required
                intent.putExtra(AdvisorInfo.advisorName, name)
                intent.putExtra(AdvisorInfo.advisorEmail, email)
                startActivity(intent)

                result.success("json.toString()")
            } else {
                result.notImplemented()
            }
        }
    }

    override fun createFlutterFragment(): FlutterFragment {
        return super.createFlutterFragment()
    }
}

class BankSathiSdkActivity : FlutterActivity() {}

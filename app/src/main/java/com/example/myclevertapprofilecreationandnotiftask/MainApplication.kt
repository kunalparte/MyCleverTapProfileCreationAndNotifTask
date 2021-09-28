package com.example.myclevertapprofilecreationandnotiftask

import android.app.Application
import com.clevertap.android.sdk.CleverTapAPI
import com.google.firebase.FirebaseApp

class MainApplication : Application() {

    companion object{

        @JvmStatic
        lateinit var cleverTap : CleverTapAPI
    }

    override fun onCreate() {
        super.onCreate()
        CleverTapAPI.setDebugLevel(1)
        cleverTap = CleverTapAPI.getDefaultInstance(applicationContext)!!
        cleverTap.enablePersonalization();
    }
}
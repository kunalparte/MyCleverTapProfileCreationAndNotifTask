package com.example.myclevertapprofilecreationandnotiftask.services

import android.content.ContentValues
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFCMInstanceIdService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.d(ContentValues.TAG, "onCreate: $p0")
    }
}
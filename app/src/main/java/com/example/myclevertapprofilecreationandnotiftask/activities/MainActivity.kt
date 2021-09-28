package com.example.myclevertapprofilecreationandnotiftask.activities

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.myclevertapprofilecreationandnotiftask.MainApplication
import com.example.myclevertapprofilecreationandnotiftask.R
import com.example.myclevertapprofilecreationandnotiftask.model.CleverTapObjectModel
import com.example.myclevertapprofilecreationandnotiftask.model.CleverTapProfileAddUpdate
import com.example.myclevertapprofilecreationandnotiftask.utils.ClevertapConstants
import com.example.myclevertapprofilecreationandnotiftask.utils.Utils
import com.google.firebase.FirebaseApp
import com.google.firebase.installations.FirebaseInstallations
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseInstallations.getInstance().getToken(false).addOnSuccessListener {
            Log.d(ContentValues.TAG, "onCreate: $it")
            clickCTEvent.setOnClickListener {
                if (nameET.text.isNullOrEmpty()){
                    Toast.makeText(this, "Please enter Your Name", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (emailET.text.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailET.text.toString()).matches()){
                    Toast.makeText(this, "Please enter valid Email Address", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                var cleverTapProfileAddUpdate = CleverTapProfileAddUpdate.cleverTapProfile()
                cleverTapProfileAddUpdate.Email = emailET.text.toString()
                cleverTapProfileAddUpdate.Name = nameET.text.toString()
                Utils.pushCleverTapProfile(cleverTapProfileAddUpdate)

                var cleverTapObjectModel = CleverTapObjectModel.cleverTap()
                cleverTapObjectModel.productId = 1
                cleverTapObjectModel.productImage = "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg"
                cleverTapObjectModel.productName = "CleverTap"
                cleverTapObjectModel.email = emailET.text.toString()
                Utils.pushCleverTap(ClevertapConstants.PRODUCT_VIEWED_EVENT, cleverTapObjectModel, this)
            }
        }
    }
}
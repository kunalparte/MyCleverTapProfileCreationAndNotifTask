package com.example.myclevertapprofilecreationandnotiftask.utils

import android.content.Context
import com.example.myclevertapprofilecreationandnotiftask.MainApplication
import com.example.myclevertapprofilecreationandnotiftask.model.CleverTapObjectModel
import com.example.myclevertapprofilecreationandnotiftask.model.CleverTapProfileAddUpdate

object Utils {

    @JvmStatic
    fun pushCleverTap(eventName: String, model: CleverTapObjectModel, context: Context) {
            val cleverTapEventFields = HashMap<String, Any>()
            model.let {
                var fields = model.javaClass.declaredFields
                for (i in fields.indices) {
                    fields[i]?.let {
                        it.isAccessible = true
                        var value = it.get(model)
                        cleverTapEventFields.put(it.name, value)
                    }
                }
            }
            MainApplication.cleverTap.pushEvent(eventName, cleverTapEventFields)
    }


    @JvmStatic
    fun pushCleverTapProfile( model: CleverTapProfileAddUpdate) {
            val cleverTapEventFields = hashMapOf<String, Any>()
            model.let {
                var fields = model.javaClass.declaredFields
                for (i in fields.indices) {
                    fields[i]?.let {
                        it.isAccessible = true
                        var value = it.get(model)
                        cleverTapEventFields.put(it.name, value)
                    }
                }
            }
        MainApplication.cleverTap.onUserLogin(cleverTapEventFields)



    }
}
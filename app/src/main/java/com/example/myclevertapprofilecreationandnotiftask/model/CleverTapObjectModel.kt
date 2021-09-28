package com.example.myclevertapprofilecreationandnotiftask.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CleverTapObjectModel(

    var productId : Int ?= null,
    var productName : String ?= null,
    var productImage : String ?= null,
    var email : String ?= null
): Parcelable {

    companion object{
        fun cleverTap() : CleverTapObjectModel{
            return CleverTapObjectModel()
        }
    }
}


@Parcelize
data class CleverTapProfileAddUpdate(
    var Name : String ?= null,
    var Email : String ?= null,
    var Phone : String ?= null,
    var Identity : String ?= null,
    var City : String ?= null,
    var Locality : String ?= null,
    var Gender : String ?= null
) : Parcelable {

    companion object{
        fun cleverTapProfile() : CleverTapProfileAddUpdate{
            return CleverTapProfileAddUpdate()
        }
    }
}

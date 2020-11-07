package com.example.simplesocial.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimpleSocialUser(
    var fName : String,
    var lName : String,
    var username : String,
    var password: String,
    var email: String,
    var birthday: String) :Parcelable{

    constructor() : this(
        "John",
        "Doe",
        "JDoe",
        "Jdoe123",
        "Jdoe321@online.com",
        ""
    )
}
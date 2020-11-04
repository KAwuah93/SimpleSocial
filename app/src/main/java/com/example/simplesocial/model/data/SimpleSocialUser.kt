package com.example.simplesocial.model.data

import java.io.Serializable

data class SimpleSocialUser(
    var fName : String,
    var lName : String,
    var username : String,
    var password: String,
    var email: String,
    var birthday: String) :Serializable{

    constructor() : this(
        "John",
        "Doe",
        "JDoe",
        "Jdoe123",
        "Jdoe321@online.com",
        ""
    )
}
package com.example.simplesocial.model.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "simpleSocialUser_table")
data class SimpleSocialUser(
    @ColumnInfo(name = "fName") var fName : String,
    @ColumnInfo(name = "lName")var lName : String,
    @PrimaryKey @ColumnInfo(name = "username") var username : String,
    @ColumnInfo(name = "password")var password: String,
    @ColumnInfo(name = "email")var email: String,
    @ColumnInfo(name = "birthday")var birthday: String)
    :Parcelable{
    constructor() : this(
        "John",
        "Doe",
        "JDoe",
        "Jdoe123",
        "Jdoe321@online.com",
        ""
    )
}
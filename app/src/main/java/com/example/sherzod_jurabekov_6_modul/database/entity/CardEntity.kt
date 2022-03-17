package com.example.sherzod_jurabekov_6_modul.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardEntity (
    @PrimaryKey (autoGenerate = true)
    var id:Int,
    var name:String? = null,
    var cvv:String? = null,
    var day:String? = null,
    var month:String? = null,
    var cardnumber:String? = null
)
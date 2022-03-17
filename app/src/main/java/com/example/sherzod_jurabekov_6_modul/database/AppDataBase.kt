package com.example.sherzod_jurabekov_6_modul.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sherzod_jurabekov_6_modul.database.dao.CardDao
import com.example.sherzod_jurabekov_6_modul.database.entity.CardEntity


@Database(entities =[CardEntity::class],version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cardDao(): CardDao
    companion object{
        private var instance : AppDatabase? = null
        @Synchronized

        fun getInstance(context: Context):AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context,
                    AppDatabase::class.java,"card.db")
                    .fallbackToDestructiveMigration()//versiya yangilaganimzda shu function o`zi yangilab ketaveradi versiyanii
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}
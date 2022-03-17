package com.example.sherzod_jurabekov_6_modul.database.dao

import androidx.room.*
import com.example.sherzod_jurabekov_6_modul.database.entity.CardEntity

@Dao
interface CardDao {
    @Insert //databasega malumot kiritiw ekan
    fun createCard(card: CardEntity)

    @Query("SELECT * FROM cards")
    fun getCards(): List<CardEntity>
//
//    @Query("SELECT * FROM cards")
//    fun getPosts(): List<CardEntity>
//
//    @Query("SELECT * FROM cards WHERE id=:id")
//    fun getPostById(id:Int):CardEntity
//
//    @Delete
//    fun deletePostWithDelete(post: CardEntity)
//
//    @Query("DELETE FROM cards WHERE id=:id")
//    fun deletePost(id: Int)
//
//    @Update
//    fun updatePostWithUpdate(post: CardEntity)

}
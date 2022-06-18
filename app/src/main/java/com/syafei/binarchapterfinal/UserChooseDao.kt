package com.syafei.binarchapterfinal

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE


@Dao
interface UserChooseDao {

    @Query("SELECT * from User")
    fun getAllUser(): List<User>

    @Insert(onConflict = REPLACE)
    fun addUser(user: User): Long

    @Update
    fun updateUser(user: User): Int

    @Delete
    fun deleteUser(user: User): Int

}
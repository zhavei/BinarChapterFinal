package com.syafei.binarchapterfinal

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE


@Dao
interface UserChooseDao {

    @Query("SELECT * from UserChoose")
    fun getAllUser(): List<UserChoose>

    @Insert(onConflict = REPLACE)
    fun addUser(userChoose: UserChoose): Long

    @Update
    fun updateUser(userChoose: UserChoose): Int

    @Delete
    fun deleteUser(userChoose: UserChoose): Int

}
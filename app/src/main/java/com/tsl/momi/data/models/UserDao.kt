package com.tsl.momi.data.models

import androidx.room.Dao
import androidx.room.Query
import com.tsl.momi.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * from user_table ORDER BY last_name ASC")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun getUserById(id: Int): Maybe<User>

    @Query("SELECT * FROM user_table LIMIT 1")
    fun getRandom(): Single<User>

    @Query("DELETE FROM user_table")
    fun deleteAll()
}
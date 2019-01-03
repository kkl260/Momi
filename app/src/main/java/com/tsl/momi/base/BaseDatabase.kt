package com.tsl.momi.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tsl.momi.data.models.User
import com.tsl.momi.data.models.UserDao
import com.tsl.momi.utils.Converters

@Database(entities = arrayOf(User::class), version = 2)
@TypeConverters(Converters::class)
abstract class BaseDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
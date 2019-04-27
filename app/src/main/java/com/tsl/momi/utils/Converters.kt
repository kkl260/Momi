package com.tsl.momi.utils

import androidx.room.TypeConverter
import java.util.*
import com.google.gson.Gson

class Converters {
    val gson = Gson()

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
package com.tsl.momi.utils

import androidx.room.TypeConverter
import com.tsl.momi.data.models.Avatar
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

    @TypeConverter
    fun jsonToAvatar(json: String?): Avatar? {
        return gson.fromJson(json, Avatar::class.java)
    }

    @TypeConverter
    fun avatarToJson(avatar: Avatar?): String? {
        return gson.toJson(avatar)
    }
}
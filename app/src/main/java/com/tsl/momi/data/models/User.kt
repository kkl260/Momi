package com.tsl.momi.data.models

import androidx.room.*
import com.tsl.momi.utils.Converters

/**
 * A basic class representing an entity that is a row in a one-column database table.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 * See the documentation for the full rich set of annotations.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "user_table")
data class User(@PrimaryKey var id: Int, var email: String?, var first_name: String, var last_name: String,
                @TypeConverters(Converters::class) var avatar: Avatar) {}
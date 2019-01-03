package com.tsl.momi.data.models.campaign

import org.threeten.bp.Duration

data class Video(
    val id: Int,
    val user: Int,
    val video_file: String,
    val video_filename: String,
    val duration: Long,
    val thumbnail: Thumbnail,
    val width: Int,
    val height: Int
){
    fun getDuration(): String{
        val dur = Duration.ofSeconds(duration)
        val minutes = dur.toMinutes()
        val seconds = dur.minusMinutes(minutes).seconds
        val s = StringBuilder()
        s.append("Length: ")
        if (minutes != 0L){
            s.append(String.format("%02d", minutes))
            s.append(" min ")
        }
        s.append(String.format("%02d", seconds))
        s.append(" sec")
        return s.toString()
    }

    fun getDurationByMilis(): Long {
        return Duration.ofSeconds(duration + 1).toMillis()
    }
}
package com.tsl.momi.data.models.campaign

data class Campaign(
    val id: Int,
    val user: Int,
    val title: String,
    val candidate: String,
    val office: String,
    val party: String,
    val from_date: String,
    val to_date: String,
    val created: String,
    val modified: String,
    val timezone: String
)


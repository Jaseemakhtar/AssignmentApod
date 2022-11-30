package com.jaseem.apod.domain

data class Cosmos(
    val id: Int,
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val title: String,
    val url: String
)

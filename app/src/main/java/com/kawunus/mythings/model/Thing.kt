package com.kawunus.mythings.model


data class Thing(
    val id: String,
    val name:String,
    val description: String?,
    val image: ByteArray
)

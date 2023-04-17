package com.example.servertest

import kotlinx.serialization.Serializable

@Serializable
class Student(
    val firstname: String,
    val lastname: String,
    val group: String
)

@Serializable
class Item<E>(val student: E, val id: String)
package com.example.myclass

data class Student(
    val name: String = "",
    val id: String = "",
    val gpa: Double = 0.0,
    val credits: Int = 0,
    val semester: Int = 0,
    val about: String = "",
    val profileImageId: Int = R.drawable.img_profile_placeholder
)

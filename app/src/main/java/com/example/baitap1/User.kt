package com.example.baitap1

class User(
    val name: String,
    val email: String,
    val phone: String,
    val gender: String
) {
    override fun toString(): String {
        return "Tên: $name\nEmail: $email\nSố điện thoại: $phone\nGiới tính: $gender"
    }
}
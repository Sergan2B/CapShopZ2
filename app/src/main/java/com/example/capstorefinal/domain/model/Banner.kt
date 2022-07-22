package com.example.capstorefinal.domain.model

data class Banner(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)

data class Result(
    val baner: String,
    val baner_title: String,
    val id: Int
)
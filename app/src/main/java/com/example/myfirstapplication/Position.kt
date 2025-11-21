package com.example.myfirstapplication

data class Position(
    val tradingsymbol: String,
    val exchange: String,
    val instrument_token: Long,
    val product: String,
    val quantity: Int,
    val average_price: Double,
    val last_price: Double,
    val pnl: Double
)
package com.example.myfirstapplication

data class PositionsResponse(val data: PositionsData)

data class PositionsData(val net: List<Position>)
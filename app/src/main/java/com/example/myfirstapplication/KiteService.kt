package com.example.myfirstapplication

import retrofit2.http.GET
import retrofit2.http.Header

interface KiteService {
    @GET("/portfolio/positions")
    suspend fun getPositions(
        @Header("X-Kite-Version") apiVersion: String = "3",
        @Header("Authorization") authorization: String,
    ): PositionsResponse
}
package com.rajrishav.gemini.data

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatData {
    val apiKey = "AIzaSyCaeNWg65ovbQ6oL-HcE2xYAHP8UWq7fHw"

    suspend fun getResponse(promt: String): Chat {
        val gerenativeModel = GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apiKey,
        )

        try {
            val response = withContext(Dispatchers.IO){
                gerenativeModel.generateContent(promt)
            }

            return Chat(
                promt = response.text?: "error",
                bitmap = null,
                isFromUser = false
            )
        } catch (e: Exception) {
            return Chat(
                promt = e.message?: "Error",
                bitmap = null,
                isFromUser = false
            )
        }
    }


    suspend fun getResponseWithImage(promt: String, bitmap: Bitmap): Chat {
        val gerenativeModel = GenerativeModel(
            modelName = "gemini-pro-vision",
            apiKey = apiKey,
        )

        try {

            val inputContent = content {
                image(bitmap)
                text(promt)
            }
            val response = withContext(Dispatchers.IO){
                gerenativeModel.generateContent(inputContent)
            }

            return Chat(
                promt = response.text?: "error",
                bitmap = null,
                isFromUser = false
            )
        } catch (e: Exception) {
            return Chat(
                promt = e.message?: "Error",
                bitmap = null,
                isFromUser = false
            )
        }
    }
}
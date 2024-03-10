package com.rajrishav.gemini.presentation

import android.graphics.Bitmap
import com.rajrishav.gemini.data.Chat

data class ChatState (
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)
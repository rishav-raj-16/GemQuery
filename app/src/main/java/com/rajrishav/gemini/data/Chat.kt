package com.rajrishav.gemini.data

import android.graphics.Bitmap

data class Chat(
    val promt: String,
    val bitmap: Bitmap?,
    val isFromUser: Boolean
)

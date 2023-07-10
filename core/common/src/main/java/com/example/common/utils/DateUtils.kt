package com.example.common.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun formatDate(dateString: String): String {
        val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

        val date: Date = inputFormatter.parse(dateString) ?: return ""

        return outputFormatter.format(date)
    }
}
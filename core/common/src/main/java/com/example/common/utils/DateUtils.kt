package com.example.common.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

object DateUtils {
    fun formatDate(dateString: String): String {
        val inputFormats = arrayOf(
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'", Locale.getDefault()),
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        )
        val outputFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

        for (inputFormatter in inputFormats) {
            try {
                val date: Date = inputFormatter.parse(dateString) ?: continue
                return outputFormatter.format(date)
            } catch (e: Exception) {
                // Ignore parsing errors and try the next format
            }
        }

        return ""
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTimeDifference(dateString: String): String {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val date = LocalDateTime.parse(dateString, formatter)
        val instant = date.atZone(ZoneId.systemDefault()).toInstant()
        val now = Instant.now()

        val hours = ChronoUnit.HOURS.between(instant, now)
        return "$hours hours ago"
    }
}
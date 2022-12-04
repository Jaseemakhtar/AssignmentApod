package com.jaseem.apod.domain.usecase

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateFormatParserUseCase {
    private val datePattern = "yyyy-MM-dd"
    private val dateFormat = SimpleDateFormat(datePattern, Locale.getDefault())

    operator fun invoke(date: String?): Date? = try {
        if (date == null) throw Exception("Raw date is null")
        dateFormat.parse(date)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

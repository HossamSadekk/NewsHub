package com.example.model.dto.language

data class LanguageDto(
    val name: String,
    val code: String,
    var isSelected: Boolean = false
)
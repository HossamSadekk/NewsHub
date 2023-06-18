package com.example.model.dto.mapper

import com.example.model.dto.sources.SourceDto
import com.example.model.remote.sources.Source

fun Source.toSourceDto(): SourceDto =
    SourceDto(id = id, name = name)

fun List<Source>.toSourceDtoList(): List<SourceDto> = map { it.toSourceDto() }
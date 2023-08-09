package com.example.common.mvvm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.sources.SourceDto

class SharedViewModel : ViewModel() {
    var article = mutableStateOf<ArticleDto?>(null)
        private set

    var source = mutableStateOf<SourceDto?>(null)
        private set

    fun addArticle(articleDto: ArticleDto) {
        article.value = articleDto
    }

    fun addSource(sourceDto: SourceDto) {
        source.value = sourceDto
    }
}
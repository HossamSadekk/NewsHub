package com.example.common.mvvm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.model.dto.article.ArticleDto

class SharedViewModel: ViewModel() {
    var article =  mutableStateOf<ArticleDto?>(null)
    private set

    fun addArticle(articleDto: ArticleDto){
        article.value = articleDto
    }
}
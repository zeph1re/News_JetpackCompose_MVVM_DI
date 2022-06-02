package binar.ganda.news_jetpackcompose_mvvm_di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.ganda.news_jetpackcompose_mvvm_di.model.GetAllNewsItem
import binar.ganda.news_jetpackcompose_mvvm_di.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel  @Inject constructor(val repo :  NewsRepository) : ViewModel() {

    private val newsState = MutableStateFlow(emptyList<GetAllNewsItem>())

    val dataState : StateFlow<List<GetAllNewsItem>>
    get() = newsState

    init {
        viewModelScope.launch {
            val news = repo.getNews()
            newsState.value = news
        }
    }



}
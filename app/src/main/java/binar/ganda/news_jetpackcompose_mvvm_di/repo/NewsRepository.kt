package binar.ganda.news_jetpackcompose_mvvm_di.repo

import binar.ganda.news_jetpackcompose_mvvm_di.model.GetAllNewsItem
import binar.ganda.news_jetpackcompose_mvvm_di.network.NewsService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val service : NewsService){

    suspend fun getNews() :  List<GetAllNewsItem> {
        return service.getAllNews()
    }



}
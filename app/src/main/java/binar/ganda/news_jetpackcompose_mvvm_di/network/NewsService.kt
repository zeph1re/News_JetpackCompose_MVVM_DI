package binar.ganda.news_jetpackcompose_mvvm_di.network

import binar.ganda.news_jetpackcompose_mvvm_di.model.GetAllNewsItem
import retrofit2.http.GET

interface NewsService {

    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsItem>
}
package binar.ganda.news_jetpackcompose_mvvm_di.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class GetAllNewsItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
) : Serializable
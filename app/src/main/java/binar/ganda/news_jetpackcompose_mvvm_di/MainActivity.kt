package binar.ganda.news_jetpackcompose_mvvm_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.lifecycle.viewmodel.compose.viewModel
import binar.ganda.news_jetpackcompose_mvvm_di.model.GetAllNewsItem
import binar.ganda.news_jetpackcompose_mvvm_di.ui.theme.News_JetpackCompose_MVVM_DITheme
import binar.ganda.news_jetpackcompose_mvvm_di.viewmodel.NewsViewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            News_JetpackCompose_MVVM_DITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsViewModel = viewModel(modelClass = NewsViewModel::class.java)
                    val dataNews by newsViewModel.dataState.collectAsState()

                    LazyColumn(){
                        if (dataNews.isEmpty()){
                            item{
                            }
                        }

                        items(dataNews){
                            NewsCard(news = it)
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun NewsCard(news : GetAllNewsItem) {
    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        val mContext = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val intent = Intent(mContext , DetailActivity::class.java)
                    intent.putExtra("news.id", )
                    mContext.startActivity(intent)
                },
            backgroundColor = Color.LightGray,
            shape = RoundedCornerShape(10.dp)
        ) {
            Row() {
                Image(
                    painter = rememberImagePainter(data = news.image),
                    contentDescription = "img",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(100.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = news.title,
                        modifier = Modifier.padding(bottom = 5.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = news.author,
                        modifier = Modifier.padding(bottom = 5.dp),
                        fontSize = 13.sp,
                    )
                    Text(
                        text = news.createdAt,
                        modifier = Modifier.padding(bottom = 5.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    News_JetpackCompose_MVVM_DITheme {
        NewsCard(GetAllNewsItem("","", "", "", "", ""))
    }
}
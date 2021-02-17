package com.example.gifsproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.gifsproject.ui.theme.GifsProjectTheme
import dev.chrisbanes.accompanist.glide.GlideImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GifsProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Example()
                }
            }
        }
    }
}

private val images = listOf(
    Pair(
        "register",
        "https://firebasestorage.googleapis.com/v0/b/bulder-test-firebase-moneybag-images/o/users%2FXx1iZa3pwpzuyld7gxK1YbkdB7Xu0dRWOySr6gj_rBk%2F61807321-271e-48b2-aca3-d7e7bc31e5a3.gif?alt=media&token=11775a5a-6520-45f0-b49d-0e684c748aa7",
    ),
    Pair(
        "dancing",
        "https://firebasestorage.googleapis.com/v0/b/bulder-test-firebase-moneybag-images/o/users%2FXx1iZa3pwpzuyld7gxK1YbkdB7Xu0dRWOySr6gj_rBk%2Fa0b7b7f6-1f47-499a-8c00-44ca5ce6cb2c.gif?alt=media&token=71729100-02fb-4aa3-a5f0-278677ea08a4",
    ),
    Pair(
        "bills",
        "https://firebasestorage.googleapis.com/v0/b/bulder-test-firebase-moneybag-images/o/users%2FXx1iZa3pwpzuyld7gxK1YbkdB7Xu0dRWOySr6gj_rBk%2Fa995e832-d0de-4228-ad07-698b10d314a5.gif?alt=media&token=f0833cc6-c583-4de1-be57-2ab6462e7487"
    ),
    Pair(
        "aoc",
        "https://firebasestorage.googleapis.com/v0/b/bulder-test-firebase-moneybag-images/o/users%2FXx1iZa3pwpzuyld7gxK1YbkdB7Xu0dRWOySr6gj_rBk%2F494935ed-b680-4df6-b7a6-7b80054e891e.gif?alt=media&token=8eaa1a7c-dfdc-4300-a3b2-e5b9bae09c87"
    )
)

@Composable
fun Example() {
    Log.d("david","meep")
    val megalist = images.toMutableList().let {
        it.addAll(images)
        it.addAll(images)
        it.toList()
    }
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally) {


        items(items = megalist, itemContent = { pair ->
            Box(
                modifier = Modifier
                    .preferredHeight(120.dp)
                    .preferredWidth(350.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = {
                    })
            ) {
                GlideImage(
                    data = pair.second,
                    requestBuilder = {
                        val options = RequestOptions()
                        options.centerCrop()
                        apply(options)
                    },
                    contentDescription = "",
                    fadeIn = true,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
                Text(text=pair.first)


            }


        })
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GifsProjectTheme {
        Greeting("Android")
    }
}
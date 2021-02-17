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
        "moomin",
        "https://static.dw.com/image/47520312_303.jpg"
    ),
    Pair(
        "register",
        "https://media0.giphy.com/media/oZBx7QKbodgqY/giphy.gif",
    ),
    Pair(
        "dancing",
        "https://media2.giphy.com/media/3o7abldj0b3rxrZUxW/giphy.gif?cid=ecf05e47bpa0qyzopsc69qdrbz3z0ymhvf9af6xbswa9dwdk&rid=giphy.gif"
    ),
    Pair(
        "bills",
        "https://media0.giphy.com/media/9rwJNLBu8FMfixoIxL/giphy.gif?cid=ecf05e4736v5h6awppuswequd2otj0hy3fjs7h4agvp2l5s1&rid=giphy.gif"
    ),
    Pair(
        "aoc",
        "https://media1.giphy.com/media/0tcXWuHIX4pQCJIdWB/giphy.gif?cid=ecf05e473jqvc2q0xlo8loqkkswx9twp7ll3pksxqm3x93ja&rid=giphy.gif"
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
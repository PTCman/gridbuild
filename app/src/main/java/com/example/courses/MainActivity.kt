package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource

import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                CourseApp()
            }
        }
    }
}

@Composable
fun CourseApp(){
    val layoutDirection = LocalLayoutDirection.current
    Surface(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(
            start = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateStartPadding(layoutDirection),
            end = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateEndPadding(layoutDirection),
        )
    ) {
        TopicGrid(DataSource.topics, modifier = Modifier.padding(
            start = dimensionResource(R.dimen.padding_small),
            top = dimensionResource(R.dimen.padding_small),
            end = dimensionResource(R.dimen.padding_small)))
    }
}


//@Composable
//fun CourseCardList(topics: List<Topic>, modifier: Modifier = Modifier) {
//    LazyColumn {
//        items(topics.chunked(2)){ topicPair ->
//            Row(modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 4.dp)) {
//                topicPair.forEach(){ topic ->
//                    CourseCard(topic = topic, modifier = Modifier
//                        .weight(1f)
//                        .padding(4.dp))
//                }
//            }
//        }
//    }
//}

@Composable
fun TopicGrid(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(topics) { topic ->
            CourseCard(topic)
        }
    }
}


@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Row {
            Image(painter = painterResource(id = topic.image),
                contentDescription = stringResource(id = topic.title),
                modifier = Modifier
                    .size(68.dp),
                contentScale = ContentScale.Crop)
            Column() {
                Text(text = stringResource(id = topic.title),
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.bodyMedium)
                Row(modifier = Modifier
                    .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null)
                    Text(text = topic.labelNumber.toString(),
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }

}


@Preview
@Composable
fun CoursePreview(){
    CourseCard(Topic(title = R.string.architecture, labelNumber = 321, image = R.drawable.architecture), modifier = Modifier)
}

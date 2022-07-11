package com.example.taskcompletedpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompletedpage.ui.theme.TaskCompletedPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskCompletedPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PageComplete(
                        textBold = stringResource(id = R.string.all_tasks_completed),
                        niceText = stringResource(id = R.string.nice_work)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageCheck() {
    val image = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = image,
        contentDescription = "tasks complete",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TasksComplete(textBold:String) {
    Text(
        text = textBold,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(top = 24.dp, bottom = 8.dp)
            .fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextNice(niceText:String) {
    Text(
        text = niceText,
        fontSize = 16.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun PageComplete(textBold: String, niceText: String) {
    Column(Modifier.fillMaxHeight()) {
        ImageCheck()
        TasksComplete(textBold)
        TextNice(niceText)
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletedPreview() {
    TaskCompletedPageTheme {
        PageComplete(
            textBold = stringResource(id = R.string.all_tasks_completed),
            niceText = stringResource(id = R.string.nice_work)
        )
    }
}
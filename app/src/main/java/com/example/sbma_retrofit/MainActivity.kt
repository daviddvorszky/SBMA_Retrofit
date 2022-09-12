package com.example.sbma_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.sbma_retrofit.ui.theme.SBMA_RetrofitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresidentList()
        }
    }
}

@Composable
fun PresidentList() {
    val presidents = DataProvider.presidents

    val listState = rememberLazyListState()
    var selectedIndex by remember{ mutableStateOf(-1)}

    Column(Modifier.fillMaxSize()) {
        LazyColumn(state = listState){
            items(presidents){ president ->
                Text(
                    text = president.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .selectable(
                            selected = president.id == selectedIndex,
                            onClick = {
                                if (selectedIndex != president.id)
                                    selectedIndex = president.id else selectedIndex = -1
                            }
                        ),
                    color = if(president.id == selectedIndex) Color.Black else Color.DarkGray,
                    fontWeight = if(president.id == selectedIndex) FontWeight.Bold else FontWeight.Normal,

                )
            }
        }
    }
}
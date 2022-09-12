package com.example.sbma_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URL



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

        if(selectedIndex != -1){
            ShowPresidentHits(presidents[selectedIndex])
        }

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

@Composable
fun ShowPresidentHits(president: President, model: MainViewModel = viewModel()) {
    val hits: Int? by model.presidentHits.observeAsState(null)
    model.getHits(president)
    Text(president.name + " hits: " + hits.toString())
}
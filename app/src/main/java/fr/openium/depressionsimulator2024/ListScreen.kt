package fr.openium.depressionsimulator2024

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableStateOf(1)
    }
    val list = remember {
        mutableStateListOf<String>().apply {
            for (it in 1..5) {
                add("Element $it")
                counter = it+1
            }
        }
    }
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            list.add("Element $counter")
            counter++
        }) {
            Icon(imageVector = Icons.Default.Add, null)
        }
    }, modifier = modifier) {
        innerPadding ->
        ListFor(list =list, modifier = Modifier.padding(innerPadding))
    }

}

@Composable
private fun ListFor(list: List<String>, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp), modifier = modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {
        for (l in list) {
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)) {
                Text(l, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            Divider()
        }
    }
}

@Composable
private fun ListLazy(list: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(list) {
            Card {
                Text(it)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewListScreen() {

}
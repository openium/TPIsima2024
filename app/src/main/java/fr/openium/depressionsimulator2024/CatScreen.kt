package fr.openium.depressionsimulator2024

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import fr.openium.depressionsimulator2024.api.Cat

@Composable
fun CatScreen(cats: List<Cat>, modifier: Modifier = Modifier) {
    ImageList(cats, modifier)
}

@Composable
private fun IdList(cats: List<Cat>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(cats) {
            Card {
                Text(it._id)
            }
        }
    }
}

@Composable
private fun ImageList(cats: List<Cat>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(cats) {cat ->
            AsyncImage(
                model = "https://cataas.com/cat/${cat._id}",
                contentDescription = null
            )

        }
    }
}
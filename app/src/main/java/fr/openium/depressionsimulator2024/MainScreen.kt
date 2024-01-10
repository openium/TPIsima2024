package fr.openium.depressionsimulator2024

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.openium.depressionsimulator2024.ui.theme.DepressionSimulator2024Theme

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var texteDansLeChamp by remember {
        mutableStateOf("")
    }
    var texteAAfficher by remember {
        mutableStateOf("")
    }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier) {

        TextField(value = texteDansLeChamp, onValueChange = {
            newValue ->
            Log.d("MainActivity", "text : $newValue")
            texteDansLeChamp = newValue
        })

        Text(text = texteAAfficher)

        Button(onClick = { texteAAfficher = texteDansLeChamp }) {
            Text("Envoyer !")
        }
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    DepressionSimulator2024Theme {
        MainScreen()
    }
}
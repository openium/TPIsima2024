package fr.openium.depressionsimulator2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import fr.openium.depressionsimulator2024.api.CatProvider
import fr.openium.depressionsimulator2024.ui.theme.DepressionSimulator2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val catProvider = CatProvider()
        val cats = catProvider.provideCats()
        setContent {
            DepressionSimulator2024Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MainScreen(Modifier.fillMaxSize().padding(innerPadding))
                    ListScreen(Modifier.fillMaxSize().padding(innerPadding))
//                    CatScreen(
//                        cats,
//                        Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(value: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick) {
        Text(
            text = "J'ai été cliqué $value fois",
            fontSize = TextUnit(36f, TextUnitType.Sp),
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DepressionSimulator2024Theme {
//        Greeting("Android")
    }
}
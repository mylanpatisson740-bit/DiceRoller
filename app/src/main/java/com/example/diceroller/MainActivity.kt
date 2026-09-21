package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))

}


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    Surface(color = Color.DarkGray) {
        var result by remember { mutableStateOf(1) }
        var lance by remember { mutableStateOf(false) }
        val rotation = remember { Animatable(0f) }
        val scope = rememberCoroutineScope()

        val imageRessource = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageRessource),
                contentDescription = result.toString(),
                modifier = Modifier.graphicsLayer { rotationZ = rotation.value }
            )
            Spacer(modifier = Modifier.height(26.dp))
            Button(
                enabled = !lance,
                onClick = {
                    scope.launch {
                        lance = true
                        launch {
                            rotation.animateTo(
                                targetValue = 720f,
                                animationSpec = tween(1000, easing = FastOutSlowInEasing)
                            )
                            rotation.snapTo(0f)
                        }
                        repeat(15) {
                            result = (1..6).random()
                            delay(30)
                        }
                        result = (1..6).random()
                        lance = false
                    }
                }
            ) {
                Text(stringResource(R.string.roll))
            }
        }
    }
}
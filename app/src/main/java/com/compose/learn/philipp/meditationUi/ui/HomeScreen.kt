package com.compose.learn.philipp.meditationUi.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.learn.R
import com.compose.learn.philipp.meditationUi.ui.theme.ButtonBlue
import com.compose.learn.philipp.meditationUi.ui.theme.DarkerButtonBlue
import com.compose.learn.philipp.meditationUi.ui.theme.DeepBlue
import com.compose.learn.philipp.meditationUi.ui.theme.LightRed
import com.compose.learn.philipp.meditationUi.ui.theme.TextWhite

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chip = listOf("Sweet sleep", "Insomnia", "Depression"))
        }
    }
}

@Composable
fun GreetingSection(
    name: String = "Shivam"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "We wish tou have good day!",
                style = MaterialTheme.typography.titleSmall
            )
        }
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chip: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chip.size) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        when (selectedChipIndex) {
                            it -> {
                                ButtonBlue
                            }

                            else -> {
                                DarkerButtonBlue
                            }
                        }
                    )
                    .padding(15.dp)
            ) {
                Text(text = chip[it], color = TextWhite)
            }
        }
    }

}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {

}
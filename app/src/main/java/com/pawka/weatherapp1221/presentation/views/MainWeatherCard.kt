package com.pawka.weatherapp1221.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pawka.weatherapp1221.domain.models.WeatherModel

@Composable
fun WeatherCard(
    weather: WeatherModel,
    onClickSync: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = weather.current.lastUpdatedEpoch.toString(),
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.Black
                    )
                    AsyncImage(
                        model = "https:${weather.current.condition.icon}",
                        contentDescription = "im2",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = 8.dp, end = 8.dp)
                    )
                }
            }
            Text(
                text = "Moscow",
                style = TextStyle(fontSize = 24.sp),
                color = Color.Black
            )
            Text(
                text = "${weather.current.temp} °C",
                style = TextStyle(fontSize = 64.sp),
                color = Color.Black
            )
            Text(
                text = weather.current.condition.text,
                style = TextStyle(fontSize = 16.sp),
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                IconButton(onClick = {
                    onClickSync.invoke()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "im4"
                    )
                }
            }
        }

    }
}
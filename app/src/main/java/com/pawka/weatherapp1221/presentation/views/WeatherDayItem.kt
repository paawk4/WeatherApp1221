package com.pawka.weatherapp1221.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pawka.weatherapp1221.R
import com.pawka.weatherapp1221.domain.models.ForecastDay

@Composable
fun WeatherDayItem(forecastDay: ForecastDay) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(100.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .width(180.dp)
                    .fillMaxHeight()
                    .padding(start = 8.dp, top = 5.dp, bottom = 5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = forecastDay.date)
                Text(text = forecastDay.forecast.condition.text, fontSize = 16.sp)
            }
            Column {
                Text(
                    text = "${forecastDay.forecast.avgTemp.toInt()}°C",
                    style = TextStyle(fontSize = 25.sp)
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_humidity),
                        contentDescription = "humidity",
                        tint = Color.Blue,
                    )
                    Text(text = "${forecastDay.forecast.avgHumidity.toInt()}%")
                }
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wind),
                        contentDescription = "humidity",
                        tint = Color.Gray
                    )
                    Text(text = "${forecastDay.forecast.maxWind.toInt()} км/ч")
                }
            }
            AsyncImage(
                model = "https:${forecastDay.forecast.condition.icon}",
                contentDescription = "condition icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 8.dp)
            )
        }

    }
}
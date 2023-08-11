package com.pawka.weatherapp1221.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
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
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(start = 8.dp, top = 5.dp, bottom = 5.dp)) {
                Text(text = forecastDay.dateEpoch.toString())
                Text(text = forecastDay.day.condition.text)
            }
            Text(
                text = "${forecastDay.day.avgTemp} °C",
                style = TextStyle(fontSize = 25.sp)
            )
            AsyncImage(
                model = "https:${forecastDay.day.condition.icon}",
                contentDescription = "im2",
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
            )
        }

    }
}
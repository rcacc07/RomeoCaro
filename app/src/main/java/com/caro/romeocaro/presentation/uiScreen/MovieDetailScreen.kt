package com.caro.romeocaro.presentation.uiScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.caro.romeocaro.R
import com.caro.romeocaro.data.MovieDetailDTO
import com.caro.romeocaro.domain.viewModel.MovieViewModel

@Composable
fun DetailsScreen(id: Int) {
    val movieViewModel = viewModel<MovieViewModel>()
    movieViewModel.id = id
    movieViewModel.getDetailsById()
    val state = movieViewModel.state
    val details = state.detailsData

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        BackGroundPoster(details = details)
        Column(
            Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 50.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = details.title,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 38.sp,
                color = Color.White,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center
            )
            Rating(details = details, modifier = Modifier)
            TextBuilder(icon = Icons.Filled.Info, title = "Overview:", bodyText = details.overview)
        }
    }
}

@Composable
fun Rating(details: MovieDetailDTO, modifier: Modifier) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Icon(imageVector = Icons.Filled.Star, contentDescription = "", tint = Color.White)
        Text(
            text = details.vote_average.toString(),
            modifier.padding(start = 6.dp),
            color = Color.White
        )
        Spacer(modifier = modifier.width(25.dp))
        Icon(
            painter = painterResource(id = R.drawable.time_24),
            contentDescription = "",
            tint = Color.White
        )
        Text(
            text = details.runtime.toString(),
            modifier.padding(start = 6.dp),
            color = Color.White
        )
        Spacer(modifier = modifier.width(25.dp))
        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "", tint = Color.White)
        Text(
            text = details.release_date,
            modifier.padding(start = 6.dp),
            color = Color.White
        )
    }
}

@Composable
fun TextBuilder(icon: ImageVector, title: String, bodyText: String) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = "Person",
            tint = Color.White
        )
        Text(
            text = title,
            Modifier.padding(start = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
    Text(text = bodyText, color = Color.White)
}

@Composable
fun BackGroundPoster(details: MovieDetailDTO) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500"+details.poster_path,
            contentDescription = details.title,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.6f)
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.DarkGray
                        )
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
        )
    }

}



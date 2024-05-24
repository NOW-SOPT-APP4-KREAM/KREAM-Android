package org.sopt.kream.presentation.ui.main.home.release

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import org.sopt.kream.R
import org.sopt.kream.presentation.ui.model.Advertisement
import org.sopt.kream.theme.robotoBold
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ReleaseAdvertisementViewPager(
    advertisements: List<Advertisement>,
    targetTimeInMillis: Long,
) {
    val pagerState = rememberPagerState()

    Box {
        HorizontalPager(
            count = advertisements.size,
            state = pagerState,
            modifier = Modifier.height(327.dp),
        ) { page ->
            val advertisement = advertisements[page]

            Box {
                Advertisement(
                    imgResource = advertisement.imgResource,
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .aspectRatio(1f),
                )
                if (page == 0) {
                    CountdownTimer(targetTimeInMillis, textStyle = robotoBold)
                }
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(310.dp))

            TabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier.height(2.dp).fillMaxWidth().padding(start = 14.dp).padding(end = 14.dp),
                backgroundColor = colorResource(id = R.color.gray04),
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            .height(2.dp)
                            .background(colorResource(id = R.color.black01)),
                    )
                },
                divider = {},
            ) {
                advertisements.forEachIndexed { index, _ ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { },
                        modifier = Modifier.height(2.dp),
                    ) {}
                }
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun CountdownTimer(
    targetTimeInMillis: Long,
    textStyle: androidx.compose.ui.text.TextStyle,
) {
    var remainingTime by remember { mutableLongStateOf(calculateRemainingTime(targetTimeInMillis)) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            remainingTime = calculateRemainingTime(targetTimeInMillis)
        }
    }

    val days = TimeUnit.MILLISECONDS.toDays(remainingTime)
    val hours = TimeUnit.MILLISECONDS.toHours(remainingTime) % 24
    val minutes = TimeUnit.MILLISECONDS.toMinutes(remainingTime) % 60
    val seconds = TimeUnit.MILLISECONDS.toSeconds(remainingTime) % 60

    val formattedDays = String.format("%02d", days)
    val formattedHours = String.format("%02d", hours)
    val formattedMinutes = String.format("%02d", minutes)
    val formattedSeconds = String.format("%02d", seconds)

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 42.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = formattedDays, style = textStyle)
        Spacer(modifier = Modifier.width(23.dp))
        Text(text = formattedHours, style = textStyle)
        Spacer(modifier = Modifier.width(23.dp))
        Text(text = formattedMinutes, style = textStyle)
        Spacer(modifier = Modifier.width(23.dp))
        Text(text = formattedSeconds, style = textStyle)
    }
}

fun calculateRemainingTime(targetTimeInMillis: Long): Long {
    val currentTimeInMillis = System.currentTimeMillis()
    return targetTimeInMillis - currentTimeInMillis
}

@Composable
fun Advertisement(
    imgResource: Int,
    modifier: Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = imgResource),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

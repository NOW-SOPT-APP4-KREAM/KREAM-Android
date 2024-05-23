package org.sopt.kream.presentation.ui.main.home.release

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.kream.R
import org.sopt.kream.data.model.response.ResponseReleaseProductDto
import org.sopt.kream.databinding.FragmentReleaseBinding
import org.sopt.kream.theme.body4Bold
import org.sopt.kream.theme.body5Regular
import org.sopt.kream.theme.body6Regular
import org.sopt.kream.theme.robotoBold
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.view.UiState
import java.util.Calendar
import java.util.concurrent.TimeUnit

class ReleaseFragment : BindingFragment<FragmentReleaseBinding>({ FragmentReleaseBinding.inflate(it) }) {
    private val viewModel = ReleaseProductViewModel()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getReleaseProduct()

        viewModel.getReleaseProductState.flowWithLifecycle(viewLifecycleOwner.lifecycle).onEach { getReleaseProductState ->
            when (getReleaseProductState) {
                is UiState.Success -> {
                    binding.cvRelease.setContent {
                        UiStateISSuccess(getReleaseProductState.data, viewModel.advertisements)

                    }
                }

                else -> Unit
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}

@Composable
fun UiStateISSuccess(
    uiState: List<ResponseReleaseProductDto.ReleaseProductResponseDto>,
    advertisements: List<Advertisement>,
) {
    val advertisement by remember { mutableStateOf(advertisements) }
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth(),
        ) {
            val targetDate =
                Calendar.getInstance().apply {
                    set(2024, Calendar.JUNE, 30, 12, 0, 0)
                }
            val targetTimeInMillis = targetDate.timeInMillis

            CustomViewPager(
                advertisements = advertisement,
                targetTimeInMillis = targetTimeInMillis,
            )
            CustomMidNaviBar()
            ShoesList(uiState)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomViewPager(
    advertisements: List<Advertisement>,
    targetTimeInMillis: Long,
) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = advertisements.size,
        state = pagerState,
        modifier = Modifier.height(327.dp),
    ) { page ->
        val advertisement = advertisements[page]

        Box {
            CustomAdvertisement(
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
}

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
fun CustomAdvertisement(
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

@Composable
fun CustomMidNaviBar() {
    val shoes =
        listOf(
            stringResource(R.string.release_chip_shoes_list_today),
            stringResource(R.string.release_chip_shoes_list_Nike),
            stringResource(R.string.release_chip_shoes_list_Adidas),
            stringResource(R.string.release_chip_shoes_list_Asics),
            stringResource(R.string.release_chip_shoes_list_NewBalance),
            stringResource(R.string.release_chip_shoes_list_Jordan),
            stringResource(R.string.release_chip_shoes_list_converse),
        )

    var selectedIndex by remember { mutableIntStateOf(0) } // Track selected index

    Column {
        LazyRow(
            modifier =
                Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .background(Color.White),
        ) {
            items(shoes.size) { index ->
                val isSelected = index == selectedIndex
                val backgroundColor = if (isSelected) colorResource(id = R.color.red01) else colorResource(id = R.color.gray05)
                val textColor = if (isSelected) colorResource(id = R.color.red02) else Color.Black // Update to your selected and default text color

                if (index == 0) {
                    Row(
                        modifier =
                            Modifier
                                .padding(top = 10.dp)
                                .padding(start = 14.dp)
                                .padding(end = 6.dp)
                                .clickable { selectedIndex = 0 },
                    ) {
                        Spacer(modifier = Modifier.width(4.dp))

                        CustomShoesText(
                            text = shoes[index],
                            textColor = textColor,
                            backgroundColor = backgroundColor,
                        )

                        Box(
                            modifier =
                                Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 9.dp)
                                    .width(1.dp)
                                    .height(23.dp)
                                    .background(colorResource(id = R.color.gray04)),
                        )
                    }
                } else {
                    Column(
                        modifier =
                            Modifier
                                .padding(top = 10.dp)
                                .padding(bottom = 10.dp)
                                .padding(end = 6.dp)
                                .clickable { selectedIndex = index },
                    ) {
                        Text(
                            text = shoes[index],
                            style = body5Regular.copy(color = textColor),
                            modifier =
                                Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(backgroundColor)
                                    .padding(10.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShoesItem(releaseProductResponseDto: ResponseReleaseProductDto.ReleaseProductResponseDto) {
    var isIconChanged by remember { mutableStateOf(false) }

    val iconResource =
        if (isIconChanged) {
            R.drawable.ic_saved_1_on_24
        } else {
            R.drawable.ic_saved_1_off_24
        }

    var cardState by remember {
        mutableStateOf("")
    }
    var stateVisible by remember {
        mutableFloatStateOf(1f)
    }
    var cardColor by remember {
        mutableIntStateOf(R.color.blue03)
    }
    if (releaseProductResponseDto.isUpdate) {
        cardState = "UPDATE"
    } else if (releaseProductResponseDto.isNew) {
        cardState = "NEW"
        cardColor = R.color.red01
    } else {
        cardState = "NULL"
        stateVisible = 0f
        cardColor = R.color.gray06
    }
    Column(modifier = Modifier.size(width = 161.dp, height = 177.dp)) {
        Box(
            modifier =
                Modifier
                    .size(width = 161.dp, height = 108.dp)
                    .background(colorResource(id = cardColor), shape = RoundedCornerShape(10.dp)),
        ) {
            Image(
                painter = rememberAsyncImagePainter(releaseProductResponseDto.thumbnailUrl),
                contentDescription = null,
                modifier =
                    Modifier
                        .size(width = 108.dp, height = 108.dp)
                        .align(Alignment.Center),
            )
            Row(
                modifier = Modifier.padding(8.dp),
            ) {
                DrawCard(cardState, stateVisible)
                Icon(
                    painter = painterResource(id = iconResource),
                    contentDescription = null,
                    modifier =
                        Modifier.clickable {
                            isIconChanged = !isIconChanged

                        },
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = releaseProductResponseDto.brandTitle, style = body4Bold, color = colorResource(id = R.color.black02))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = releaseProductResponseDto.engTitle, style = body5Regular, color = colorResource(id = R.color.black02))
        }
    }
}

@Composable
fun ShoesList(shoesList: List<ResponseReleaseProductDto.ReleaseProductResponseDto>) {
    Column {
        val items = List(12) { it }
        for (i in items.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                ShoesItem(shoesList[i])
                if (i + 1 < items.size) {
                    ShoesItem(shoesList[i + 1])
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

@Composable
fun CustomShoesText(
    text: String,
    textColor: Color,
    backgroundColor: Color,
) {
    Text(
        text = text,
        style = body5Regular,
        color = textColor,
        modifier =
            Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(backgroundColor)
                .padding(10.dp),
    )
}

@Composable
fun DrawCard(
    cardState: String,
    stateVisible: Float,
) {
    if (cardState == "UPDATE") {
        Column(
            modifier =
                Modifier
                    .padding(3.dp)
                    .alpha(stateVisible),
        ) {
            Box(
                modifier =
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .size(width = 50.dp, height = 15.dp)
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.gray03),
                            shape = RoundedCornerShape(10.dp),
                        ),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier =
                        Modifier
                            .clip(RoundedCornerShape(9.dp))
                            .background(Color.White)
                            .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = cardState,
                        style = body6Regular,
                        color = colorResource(id = R.color.black06),
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(69.dp))
    } else {
        Column(
            modifier =
                Modifier
                    .padding(3.dp)
                    .alpha(stateVisible),
        ) {
            Box(
                modifier =
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .size(width = 35.dp, height = 15.dp)
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.red02),
                            shape = RoundedCornerShape(10.dp),
                        ),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier =
                        Modifier
                            .clip(RoundedCornerShape(9.dp))
                            .background(colorResource(id = R.color.red02))
                            .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = cardState,
                        style = body6Regular,
                        color = Color.White,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(84.dp))
    }
}

package org.sopt.kream.presentation.ui.dummy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import org.sopt.kream.R
import org.sopt.kream.theme.Black01
import org.sopt.kream.theme.Black02
import org.sopt.kream.theme.Black09
import org.sopt.kream.theme.Gray06
import org.sopt.kream.theme.body3SemiBold
import org.sopt.kream.theme.body4Bold
import org.sopt.kream.theme.body5Regular
import org.sopt.kream.theme.body6Regular
import org.sopt.kream.theme.head1Bold

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun View1Screen() {
    val pages =
        listOf(
            stringResource(R.string.topBar_pageList_recommend),
            stringResource(R.string.topBar_pageList_ranking),
            stringResource(R.string.topBar_pageList_information),
            stringResource(R.string.topBar_pageList_luxury),
            stringResource(R.string.topBar_pageList_male),
            stringResource(R.string.topBar_pageList_female),
            stringResource(R.string.topBar_pageList_found),
        )

    var editText by remember {
        mutableStateOf("")
    }
    val pagerState =
        rememberPagerState {
            pages.size
        }
    Scaffold(
        topBar = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(33.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.width(14.dp))

                    BasicTextField(
                        value = editText,
                        onValueChange = { editText = it },
                        singleLine = true,
                        modifier =
                        Modifier
                            .weight(1f)
                            .size(width = 293.dp, height = 33.dp)
                            .background(color = Gray06, shape = RoundedCornerShape(9.dp)),
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier.padding(start = 7.dp),
                            ) {
                                innerTextField()
                                if (editText.isEmpty()) {
                                    Text(
                                        style = body5Regular,
                                        color = Black09,
                                        text = stringResource(id = R.string.search_bar_label),
                                    )
                                }
                            }
                        },
                    )

                    Spacer(modifier = Modifier.width(14.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_topappbar_bell_28),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                    )
                    Spacer(modifier = Modifier.width(11.dp))
                }
                CustomTopTabPager(pages, pagerState, pages)
            }
        },
    ) { innerPadding ->
        View1Content(Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomTopTabPager(
    pages: List<String>,
    pagerState: PagerState,
    tabs: List<String>,
) {
    val coroutineScope = rememberCoroutineScope()
    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    modifier =
                    Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = Black02,
                    width = pages[pagerState.currentPage].length * 12.dp,
                )
            },
            containerColor = Color.White,
            contentColor = Black02,
            edgePadding = 0.dp,
            modifier = Modifier.padding(0.dp),
            divider = {
                HorizontalDivider(
                    modifier =
                    Modifier
                        .fillMaxWidth(),
                    color = Color.LightGray,
                    thickness = 1.dp,
                )
            },
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title, style = body3SemiBold) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier.width(0.dp),
                )
            }
        }

        HorizontalPager(
            state = pagerState,
        ) { page ->
            Column(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                when (page) {
                    0 -> View1Content(modifier = Modifier)
                    2 -> View2Content()
                }
            }
        }
    }
}

@Composable
fun View1Content(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "추천",
            style = head1Bold,
            color = Black01,
        )
    }
}

@Composable
fun CustomRecyclerView(advertisements: List<Advertisement>) {
    LazyRow(
        modifier = Modifier.height(327.dp),
        content = {
            itemsIndexed(advertisements) { index, advertisement ->
                CustomAdvertisement(
                    imgResource = advertisement.imgResource,
                )
            }
        },
    )
}

data class Advertisement(
    val id: Int,
    val imgResource: Int,
)

@Composable
fun CustomAdvertisement(imgResource: Int) {
    Column(modifier = Modifier.size(width = 360.dp, height = 327.dp)) {
        Image(
            painter = painterResource(id = imgResource),
            modifier =
            Modifier
                .fillMaxSize()
                .weight(1f),
            contentDescription = "",
        )
    }
}

class RecyclerViewViewModel : ViewModel() {
    val advertisements = mutableStateOf(generateDummyAdvertisement())

    private fun generateDummyAdvertisement(): List<Advertisement> {
        val adLists =
            listOf(
                R.drawable.img_view1_ad_01,
                R.drawable.img_view1_ad_02,
                R.drawable.img_view1_ad_03,
                R.drawable.img_view1_ad_04,
            )

        return List(4) { index ->
            Advertisement(
                id = index,
                imgResource = adLists[index],
            )
        }
    }
}

@Composable
fun CustomMidNaviBar() {
    val shoes = listOf(
        stringResource(R.string.mid_navi_bar_today),
        stringResource(R.string.mid_navi_bar_Nike),
        stringResource(R.string.mid_navi_bar_Adidas),
        stringResource(R.string.mid_navi_bar_Asics),
        stringResource(R.string.mid_navi_bar_NewBalance),
        stringResource(R.string.mid_navi_bar_Jordan),
        stringResource(R.string.mid_navi_bar_converse),
    )

    var selectedIndex by remember { mutableStateOf(0) } // Track selected index

    Column {
        LazyRow(
            modifier = Modifier
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
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { selectedIndex = index }
                    ) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = shoes[index],
                            style = body5Regular.copy(color = textColor), // Apply text color
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(backgroundColor)
                                .padding(10.dp)
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 18.dp)
                                .width(1.dp)
                                .height(23.dp)
                                .background(colorResource(id = R.color.gray04)) // Divider color
                        )
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { selectedIndex = index }
                    ) {
                        Text(
                            text = shoes[index],
                            style = body5Regular.copy(color = textColor), // Apply text color
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp)) // Apply rounded corners
                                .background(backgroundColor)
                                .padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun View2Content() {
    val advertisements by remember { RecyclerViewViewModel().advertisements }
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
            CustomRecyclerView(
                advertisements = advertisements,
            )
            CustomMidNaviBar()
            ShoesList()
        }
    }
}

@Composable
fun ShoesItem(index: Int) {
    var isIconChanged by remember { mutableStateOf(false) }

    val iconResource = if (isIconChanged) {
        R.drawable.ic_saved_1_on_24
    } else {
        R.drawable.ic_saved_1_off_24
    }

    Column(modifier = Modifier.size(width = 161.dp, height = 177.dp)) {
        Box(
            modifier = Modifier
                .size(width = 161.dp, height = 108.dp)
                .background(colorResource(id = R.color.blue03), shape = RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(3.dp)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .size(width = 50.dp, height = 15.dp)
                            .border(
                                width = 1.dp,
                                color = colorResource(id = R.color.gray03),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color.White)
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "UPDATE",
                                style = body6Regular,
                                color = colorResource(id = R.color.black06)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(69.dp))
                Icon(
                    painter = painterResource(id = iconResource),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isIconChanged = !isIconChanged
                    }
                )

            }
            Image(painter = painterResource(id = R.drawable.img_view1_swipe_dummy),
                contentDescription = null,
                modifier = Modifier.size(width = 108.dp, height = 108.dp).align(Alignment.Center))


        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "NIKE", style = body4Bold, color = colorResource(id = R.color.black02))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Nike Dunk Low SP Venner", style = body5Regular, color = colorResource(id = R.color.black02))
        }
    }
}


@Preview
@Composable
fun ShoesList() {
    Column {
        val items = List(12) { it }
        Spacer(modifier = Modifier.height(6.dp))
        for (i in items.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                ShoesItem(index = i)
                if (i + 1 < items.size) {
                    ShoesItem(index = i + 1)
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}
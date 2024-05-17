package org.sopt.kream.presentation.ui.dummy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.Color
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
import org.sopt.kream.theme.body5Regular
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
                R.drawable.img_view1_ad_01,
                R.drawable.img_view1_ad_01,
            )

        return List(3) { index ->
            Advertisement(
                id = index,
                imgResource = adLists[index],
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomMidNaviBar() {
    val shoes =
        listOf(
            stringResource(R.string.mid_navi_bar_today),
            stringResource(R.string.mid_navi_bar_Nike),
            stringResource(R.string.mid_navi_bar_Adidas),
            stringResource(R.string.mid_navi_bar_Asics),
            stringResource(R.string.mid_navi_bar_NewBalance),
            stringResource(R.string.mid_navi_bar_Jordan),
            stringResource(R.string.mid_navi_bar_converse),
        )
    val pagerState =
        rememberPagerState {
            shoes.size
        }
    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Color.White,
            contentColor = Black02,
            edgePadding = 0.dp,
            modifier = Modifier.padding(0.dp),
            indicator = { tabPositions -> },
        ) {
            shoes.forEachIndexed { index, title ->
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(title, style = body5Regular)
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
            ShoesCardList()
        }
    }

}


@Composable
fun ShoesCardItem(index: Int) {
    Card(
        modifier =
        Modifier.size(width = 161.dp, height = 177.dp),
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Card Title ${index+1}", modifier = Modifier.padding(bottom = 8.dp), style = head1Bold)
            Text(text = "해냈어 조장!!", style = body5Regular)
        }
    }
}

@Preview
@Composable
fun ShoesCardList() {
    Column {
        val items = List(12) { it }
        Spacer(modifier = Modifier.height(6.dp))
        for (i in items.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ShoesCardItem(index = i)
                if (i + 1 < items.size) {
                    ShoesCardItem(index = i + 1)
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

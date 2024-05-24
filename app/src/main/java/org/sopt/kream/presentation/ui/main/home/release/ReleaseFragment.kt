package org.sopt.kream.presentation.ui.main.home.release

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.kream.R
import org.sopt.kream.data.model.response.ResponseReleaseProductDto
import org.sopt.kream.databinding.FragmentReleaseBinding
import org.sopt.kream.presentation.common.ViewModelFactory
import org.sopt.kream.presentation.ui.main.home.recommend.RecommendFragment
import org.sopt.kream.presentation.ui.model.Advertisement
import org.sopt.kream.theme.body4Bold
import org.sopt.kream.theme.body5Regular
import org.sopt.kream.theme.body6Regular
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.modifier.noRippleClickable
import org.sopt.kream.util.view.UiState
import java.util.Calendar

class ReleaseFragment : BindingFragment<FragmentReleaseBinding>({ FragmentReleaseBinding.inflate(it) }) {
    private val viewModel: ReleaseProductViewModel by viewModels { ViewModelFactory() }

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
                        ReleaseView(
                            viewModel.advertisements,
                            getReleaseProductState.data,
                            ::postScrapProduct,
                            ::deleteScrapProduct,
                            ::navigateToProductDetail,
                        )
                    }
                }

                else -> Unit
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getReleaseProduct()
    }

    private fun navigateToProductDetail(productId: Int) {
        findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(RecommendFragment.PRODUCT_ID to productId))
    }

    private fun postScrapProduct(productId: Int) {
        viewModel.postScrapProduct(productId = productId)
    }

    private fun deleteScrapProduct(productId: Int) {
        viewModel.deleteScrapProduct(productId = productId)
    }
}

@Composable
fun ReleaseView(
    advertisements: List<Advertisement>,
    releaseProductResponseDtoList: List<ResponseReleaseProductDto.ReleaseProductResponseDto>,
    postScrapProduct: (Int) -> Unit,
    deleteScrapProduct: (Int) -> Unit,
    navigateToProductDetail: (Int) -> Unit,
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

            ReleaseAdvertisementViewPager(
                advertisements = advertisement,
                targetTimeInMillis = targetTimeInMillis,
            )
            ReleaseMiddleChips()
            ShoesList(
                releaseProductResponseDtoList,
                postScrapProduct,
                deleteScrapProduct,
                navigateToProductDetail,
            )
        }
    }
}

@Composable
fun ShoesItem(
    releaseProductResponseDto: ResponseReleaseProductDto.ReleaseProductResponseDto,
    index: Int,
    postScrapProduct: (Int) -> Unit,
    deleteScrapProduct: (Int) -> Unit,
    navigateToProductDetail: (Int) -> Unit,
) {
    var isIconChanged by remember { mutableStateOf(releaseProductResponseDto.isScrap) }
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
    Column(
        modifier =
            Modifier
                .size(width = 161.dp, height = 177.dp)
                .noRippleClickable {
                    navigateToProductDetail(index)
                },
    ) {
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
                        Modifier.noRippleClickable {
                            if (isIconChanged) {
                                deleteScrapProduct(index + 1)
                            } else {
                                postScrapProduct(index + 1)
                            }
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
fun ShoesList(
    releaseProductResponseDtoList: List<ResponseReleaseProductDto.ReleaseProductResponseDto>,
    postScrapProduct: (Int) -> Unit,
    deleteScrapProduct: (Int) -> Unit,
    navigateToProductDetail: (Int) -> Unit,
) {
    Column {
        val items = List(12) { it }
        for (i in items.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                ShoesItem(releaseProductResponseDtoList[i], i, postScrapProduct, deleteScrapProduct, navigateToProductDetail)
                if (i + 1 < items.size) {
                    ShoesItem(releaseProductResponseDtoList[i + 1], i + 1, postScrapProduct, deleteScrapProduct, navigateToProductDetail)
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

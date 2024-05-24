package org.sopt.kream.presentation.ui.search

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentSearchBinding
import org.sopt.kream.presentation.common.ViewModelFactory
import org.sopt.kream.presentation.ui.main.home.HomeFragment.Companion.SEARCH_WORD
import org.sopt.kream.presentation.type.SearchTabBarType
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.component.KreamTab
import org.sopt.kream.util.component.KreamTabBar
import org.sopt.kream.util.component.KreamTextField
import org.sopt.kream.util.fragment.stringOf
import org.sopt.kream.util.modifier.noRippleClickable
import org.sopt.kream.util.view.UiState

class SearchFragment : BindingFragment<FragmentSearchBinding>({ FragmentSearchBinding.inflate(it) }) {
    private val searchViewModel: SearchViewModel by viewModels { ViewModelFactory() }
    private lateinit var findName: String
    private lateinit var searchRelatedSearchWordAdapter: SearchRelatedSearchWordAdapter
    private lateinit var searchRelateRecommendProductAdapter: SearchRelateRecommendProductAdapter
    private lateinit var searchSearchFindProductAdapter: SearchSearchFindProductAdapter
    private lateinit var rvSearchSearchFindProductListLayoutManager: GridLayoutManager
    private lateinit var rvSearchSearchFindProductListSecondLayoutManager: GridLayoutManager

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        findName = getSearchWord()
        rvSearchSearchFindProductListLayoutManager = GridLayoutManager(requireContext(), SPAN_COUNT_2)
        rvSearchSearchFindProductListSecondLayoutManager = GridLayoutManager(requireContext(), SPAN_COUNT_2)
        searchViewModel.getSearchProduct(findName = findName)
        initLayout()
        initAdapter()
        collectSearchProductState()
        setIvSearchTopBarProductSortingClickListener()
    }

    private fun initLayout() {
        binding.cvSearchTop.setContent {
            TopLayout()
        }
        binding.tvSearchRelateRecommendProductListSearchWord.text = findName
    }

    private fun initAdapter() {
        searchRelatedSearchWordAdapter = SearchRelatedSearchWordAdapter()
        searchRelateRecommendProductAdapter = SearchRelateRecommendProductAdapter(::navigateToProductDetail)
        searchSearchFindProductAdapter = SearchSearchFindProductAdapter(::navigateToProductDetail)

        with(binding) {
            rvSearchRelatedSearchWordList.adapter = searchRelatedSearchWordAdapter
            rvSearchRelatedProductList.adapter = searchRelateRecommendProductAdapter
            rvSearchSearchFindProductList.adapter = searchSearchFindProductAdapter
            rvSearchSearchFindProductListSecond.adapter = searchSearchFindProductAdapter
        }

        searchRelatedSearchWordAdapter.submitList(searchViewModel.relatedSearchWordList)
    }

    private fun collectSearchProductState() {
        searchViewModel.searchProductState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { searchProductState ->
                when (searchProductState) {
                    is UiState.Success -> {
                        with(searchProductState.data) {
                            searchRelateRecommendProductAdapter.submitList(relateRecommendProducts)
                            searchSearchFindProductAdapter.submitList(searchFindProducts)
                        }
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setIvSearchTopBarProductSortingClickListener() {
        binding.ivSearchTopBarProductSorting.setOnClickListener {
            rvSearchSearchFindProductListLayoutManager.run {
                spanCount = if (spanCount == SPAN_COUNT_2) SPAN_COUNT_3 else SPAN_COUNT_2
            }

            rvSearchSearchFindProductListSecondLayoutManager.run {
                spanCount = if (spanCount == SPAN_COUNT_2) SPAN_COUNT_3 else SPAN_COUNT_2
            }

            with(binding) {
                rvSearchSearchFindProductList.layoutManager = rvSearchSearchFindProductListLayoutManager
                rvSearchSearchFindProductListSecond.layoutManager = rvSearchSearchFindProductListSecondLayoutManager
            }
        }
    }

    @Composable
    private fun TopLayout() {
        var selectedTabPosition by remember { mutableIntStateOf(DEFAULT_SELECTED_TAB_POSITION) }

        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 2.dp, end = 14.dp),
            ) {
                Image(
                    modifier =
                        Modifier
                            .padding(4.dp)
                            .noRippleClickable(),
                    painter = painterResource(id = R.drawable.ic_bar_back_24),
                    contentDescription = null,
                )
                Spacer(
                    modifier = Modifier.width(19.dp),
                )
                KreamTextField(
                    modifier =
                        Modifier
                            .weight(1f),
                    value = findName,
                )
            }

            KreamTabBar(selectedTabPosition = selectedTabPosition) {
                SearchTabBarType.entries.forEachIndexed { index, searchTabBarType ->
                    KreamTab(text = stringOf(searchTabBarType.searchBarTextRes), paddingTop = 13, paddingBottom = 6, paddingHorizontal = 10, position = index, selected = index == selectedTabPosition)
                }
            }
        }
    }

    private fun getSearchWord(): String = requireArguments().getString(SEARCH_WORD).orEmpty()

    private fun navigateToProductDetail(productId: Int) {
        findNavController().navigate(R.id.action_search_to_product_detail, bundleOf(PRODUCT_ID to productId))
    }

    companion object {
        const val DEFAULT_SELECTED_TAB_POSITION = 0
        const val PRODUCT_ID = "productId"
        const val SPAN_COUNT_2 = 2
        const val SPAN_COUNT_3 = 3
    }
}

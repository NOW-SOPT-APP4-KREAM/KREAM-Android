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
import androidx.recyclerview.widget.ConcatAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentSearchBinding
import org.sopt.kream.presentation.common.ViewModelFactory
import org.sopt.kream.presentation.ui.main.home.HomeFragment.Companion.SEARCH_WORD
import org.sopt.kream.presentation.ui.type.SearchTabBarType
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
    private lateinit var searchTopBarAdapter: SearchTopBarAdapter
    private lateinit var searchRelatedSearchWordListAdapter: SearchRelatedSearchWordListAdapter
    private lateinit var searchRelateRecommendProductListAdapter: SearchRelateRecommendProductListAdapter
    private lateinit var firstSearchSearchFindProductListAdapter: SearchSearchFindProductListAdapter
    private lateinit var secondSearchSearchFindProductListAdapter: SearchSearchFindProductListAdapter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        initTop()
        initAdapter()
        findName = getSearchWord()
        searchViewModel.getSearchProduct(findName = findName)
        collectSearchProductState()
    }

    private fun initTop() {
        binding.cvSearchTop.setContent {
            TopLayout()
        }
    }

    private fun initAdapter() {
        searchTopBarAdapter = SearchTopBarAdapter()
        searchRelatedSearchWordListAdapter = SearchRelatedSearchWordListAdapter()
        searchRelateRecommendProductListAdapter = SearchRelateRecommendProductListAdapter(::navigateToProductDetail)
        firstSearchSearchFindProductListAdapter = SearchSearchFindProductListAdapter(::navigateToProductDetail)
        secondSearchSearchFindProductListAdapter = SearchSearchFindProductListAdapter(::navigateToProductDetail)

        binding.rvSearch.adapter =
            ConcatAdapter(
                searchTopBarAdapter,
                firstSearchSearchFindProductListAdapter,
                searchRelatedSearchWordListAdapter,
                secondSearchSearchFindProductListAdapter,
                searchRelateRecommendProductListAdapter,
            )
    }

    private fun collectSearchProductState() {
        searchViewModel.searchProductState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { searchProductState ->
                when (searchProductState) {
                    is UiState.Success -> {
                        with(searchProductState.data) {
                            searchTopBarAdapter.submitList(listOf(Unit))
                            searchRelatedSearchWordListAdapter.submitList(listOf(searchViewModel.relatedSearchWordList))
                            firstSearchSearchFindProductListAdapter.submitList(listOf(searchFindProducts))
                            secondSearchSearchFindProductListAdapter.submitList(listOf(searchFindProducts))
                            searchRelateRecommendProductListAdapter.submitList(listOf(Pair(relateRecommendProducts, findName)))
                        }
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
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
    }
}

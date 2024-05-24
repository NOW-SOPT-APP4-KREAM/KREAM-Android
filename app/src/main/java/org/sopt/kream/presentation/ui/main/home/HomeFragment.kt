package org.sopt.kream.presentation.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentHomeBinding
import org.sopt.kream.presentation.ui.main.home.recommend.RecommendFragment
import org.sopt.kream.presentation.ui.main.home.release.ReleaseFragment
import org.sopt.kream.presentation.type.HomeTabBarType
import org.sopt.kream.theme.PinkColor
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.component.KreamTab
import org.sopt.kream.util.component.KreamTabBar
import org.sopt.kream.util.component.KreamTextField
import org.sopt.kream.util.fragment.stringOf
import org.sopt.kream.util.view.KreamFragmentStateAdapter

class HomeFragment : BindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }) {
    private lateinit var fragmentList: ArrayList<Fragment>
    private lateinit var fragmentStateAdapter: KreamFragmentStateAdapter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        initTop()
        initVpHome()
    }

    private fun initTop() {
        binding.cvHomeTop.setContent {
            TopLayout()
        }
    }

    private fun initVpHome() {
        fragmentList = ArrayList()

        fragmentList.apply {
            add(RecommendFragment())
            add(ReleaseFragment())
        }

        fragmentStateAdapter = KreamFragmentStateAdapter(fragmentList, this@HomeFragment)

        with(binding.vpHome) {
            adapter = fragmentStateAdapter
            isUserInputEnabled = false
        }
    }

    @Composable
    private fun TopLayout() {
        var selectedTabPosition by remember { mutableIntStateOf(RECOMMEND_INDEX) }
        var searchText by remember {
            mutableStateOf("")
        }

        val clickableTabs = HomeTabBarType.entries.filter { it.isClickable }

        LaunchedEffect(selectedTabPosition) {
            clickableTabs.indexOf(HomeTabBarType.entries[selectedTabPosition]).let { tabPosition ->
                if (tabPosition != -1) binding.vpHome.currentItem = tabPosition
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 14.dp, end = 11.dp),
            ) {
                KreamTextField(
                    modifier =
                        Modifier
                            .weight(1f)
                            .padding(end = 14.dp),
                    placeholder = stringResource(id = R.string.search_bar_label),
                    value = searchText,
                    onValueChange = { searchText = it },
                    onDone = { navigateToSearch(searchText) },
                )
                Image(
                    painter = painterResource(R.drawable.ic_topappbar_bell_28),
                    contentDescription = null,
                )
            }

            KreamTabBar(selectedTabPosition = selectedTabPosition) {
                HomeTabBarType.entries.forEachIndexed { index, homeTabBarType ->
                    when (index) {
                        FIRST_INDEX -> KreamTab(text = stringOf(homeTabBarType.tabBarTextRes), textColor = PinkColor, position = index, selected = index == selectedTabPosition)
                        else -> {
                            if (homeTabBarType.isClickable) {
                                KreamTab(text = stringOf(homeTabBarType.tabBarTextRes), position = index, selected = index == selectedTabPosition) {
                                    selectedTabPosition = index
                                }
                            } else {
                                KreamTab(text = stringOf(homeTabBarType.tabBarTextRes), position = index, selected = index == selectedTabPosition)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun navigateToSearch(searchWord: String) {
        findNavController().navigate(R.id.action_home_to_search, bundleOf(SEARCH_WORD to searchWord))
    }

    companion object {
        const val FIRST_INDEX = 0
        const val RECOMMEND_INDEX = 1
        const val SEARCH_WORD = "searchWord"
    }
}

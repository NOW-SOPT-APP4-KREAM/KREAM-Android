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
import androidx.fragment.app.Fragment
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentHomeBinding
import org.sopt.kream.presentation.ui.main.MainActivity
import org.sopt.kream.presentation.ui.main.home.recommend.RecommendFragment
import org.sopt.kream.presentation.ui.main.home.release.ReleaseFragment
import org.sopt.kream.theme.PinkColor
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.component.KreamTab
import org.sopt.kream.util.component.KreamTabBar
import org.sopt.kream.util.component.KreamTextField
import org.sopt.kream.util.view.KreamFragmentStateAdapter

class HomeFragment : BindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }) {
    private lateinit var fragmentList: ArrayList<Fragment>
    private lateinit var fragmentStateAdapter: KreamFragmentStateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTop()
        initVpHome()
    }

    private fun initTop() {
        binding.cvHomeTop.setContent {
            SetTopLayout()
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
    private fun SetTopLayout() {
        var selectedTabPosition by remember { mutableIntStateOf(MainActivity.DEFAULT_INDEX) }
        var searchText by remember {
            mutableStateOf("")
        }

        LaunchedEffect(selectedTabPosition) {
            when(selectedTabPosition) {
                1 -> binding.vpHome.setCurrentItem(0)
                3 -> binding.vpHome.setCurrentItem(1)
            }
        }

        val items = listOf(
            stringResource(R.string.top_bar_main_recommend),
            stringResource(R.string.top_bar_main_ranking),
            stringResource(R.string.top_bar_main_information),
            stringResource(R.string.top_bar_main_luxury),
            stringResource(R.string.top_bar_main_male),
            stringResource(R.string.top_bar_main_female),
            stringResource(R.string.top_bar_main_found),
            stringResource(R.string.top_bar_main_event)
        )

        val selectableItems = listOf(
            Pair(stringResource(R.string.top_bar_main_recommend), RECOMMEND_INDEX),
            Pair(stringResource(R.string.top_bar_main_information), INFORMATION_INDEX)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 11.dp)
            ) {
                KreamTextField(
                    modifier = Modifier.weight(1f).padding(end = 14.dp),
                    placeholder = stringResource(id = R.string.search_bar_label),
                    value = searchText,
                    onValueChange = { searchText = it }
                )
                Image(
                    painter = painterResource(R.drawable.ic_topappbar_bell_28),
                    contentDescription = null
                )
            }

            KreamTabBar(selectedTabPosition = selectedTabPosition) {
                KreamTab(text = stringResource(R.string.top_bar_main_md), textColor = PinkColor, position = MainActivity.FIRST_INDEX, selected = MainActivity.FIRST_INDEX == selectedTabPosition)

                items.forEachIndexed { index, text ->
                    (index + 1).let { tabIndex ->
                        KreamTab(text = text, position = tabIndex, selected = tabIndex == selectedTabPosition) {
                            if (text in selectableItems.map { selectableItems ->
                                selectableItems.first
                                }) selectedTabPosition = tabIndex
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val RECOMMEND_INDEX = 0
        const val INFORMATION_INDEX = 1
    }
}
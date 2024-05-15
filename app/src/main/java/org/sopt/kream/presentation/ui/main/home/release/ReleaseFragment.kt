package org.sopt.kream.presentation.ui.main.home.release

import android.os.Bundle
import android.view.View
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.sopt.kream.databinding.FragmentReleaseBinding
import org.sopt.kream.util.base.BindingFragment

class ReleaseFragment : BindingFragment<FragmentReleaseBinding>({ FragmentReleaseBinding.inflate(it) }) {
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvRelease.setContent {
            releaseScreen()
        }
    }

    @Composable
    fun releaseScreen() {
        Text(text = "Release")
    }
}

package org.sopt.kream.presentation.ui.main.release

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import org.sopt.kream.databinding.FragmentReleaseBinding

class ReleaseFragment : Fragment() {
    private var _binding: FragmentReleaseBinding? = null
    private val binding: FragmentReleaseBinding
        get() = requireNotNull(_binding) { }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReleaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvRelease.setContent {
            ReleaseScreen()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @Composable
    fun ReleaseScreen() {
        Text(text = "Release")
    }

}
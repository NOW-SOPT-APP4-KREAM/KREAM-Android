package org.sopt.kream.presentation.ui.dummy

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.kream.databinding.ActivityDummyBinding
import org.sopt.kream.presentation.common.ViewModelFactory
import org.sopt.kream.util.base.BindingActivity

class DummyActivity : BindingActivity<ActivityDummyBinding>({ ActivityDummyBinding.inflate(it) }) {
    private val dummyViewModel: DummyViewModel by viewModels { ViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

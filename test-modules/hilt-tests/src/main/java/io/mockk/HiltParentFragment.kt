package io.mockk

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class HiltParentFragment : Fragment() {
    fun theMethod(): Boolean {
        return false
    }
}
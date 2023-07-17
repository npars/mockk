package io.mockk

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltFragment: Fragment() {
    fun theMethod(): Boolean {
        return false
    }
}


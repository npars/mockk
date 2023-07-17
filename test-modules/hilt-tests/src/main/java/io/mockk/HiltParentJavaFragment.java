package io.mockk;

import androidx.fragment.app.Fragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public abstract class HiltParentJavaFragment extends Fragment {
    public boolean theMethod() {
        return false;
    }
}

package com.automosen.si_helti.screens.onboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity

class OnboardAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return OnboardFragment.newInstance(position+1)
    }

    override fun getCount(): Int {
        return 3
    }
}

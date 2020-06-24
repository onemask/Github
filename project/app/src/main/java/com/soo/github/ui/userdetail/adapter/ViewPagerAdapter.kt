package com.soo.github.ui.userdetail.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.soo.github.constants.Constants.POSITION
import com.soo.github.constants.Constants.USERNAME
import com.soo.github.ui.userdetail.UserOverViewFragment
import com.soo.github.ui.userdetail.UserRepoAndStarredFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, val userName: String) :
    FragmentStatePagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    private var titles = mutableListOf("OVERVIEW", "REPOSITORIES", "STARRED")

    private val fragmentList: List<Fragment> = listOf(
        UserOverViewFragment.newInstance(),
        UserRepoAndStarredFragment.newInstance(),
        UserRepoAndStarredFragment.newInstance()
    )

    override fun getPageTitle(position: Int): CharSequence? = titles[position]

    override fun getItem(position: Int): Fragment {
        return fragmentList[position].apply {
            arguments = Bundle().apply {
                putInt(POSITION, position)
                putString(USERNAME, userName)
            }
        }
    }

    override fun getCount(): Int = fragmentList.count()


}
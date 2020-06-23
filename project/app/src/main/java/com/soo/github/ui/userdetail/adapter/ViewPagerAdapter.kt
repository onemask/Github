package com.soo.github.ui.userdetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.soo.github.ui.userdetail.UserOverViewFragment
import com.soo.github.ui.userdetail.UserRepositoryFragment
import com.soo.github.ui.userdetail.UserStarredFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, userName: String) : FragmentPagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    private var titles = mutableListOf("OVERVIEW", "REPOSITORIES", "STARRED")

    private val fragmentList = listOf(
        UserOverViewFragment.newInstance(userName),
        UserRepositoryFragment.newInstance(userName),
        UserStarredFragment.newInstance(userName)
    )

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.count()


}
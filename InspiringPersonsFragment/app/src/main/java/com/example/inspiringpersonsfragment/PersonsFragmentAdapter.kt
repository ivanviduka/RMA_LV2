package com.example.inspiringpersonsfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PersonsFragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val fragments = arrayOf(
        InputFragment.newInstance(),
        ShowPersonsFragment.newInstance()
    )

    val titles = arrayOf("Add", "Show")

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
    override fun getCount(): Int {
        return fragments.size
    }
}
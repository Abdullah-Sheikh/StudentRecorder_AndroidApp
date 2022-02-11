package com.techsoldev.studentrecorder.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.techsoldev.studentrecorder.fragments.SectionBaseStudentsFragment;
import com.techsoldev.studentrecorder.fragments.StudentsFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new SectionBaseStudentsFragment("Section A");
        }
        else if (position == 1)
        {
            fragment = new SectionBaseStudentsFragment("Section B");
        }
        else if (position == 2)
        {
            fragment = new SectionBaseStudentsFragment("Section C");
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Section A";
        }
        else if (position == 1)
        {
            title = "Section B";
        }
        else if (position == 2)
        {
            title = "Section c";
        }
        return title;
    }
}

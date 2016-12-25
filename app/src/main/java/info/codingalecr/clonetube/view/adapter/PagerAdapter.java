package info.codingalecr.clonetube.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import info.codingalecr.clonetube.view.fragments.DefaultTabFragment;
import info.codingalecr.clonetube.view.fragments.HomeTabFragment;

/**
 * Created by Alejandro on 12/24/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter{
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                HomeTabFragment home = new HomeTabFragment();
                return home;

            default:
                DefaultTabFragment defecto = new DefaultTabFragment();
                return defecto;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

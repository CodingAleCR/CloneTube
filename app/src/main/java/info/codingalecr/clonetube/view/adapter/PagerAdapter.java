package info.codingalecr.clonetube.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

import info.codingalecr.clonetube.R;
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
        TextView titulo;
        switch (position) {
            case 0:
                HomeTabFragment home = new HomeTabFragment();
                return home;

            case 1:
                DefaultTabFragment trend = new DefaultTabFragment();
                return trend;

            case 2:
                DefaultTabFragment subs = new DefaultTabFragment();
                return subs;

            case 3:
                DefaultTabFragment profile = new DefaultTabFragment();
                return profile;

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

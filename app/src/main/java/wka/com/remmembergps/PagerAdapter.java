package wka.com.remmembergps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import wka.com.remmembergps.Fragments.GpsStatusFragment;
import wka.com.remmembergps.Fragments.MapFragment;

/**
 * Created by slave00 on 6/2/16.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: return GpsStatusFragment.newInstance();
            case 1: return MapFragment.newInstance();
            default: return MapFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

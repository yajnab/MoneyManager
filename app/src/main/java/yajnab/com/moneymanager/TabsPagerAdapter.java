package yajnab.com.moneymanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by yajnavalkya on 29/6/16.
 */
public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TabsPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new mhome();
            case 1:
                return new mcredit();
            case 2:
                return new mdebit();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
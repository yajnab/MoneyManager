package yajnab.com.moneymanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by yajnavalkya on 29/6/16.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new mcredit();
            case 1:
                return new mdebit();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

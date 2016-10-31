package lanou.foodpie.eat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/31.
 */
public class EatAdapter extends FragmentPagerAdapter{
    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    ArrayList<Fragment>fragments;

    String[]strings = {"首页","评测","知识","美食"};

    public EatAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments ==null?0 :fragments.size() ;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}

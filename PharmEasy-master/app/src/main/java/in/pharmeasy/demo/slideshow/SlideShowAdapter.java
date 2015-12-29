package in.pharmeasy.demo.slideshow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;      

public class SlideShowAdapter extends FragmentStatePagerAdapter {
    private int mCount;

    public SlideShowAdapter(FragmentManager fragmentManager, int count) {
        super(fragmentManager);
        mCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        return SlideFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mCount;
    }
}

package in.pharmeasy.demo.slideshow;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.pharmeasy.demo.R;
import in.pharmeasy.demo.data.model.Medicine;


public class SlideShowActivity extends AppCompatActivity implements SlideShowView {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.pager)
    ViewPager mPager;
    @Bind(R.id.tv_info)
    TextView mTvInfo;

    private SlideShowModel mModel;
    private SlideShowAdapter mAdapter;

    private ViewPager.OnPageChangeListener mPageSelectionListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            mTvInfo.setText(String.format("%1$d/%2$d", position + 1, mAdapter.getCount()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mPager.addOnPageChangeListener(mPageSelectionListener);

        mModel = new SlideShowModel(this);
        mModel.load();
    }

    @Override
    public void slideShow(List<Medicine> medicines) {
        mAdapter = new SlideShowAdapter(getSupportFragmentManager(), medicines.size());
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(0);
        mPageSelectionListener.onPageSelected(0);
    }

    public Medicine getMedicine(int position) {
        return mModel.getMedicine(position);
    }


}

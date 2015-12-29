package in.pharmeasy.demo.splash;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.pharmeasy.demo.R;
import in.pharmeasy.demo.data.RealmInteractor;
import in.pharmeasy.demo.io.SyncHelper;
import in.pharmeasy.demo.slideshow.SlideShowActivity;
import in.pharmeasy.demo.slideshow.SlideShowView;

public class SplashActivity extends AppCompatActivity implements SplashView{

    @Bind(R.id.progress)
    ProgressBar mProgress;

    private SplashModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mModel = new SplashModel(this);
        mModel.load();

    }

    @Override
    public void navigateToSlideShow() {
        if(isFinishing()) return;
        Intent intent = new Intent(this, SlideShowActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }
}

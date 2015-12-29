package in.pharmeasy.demo.splash;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

import in.pharmeasy.demo.data.RealmInteractor;
import in.pharmeasy.demo.io.SyncHelper;

public class SplashModel {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    private Context mContext;
    private SplashView mView;

    public SplashModel(SplashView view) {
        mView = view;
        mContext = (Context) mView;
    }

    public void load() {
        if (new RealmInteractor(mContext).hasData()) {
            splashDelay();
        } else {
            dataSync();
        }
    }

    private void splashDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.navigateToSlideShow();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void dataSync() {
        new AsyncTask<Void, Boolean, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mView.showProgress();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                return SyncHelper.sync(mContext.getApplicationContext());
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                mView.hideProgress();
                if (aBoolean == Boolean.TRUE) {
                    mView.navigateToSlideShow();
                }
            }
        }.execute();
    }
}

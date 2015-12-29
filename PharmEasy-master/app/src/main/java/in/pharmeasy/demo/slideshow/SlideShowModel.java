package in.pharmeasy.demo.slideshow;

import android.content.Context;
import android.util.Log;

import java.util.List;

import in.pharmeasy.demo.data.model.Medicine;
import in.pharmeasy.demo.data.RealmInteractor;


public class SlideShowModel {

    private static final String TAG = "SlideShowModel";

    private final Context mContext;
    private SlideShowView mView;
    private List<Medicine> mMedicines;

    public SlideShowModel(SlideShowView view) {
        mView = view;
        mContext = (Context) mView;
    }

    public void load() {
        getMedicines();

    }

    public Medicine getMedicine(int position) {
        return mMedicines.get(position);
    }

    private void getMedicines() {
        RealmInteractor realmInteractor = new RealmInteractor(mContext);
        mMedicines = realmInteractor.getMedicines();
        Log.d(TAG, "getMedicines() mMedicines.size() = " + mMedicines.size());
        mView.slideShow(mMedicines);
    }

}

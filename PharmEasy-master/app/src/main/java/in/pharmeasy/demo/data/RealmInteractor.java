package in.pharmeasy.demo.data;

import android.content.Context;

import com.google.gson.JsonArray;

import java.util.List;

import in.pharmeasy.demo.data.model.Medicine;
import io.realm.Realm;

public class RealmInteractor {

    private Realm mRealm;

    public RealmInteractor(Context context) {
        mRealm = Realm.getInstance(context);
    }

    public void setMedicines(JsonArray jsonArray){
        mRealm.beginTransaction();
        mRealm.createOrUpdateAllFromJson(Medicine.class, jsonArray.toString());
        mRealm.commitTransaction();
    }

    public List<Medicine> getMedicines(){
        return mRealm.where(Medicine.class).findAll();
    }

    public boolean hasData() {
        return mRealm.where(Medicine.class).count() > 0;
    }
}

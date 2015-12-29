package in.pharmeasy.demo.io;

import android.content.Context;

import com.google.gson.JsonArray;

import java.io.IOException;

import in.pharmeasy.demo.data.RealmInteractor;

public class SyncHelper {

    public static boolean sync(Context context){
        try {
            JsonArray result = fetchMedicines();
            if(result != null){
                setMedicines(context, result);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static JsonArray fetchMedicines() throws IOException {
        RetrofitInteractor interactor = new RetrofitInteractor();
        JsonArray result = interactor.searchAutoComplete("b", 1000000);
        return result;
    }

    private static void setMedicines(Context context, JsonArray jsonArray) {
        RealmInteractor realmInteractor = new RealmInteractor(context);
        realmInteractor.setMedicines(jsonArray);
    }
}

package in.pharmeasy.demo.io;

import com.google.gson.JsonArray;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import in.pharmeasy.demo.io.model.SearchResult;
import in.pharmeasy.demo.utils.TimberLoggingInterceptor;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class RetrofitInteractor {

    public JsonArray searchAutoComplete(String keyword, int pageSize) throws IOException {
        final ApiService apiService = getApiService();
        Call<SearchResult> call = apiService.searchAutoComplete(keyword, pageSize);
        Response<SearchResult> response = call.execute();
        if (response.isSuccess()) {
            return response.body().getResult();
        }
        return null;
    }


    public static ApiService getApiService() {
        OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(1, TimeUnit.MINUTES);
        client.setWriteTimeout(1, TimeUnit.MINUTES);
        client.setConnectTimeout(1, TimeUnit.MINUTES);
        client.interceptors().add(new TimberLoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.1mg.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final ApiService service = retrofit.create(ApiService.class);
        return service;
    }
}

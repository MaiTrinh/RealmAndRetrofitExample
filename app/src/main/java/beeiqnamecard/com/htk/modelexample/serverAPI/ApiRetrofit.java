package beeiqnamecard.com.htk.modelexample.serverAPI;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trinh on 07/02/2017.
 */

public class ApiRetrofit {
    private static ApiRetrofit mBeeIQServiceAPI = null;
    private static APIInterface mAPIInterface = null;
    private final String TAG = "BeeIQServiceAPI";
    private String domain, token;
    private Context mContext;

    public static ApiRetrofit getInstance() {
        if (mBeeIQServiceAPI == null) {
            mBeeIQServiceAPI = new ApiRetrofit();
        } else {

        }
        return mBeeIQServiceAPI;
    }

    public static APIInterface initAPIService() {
        if (mAPIInterface == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            // add logging as last interceptor
            builder.addInterceptor(logging);

            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://beeiq.co")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build();
            mAPIInterface = retrofit.create(APIInterface.class);
        }
        return mAPIInterface;
    }
}

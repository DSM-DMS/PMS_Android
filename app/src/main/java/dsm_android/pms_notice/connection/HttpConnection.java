package dsm_android.pms_notice.connection;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dsm2016 on 2017-08-08.
 */

public class HttpConnection {

    private static OkHttpClient client;

    public static Service getInstance() {
        if (client == null) {
            client = new OkHttpClient.Builder().build();
        }

        return new Retrofit.Builder()
                .baseUrl(Service.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service.class);
    }
}

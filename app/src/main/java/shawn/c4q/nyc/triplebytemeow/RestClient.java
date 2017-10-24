package shawn.c4q.nyc.triplebytemeow;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static shawn.c4q.nyc.triplebytemeow.CatApi.BASE_URL;

/**
 * Created by shawnspeaks on 10/24/17.
 */

public class RestClient {

    private static CatApi instance;

    public static CatApi getInstance(){
        if(instance == null){
            Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(BASE_URL)
                                        .client(new OkHttpClient())
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                        .build();


            instance = retrofit.create(CatApi.class);
        }
     return instance;
    }

}
